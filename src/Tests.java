import Controller.ArticlesController;
import Controller.ClientController;
import Controller.WorkersController;
import Entities.*;
import Repository.*;

import java.util.List;

public class Tests {

   public void testSortAsc(){
       ArticlesRepo articlesRepo = new ArticlesRepo("ArticlesFile.json");
       ArticlesController ac = new ArticlesController(articlesRepo);
       List<Articles> sortedArticles=ac.sortPriceAsc();

       assert(sortedArticles.get(0).getPrice()==100);
   }


   public void testFillters(){
       ClientRepo clientRepo = new ClientRepo("ClientFile.json");
       ClientController cc = new ClientController(clientRepo);
       List<Client> fillteredClients = cc.filteredByName("Mark");

       assert(fillteredClients.size() == 2);
   }

   public void testFactory(){
       EmployeesRepo employeesRepo = new EmployeesRepo("EmployeesFile.json");
       CourierRepo courierRepo = new CourierRepo("CourierFile.json");
       WorkersFactory workersFactory = new WorkersFactory();
       WorkersController workersController = new WorkersController(employeesRepo, courierRepo, workersFactory);

       workersController.saveOneObject(10, "Ion", "13009", 12345.6789, "OrdersManagement");
       assert(workersController.findEmployeeById(10) != null);

       workersController.saveOneObject(20, "Maria", "4500", 0789.3457, "Courier");
       assert(courierRepo.findById(20)!=null);

   }

   public void testObserver(){
       Cart cart = new Cart(25, 20);
       Client client = new Client(30, "Maria","Horea", 12345.67890 );

       ArticlesRepo articlesRepo = new ArticlesRepo("ArticlesFile.json");
       Articles article = articlesRepo.findById(5);

       ClientCartObserver clientCartObserver = new ClientCartObserver(client);
       cart.setClient(client);
       cart.addArticles(article);

       CartRepo cartRepo = new CartRepo("CartFile.json");
       cartRepo.saveOneObject(cart);

       assert(cartRepo.getObservers(cart) == clientCartObserver);
       cartRepo.updatePriceArticle(25, 10, 30);
   }

    public void testStrategy() {
        OrdersRepo ordersRepo = new OrdersRepo("OrdersFile.json");
        Orders order = ordersRepo.findById(1);

        if ("Cash".equals(order.getPaymentMethod())) {
            order.setPaymentStrategy(new CashOnDelieveryStrategy());
        } else {
            order.setPaymentStrategy(new CreditCardPaymentStrategy("1234.5678")); // Set the credit card number
        }
        order.processPayment();
    }



}
