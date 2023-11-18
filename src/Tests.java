import Controller.ArticlesController;
import Controller.ClientController;
import Controller.WorkersController;
import Entities.*;
import Repository.*;

import java.util.List;

public class Tests {
    String orderFile ="OrdersFile.json";
    String specificationFile = "SpecificationsFile.json";
    String cartFile = "CartFile.json";
    String reviewFile = "ReviewFile.json";
    String ArticleFile= "ArticlesFile.json";
    String ClientFile="ClientFile.json";
    String courierFile="CourierFile.json";
    String employeeFile="EmployeesFile.json";

   public void testSortAsc(){
       ArticlesRepo articlesRepo = new ArticlesRepo(ArticleFile,specificationFile,reviewFile);
       ArticlesController ac = new ArticlesController(articlesRepo);
       List<Articles> sortedArticles=ac.sortPriceAsc();

       assert(sortedArticles.get(0).getPrice()==100);
   }


   public void testFillters(){
       ClientRepo clientRepo = new ClientRepo(ClientFile,ArticleFile,specificationFile, reviewFile,cartFile,orderFile);
       ClientController cc = new ClientController(clientRepo);
       List<Client> fillteredClients = cc.filteredByName("Mark");

       assert(fillteredClients.size() == 2);
   }

   public void testFactory(){
       EmployeesRepo employeesRepo = new EmployeesRepo(employeeFile,specificationFile,reviewFile,ArticleFile, orderFile);
       CourierRepo courierRepo = new CourierRepo(courierFile,specificationFile,reviewFile,ArticleFile,orderFile);
       WorkersFactory workersFactory = new WorkersFactory();
       WorkersController workersController = new WorkersController(employeesRepo, courierRepo, workersFactory);

       workersController.saveOneObject(10, "Ion", "13009", 12345.6789, "OrdersManagement");
       assert(workersController.findEmployeeById(10) != null);

       workersController.saveOneObject(20, "Maria", "4500", 0789.3457, "Courier");
       assert(courierRepo.findById(20)!=null);

   }

   public void testObserver(){
       CartRepo cartRepo = new CartRepo(cartFile, specificationFile, ArticleFile,reviewFile);
       Cart cart = cartRepo.findById(1);

       Client client = new Client(30, "Maria","Horea", 12345.67890 );


       String orderFile ="OrdersFile.json";
       String specificationFile = "SpecificationsFile.json";
       String cartFile = "CartFile.json";
       String warehouseFile = "WarehouseFile.json";
       String reviewFile = "ReviewFile.json";
       ArticlesRepo articlesRepo = new ArticlesRepo(ArticleFile,specificationFile,reviewFile);
       Articles article = articlesRepo.findById(5);

       ClientCartObserver clientCartObserver = new ClientCartObserver(client);


       assert(cartRepo.getObservers(cart) == clientCartObserver);
       cartRepo.updatePriceArticle(1, 1, 30);
   }

    public void testStrategy() {
        OrdersRepo ordersRepo = new OrdersRepo(orderFile,specificationFile,reviewFile,ArticleFile);
        Orders order = ordersRepo.findById(1);

        if ("Cash".equals(order.getPaymentMethod())) {
            order.setPaymentStrategy(new CashOnDelieveryStrategy());
        } else {
            order.setPaymentStrategy(new CreditCardPaymentStrategy("1234.5678")); // Set the credit card number
        }
        order.processPayment();
    }



}
