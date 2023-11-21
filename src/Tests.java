import Controller.*;
import DB_Controller.ArticleControllerDB;
import DB_Repo.ArticleRepoDB;
import Entities.*;
import Repository.*;
import UI.*;

import java.util.List;

public class Tests {
    String orderFile ="OrdersFile.json";
    String specificationFile = "SpecificationsFile.json";
    String cartFile = "CartFile.json";
    String warehouseFile = "WarehouseFile.json";
    String reviewFile = "ReviewFile.json";
    String ArticleFile= "ArticlesFile.json";
    String ClientFile="ClientFile.json";
    String courierFile="CourierFile.json";
    String employeeFile="EmployeesFile.json";
    String supplierFile="SuppliersFile.json";


    SpecificationsRepo specificationsRepo = new SpecificationsRepo(specificationFile);
    SpecificationsController specificationsController = new SpecificationsController(specificationsRepo);
    SpecificationsUI specificationsUI=new SpecificationsUI(specificationsController);

    ReviewRepo reviewRepo = new ReviewRepo(reviewFile);
    ReviewController reviewController = new ReviewController(reviewRepo);
    ReviewUI reviewUI= new ReviewUI(reviewController);

    SuppliersRepo suppliersRepo = new SuppliersRepo(supplierFile);
    SuppliersController suppliersController = new SuppliersController(suppliersRepo);
    SuppliersUI suppliersUI =new SuppliersUI(suppliersController);


    ArticlesRepo ar = new ArticlesRepo(ArticleFile);
    ArticlesController ac = new ArticlesController(ar,specificationsRepo, reviewRepo);
    ArticlesUI articlesUI= new ArticlesUI(ac);

    CartRepo cr = new CartRepo(cartFile);
    CartController cc = new CartController(cr, ar);
    CartUI cartUI= new CartUI(cc);

    OrderRepo orderRepo = new OrderRepo(orderFile);
    OrdersController ordersController = new OrdersController(orderRepo, ar);
    OrdersUI ordersUI = new OrdersUI(ordersController);

    ClientRepo clientRepo = new ClientRepo(ClientFile);
    ClientController clientController = new ClientController(clientRepo, reviewRepo, cr, orderRepo);
    ClientUI clientUI = new ClientUI(clientController);

    CourierRepo courierRepo = new CourierRepo(courierFile);
    EmployeesRepo er = new EmployeesRepo(employeeFile);

    WorkersFactory workersFactory = new WorkersFactory();
    WorkersController ec = new WorkersController(er, workersFactory, courierRepo, orderRepo);
    WorkersUI workersUI = new WorkersUI(ec);



    WarehouseRepo warehouseRepo = new WarehouseRepo(warehouseFile);
    WarehouseController warehouseController = new WarehouseController(warehouseRepo, er, ar, suppliersRepo, courierRepo);
    WarehouseUI warehouseUI= new WarehouseUI(warehouseController);

    String connectionString = "jdbc:mysql://localhost:3306/onlineshop";
    String username = "shop_user";
    String password = "shop_pass";

    ArticleRepoDB articleRepo = new ArticleRepoDB(connectionString, username, password);
    ArticleControllerDB articleController= new ArticleControllerDB(articleRepo);


    OrderBillingSystem orderBillingSystem = OrderBillingSystem.getInstance();

   public void testSortAsc(){
       List<Articles> sortedArticles=ac.sortPriceAsc();

       assert(sortedArticles.get(0).getPrice()==100);
   }


   public void testFillters(){
       List<Client> fillteredClients = clientController.filteredByName("Mark");

       assert(fillteredClients.size() == 2);
   }

   public void testFactory(){
       ec.saveOneObject(10, "Ion", "13009", 12345.6789, "OrdersManagement");
       assert(ec.findEmployeeById(10) != null);

       ec.saveOneObject(20, "Maria", "4500", 0789.3457, "Courier");
       assert(courierRepo.findById(20)!=null);

   }

   public void testObserver(){
       Cart cart = cr.findById(1);

       Client client = new Client(30, "Maria","Horea", 12345.67890 );
       Articles article = ar.findById(5);

       ClientCartObserver clientCartObserver = new ClientCartObserver(client);


       assert(cr.getObservers(cart) == clientCartObserver);
       cr.updatePriceArticle(1, 1, 30);
   }

    public void testStrategy() {
        Order order = orderRepo.findById(1);

        if ("Cash".equals(order.getPaymentMethod())) {
            order.setPaymentStrategy(new CashOnDelieveryStrategy());
        } else {
            order.setPaymentStrategy(new CreditCardPaymentStrategy("1234.5678")); // Set the credit card number
        }
        order.processPayment();
    }


    public void testLoad_db(){

        List<Articles> articlesList = articleController.loadFromDB();
        assert(articlesList.size() == 4);
    }

    public void testUpdate_find(){
       articleController.updatePrice(10, 200);
       Articles article1 = articleController.findById(10);
       assert(article1.getPrice() == 200);
    }



}
