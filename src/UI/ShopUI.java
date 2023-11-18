package UI;
import Controller.*;
import Entities.*;
import Repository.*;

import java.util.List;
import java.util.Scanner;

public class ShopUI {
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

    ArticlesRepo ar = new ArticlesRepo(ArticleFile,specificationFile,reviewFile);
    ArticlesController ac = new ArticlesController(ar);
    ArticlesUI articlesUI= new ArticlesUI(ac);

    ClientRepo clientRepo = new ClientRepo(ClientFile, ArticleFile, specificationFile,  reviewFile,  cartFile,  orderFile);
    ClientController clientController = new ClientController(clientRepo);
    ClientUI clientUI = new ClientUI(clientController);

    CourierRepo courierRepo = new CourierRepo(courierFile, specificationFile,reviewFile, ArticleFile,orderFile);
    EmployeesRepo er = new EmployeesRepo(employeeFile,specificationFile, reviewFile, ArticleFile,orderFile);

    WorkersFactory workersFactory = new WorkersFactory();
    WorkersController ec = new WorkersController(er, courierRepo, workersFactory);
    WorkersUI workersUI = new WorkersUI(ec);


    CartRepo cr = new CartRepo(cartFile,specificationFile, ArticleFile, reviewFile);
    CartController cc = new CartController(cr);
    CartUI cartUI= new CartUI(cc);


    OrdersRepo ordersRepo = new OrdersRepo(orderFile,specificationFile, reviewFile,ArticleFile);
    OrdersController ordersController = new OrdersController(ordersRepo);
    OrdersUI ordersUI = new OrdersUI(ordersController);

    ReviewRepo reviewRepo = new ReviewRepo(reviewFile);
    ReviewController reviewController = new ReviewController(reviewRepo);
    ReviewUI reviewUI= new ReviewUI(reviewController);

    SuppliersRepo suppliersRepo = new SuppliersRepo(supplierFile);
    SuppliersController suppliersController = new SuppliersController(suppliersRepo);
    SuppliersUI suppliersUI =new SuppliersUI(suppliersController);

    WarehouseRepo warehouseRepo = new WarehouseRepo(warehouseFile,specificationFile,reviewFile, courierFile,ArticleFile,employeeFile, supplierFile, orderFile);
    WarehouseController warehouseController = new WarehouseController(warehouseRepo);
    WarehouseUI warehouseUI= new WarehouseUI(warehouseController);


    OrderBillingSystem orderBillingSystem = OrderBillingSystem.getInstance();




    public void startMenu() {

        articlesUI.saveArticles();
        clientUI.save();
        cartUI.save();
        warehouseUI.save();
        reviewUI.save();
        ordersUI.save();
        workersUI.save();
        suppliersUI.save();
        workersUI.save();
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
        System.out.println("10.Remove article");
        System.out.println("11.Update article's price");
        System.out.println("12.Filter by brand");
        System.out.println("13. Filter by material");
        System.out.println("14.Sort by price");
        System.out.println("15. Filter clients by name");
        System.out.println("16.Exit");


        Scanner scanner = new Scanner(System.in);
        int input2;

    do{
        System.out.println("Enter your choice: ");
        input2 = Integer.parseInt(scanner.nextLine());
        switch(input2) {
            case 1:
                System.out.println(workersUI.findAll());
                break;
            case 2:
                System.out.println(suppliersUI.findAll());
                break;
            case 3:
                System.out.println(workersUI.findAll());
                break;
            case 4:
                System.out.println("Give me id, name, brand, material, type and price for the article");
                int id = Integer.parseInt(scanner.nextLine());
                String name = String.valueOf(scanner.nextLine());
                String material = String.valueOf(scanner.nextLine());
                String type = String.valueOf(scanner.nextLine());
                String brand = String.valueOf(scanner.nextLine());
                float price = Float.parseFloat((scanner.nextLine()));
                Articles newArticle = new Articles(id, name, brand, material, type, price);
                articlesUI.saveOneObject(newArticle);
                System.out.println("Article added successfully!");
                break;


            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;

            case 9:
                break;

            case 10:
                System.out.println("Enter article ID to delete:");
                int idArticle = Integer.parseInt(scanner.nextLine());
                articlesUI.deleteArticle(idArticle);
                break;

            case 11:
                System.out.println("Enter article ID to update price:");
                int id1 = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new price:");
                Float price1 = Float.valueOf(scanner.nextLine());

                articlesUI.updateArticlePrice(id1, price1);
                break;


            case 12:
                System.out.println("Enter brand to filter articles:");
                String brandFilter = scanner.nextLine();

                articlesUI.filterByBrand(brandFilter);
                break;

            case 13:
                System.out.println("Enter material to filter articles:");
                String materialFilter = scanner.nextLine();

                articlesUI.filterByMaterial(materialFilter);
                break;

            case 14:
                System.out.println("Enter 1 for sorting the price in ascending order or 2 for descending order");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1)
                    articlesUI.sortArticlesByPriceAsc();
                else
                    articlesUI.sortArticlesByPriceDesc();
                break;

            case 15:
                System.out.println("Enter the name you want the client to be filtered by: ");
                String givenName = scanner.nextLine();
                clientUI.filteredByName(givenName);
                break;


            case 16:
                System.out.println("Exiting Manager Menu.");
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }



       }while(input2 != 16);
    }

    public void clientMenu() {
        System.out.println("Client Menu");
        System.out.println("1.See all articles");
        System.out.println("2.See my cart");
        System.out.println("3.See my orders");
        System.out.println("4. Write review");
        System.out.println("5.Add article to my order");
        System.out.println("5.Add article to my cart");
        System.out.println("6.Place an order");
        System.out.println("7. Update address");
        System.out.println("8.Update article");
        System.out.println("9. Update cart quantity");
        System.out.println("10.Exit");
        Scanner myObj = new Scanner(System.in);
        int input2 = Integer.parseInt(myObj.nextLine());



            if (input2 == 1) {
                articlesUI.displayAllArticles();
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
                Scanner scanner = new Scanner(System.in);
                System.out.println("Give me id, number of stars, comment, date, your id and also the id of the reviewed article");
                int id = Integer.parseInt(scanner.nextLine());
                String stars = String.valueOf(scanner.nextLine());
                String comment = String.valueOf(scanner.nextLine());
                String date = String.valueOf(scanner.nextLine());

                int ClientId = Integer.parseInt(scanner.nextLine());
                int ArticleId = Integer.valueOf(Integer.parseInt(scanner.nextLine()));
                Review newR = new Review(id, stars, comment, date);
                reviewUI.addReview(newR);
                Client client  = clientUI.findById(ClientId);
                clientUI.addReviewToClient(client, newR.getId());
                Articles article = articlesUI.findById(ArticleId);
                articlesUI.addReviewToArticle(article, newR.getId());

            } else if (input2 == 5) {


            }else if (input2 == 6){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Give me your id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the order id: ");
                int orderId = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the order number: ");
                int orderNr = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the total amount of your order: ");
                float amount = Float.parseFloat(scanner.nextLine());
                System.out.println("What payment method do you choose: ");
                String paymentMethod = scanner.nextLine();
                System.out.println("Enter your address: ");
                String address = scanner.nextLine();
                System.out.println("Enter the date: ");
                String date = scanner.nextLine();

                Orders order = new Orders(orderId, orderNr, amount, paymentMethod,address,date);
                ordersUI.saveOneOrder(order);
                Client client = clientUI.findById(id);
                clientUI.addOrderToClient(client, order.getId());

                if ("Cash".equals(order.getPaymentMethod())) {
                    ordersUI.setPaymentStrategy(new CashOnDelieveryStrategy());
                } else {
                    System.out.println("Please enter your card number: ");
                    String cardNr = scanner.nextLine();
                    ordersUI.setPaymentStrategy(new CreditCardPaymentStrategy(cardNr)); // Set the credit card number
                }
                ordersUI.processPayment();
                orderBillingSystem.generateBill(order);
            } else if (input2 == 7) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter you id: ");
                int idClient= Integer.parseInt(scanner.nextLine());
                System.out.println("Enter you new address: ");
                String newAddress = scanner.nextLine();

                clientUI.updateAddress(idClient, newAddress);

            } else if(input2 == 8){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter cart ID to update articles:");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter article ID to update:");
                int articleId = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter id:");
                int newArticleid = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                System.out.println("Enter brand:");
                String brand = scanner.nextLine();
                System.out.println("Enter material:");
                String material = scanner.nextLine();
                System.out.println("Enter type:");
                String type = scanner.nextLine();
                System.out.println("Enter price:");
                float price = Float.parseFloat(scanner.nextLine());

                Articles newArticle = new Articles(id, name, brand, material, type, price);
                cartUI.updateArticles(id, articleId,newArticle);

                System.out.println("Cart articles updated successfully!");
            } else if (input2 == 9) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter cart ID to update quantity:");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new quantity:");
                double quantity = Double.parseDouble(scanner.nextLine());

                cartUI.updateQuantity(id, quantity);

            } else if (input2 == 10) {
                //break;
            } else
                System.out.println("Invalid choice");


    }
}
