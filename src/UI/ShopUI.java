package UI;
import Controller.*;
import Entities.*;
import Repository.*;
import UI.ArticlesUI;

import java.util.Scanner;

public class ShopUI {

    ArticlesRepo ar = new ArticlesRepo("ArticlesFile.json");
    ArticlesController ac = new ArticlesController(ar);
    ArticlesUI articlesUI= new ArticlesUI(ac);

    ClientRepo clientRepo = new ClientRepo("ClientFile.json");
    ClientController clientController = new ClientController(clientRepo);
    ClientUI clientUI = new ClientUI(clientController);

    CourierRepo courierRepo = new CourierRepo("CourierFile.json");
    CourierController courierController= new CourierController(courierRepo);
    CourierUI courierUI = new CourierUI(courierController);


    EmployeesRepo er = new EmployeesRepo("EmployeesFile.json");
    WorkersFactory workersFactory = new WorkersFactory();
    EmployeesController ec = new EmployeesController(er, courierRepo, workersFactory);
    EmployeeUI employeeUI = new EmployeeUI(ec);


    CartRepo cr = new CartRepo("CartFile.json");
    CartController cc = new CartController(cr);
    CartUI cartUI= new CartUI(cc);


    OrdersRepo ordersRepo = new OrdersRepo("OrdersFile.json");
    OrdersController ordersController = new OrdersController(ordersRepo);
    OrdersUI ordersUI = new OrdersUI(ordersController);

    ReviewRepo reviewRepo = new ReviewRepo("ReviewFile.json");
    ReviewController reviewController = new ReviewController(reviewRepo);
    ReviewUI reviewUI= new ReviewUI(reviewController);

    SpecificationsRepo specificationsRepo = new SpecificationsRepo("SpecificationsFile.json");
    SpecificationsController specificationsController = new SpecificationsController(specificationsRepo);
    SpecificationsUI specificationsUI=new SpecificationsUI(specificationsController);

    SuppliersRepo suppliersRepo = new SuppliersRepo("SuppliersFile.json");
    SuppliersController suppliersController = new SuppliersController(suppliersRepo);
    SuppliersUI suppliersUI =new SuppliersUI(suppliersController);

    WarehouseRepo warehouseRepo = new WarehouseRepo("WarehouseFile.json");
    WarehouseController warehouseController = new WarehouseController(warehouseRepo);
    WarehouseUI warehouseUI= new WarehouseUI(warehouseController);




    public void startMenu() {



        articlesUI.saveArticles();
        clientUI.save();
        cartUI.save();
        warehouseUI.save();
        reviewUI.save();
        ordersUI.save();
        employeeUI.save();
        suppliersUI.save();
        courierUI.save();
        specificationsUI.save();

        System.out.println("Welcome to our shop!");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter your choice: 1. Manager. 2. Client. 3. Quit");


        int input = Integer.parseInt(myObj.nextLine());  // Read user input
        if (input == 1)
            managerMenu();
        else if (input == 2) {
            clientMenu();

        } else if (input == 3) {
            System.out.println("Exiting...");
        } else
            System.out.println("Invalid choice!");
    }

    public void managerMenu() {
        System.out.println("Manager Menu");
        System.out.println("1.See all employees");
        System.out.println("2.See all suppliers");
        System.out.println("3.See all couriers");
        System.out.println("4. Add article");
        System.out.println("5.Add employee");
        System.out.println("6.Add courier");
        System.out.println("7.Add supplier");
        System.out.println("8.Remove employee");
        System.out.println("9.Remove supplier");
        System.out.println("10.Remove courier");
        //update, sort...

        Scanner myObj = new Scanner(System.in);


        ///pune in while
        int input2 = Integer.parseInt(myObj.nextLine());
        if (input2 == 1) {
            System.out.println(employeeUI.findAll());
        } else if (input2 == 2) {
            System.out.println(suppliersUI.findAll());
        } else if (input2 == 3) {
            System.out.println(courierUI.findAll());
        } else if (input2 == 4) {
            System.out.println("Give me id, name, brand, material, type and price for the article");
            int id = Integer.parseInt(myObj.nextLine());
            String name = String.valueOf(myObj.nextLine());
            String material = String.valueOf(myObj.nextLine());
            String type = String.valueOf(myObj.nextLine());
            String brand = String.valueOf(myObj.nextLine());
            float price = Float.parseFloat((myObj.nextLine()));
            Articles newArticle = new Articles(id, name, brand, material, type, price);
            articlesUI.saveOneObject(newArticle);


        } else if (input2 == 5) {

        } else if (input2 == 6) {

        } else if (input2 == 7) {

        } else if (input2 == 8) {

        } else if (input2 == 9) {

        } else if (input2 == 10) {

        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public void clientMenu() {
        System.out.println("Client Menu");
        System.out.println("1.See all articles");
        System.out.println("2.See my cart");
        System.out.println("3.See my orders");
        System.out.println("4. Write review");
        System.out.println("5.Add article to my order");
        System.out.println("5.Add article to my cart");
        System.out.println("Choose an option: ");
        Scanner myObj = new Scanner(System.in);
        int input2 = Integer.parseInt(myObj.nextLine());

        if (input2 == 1) {
            articlesUI.findAll();
        } else if (input2 == 2) {
            System.out.println("Please enter your id");
            int id = Integer.parseInt(myObj.nextLine());
            Client client = clientUI.findById(id);
            System.out.println(client.getCart());
        } else if (input2 == 3) {
            System.out.println("Please enter your id");
            int id = Integer.parseInt(myObj.nextLine());
            Client client = clientUI.findById(id);
            System.out.println(client.getOrders());
        } else if (input2 == 4) {
            System.out.println("Give me id, number of stars, comment, date, your id and also the id of the reviewed article");
            int id = Integer.parseInt(myObj.nextLine());
            String stars = String.valueOf(myObj.nextLine());
            String comment = String.valueOf(myObj.nextLine());
            String date = String.valueOf(myObj.nextLine());
            int ClientId = Integer.parseInt(myObj.nextLine());
            int ArticleId = Integer.valueOf(Integer.parseInt(myObj.nextLine()));
            Review newR = new Review(id, stars, comment, date);

            Articles article = articlesUI.findById(ArticleId);
            Client client = clientUI.findById(ClientId);
            newR.setArticle(article);
            newR.setClient(client);


        } else if (input2 == 5) {
            ////

        }


    }
}
