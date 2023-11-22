package UI;

import Controller.ArticlesController;
import Controller.CartController;
import DB_Controller.*;
import DB_Repo.*;
import Entities.*;
import Repository.CourierRepo;
import Repository.SuppliersRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopUi_DB {
    String connectionString = "jdbc:mysql://localhost:3306/onlineshop";
    String username = "shop_user";
    String password = "shop_pass";

    ReviewRepoDB reviewRepo=new ReviewRepoDB(connectionString,username,password);
    ReviewControllerDB reviewController=new ReviewControllerDB(reviewRepo);

    SpecificationsRepoDB specificationsRepo=new SpecificationsRepoDB(connectionString,username,password);
    SpecificationsControllerDB specificationsController=new SpecificationsControllerDB(specificationsRepo);

    ArticleRepoDB articleRepo = new ArticleRepoDB(connectionString, username, password);
    ArticleControllerDB articleController= new ArticleControllerDB(articleRepo, specificationsRepo, reviewRepo);


    CartRepoDB cartRepo = new CartRepoDB(connectionString, username, password);
    CartControllerDB cartController= new CartControllerDB(cartRepo, articleRepo);

    OrderRepoDB orderRepo=new OrderRepoDB(connectionString,username,password);
    OrderControllerDB orderController=new OrderControllerDB(orderRepo);

    ClientRepoDB clientRepo = new ClientRepoDB(connectionString, username, password);
    ClientControllerDB clientController = new ClientControllerDB(clientRepo, orderRepo, reviewRepo, cartRepo);

    CourierRepoDB courierRepo = new CourierRepoDB(connectionString, username, password);
    CourierControllerDB courierController = new CourierControllerDB(courierRepo);

    EmployeeRepoDB employeeRepo = new EmployeeRepoDB(connectionString, username, password);
    EmployeeControllerDB employeeController=new EmployeeControllerDB(employeeRepo, orderRepo);



    SuppliersRepoDB suppliersRepo=new SuppliersRepoDB(connectionString,username,password);
    SuppliersControllerDB suppliersController=new SuppliersControllerDB(suppliersRepo);

    WarehouseRepoDB warehouseRepo=new WarehouseRepoDB(connectionString,username,password);
    WarehouseControllerDB warehouseController=new WarehouseControllerDB(warehouseRepo, articleRepo, suppliersRepo, courierRepo, employeeRepo);



    public void startMenu() {

        System.out.println("Welcome to our shop!");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your choice: 1. Manager. 2. Client. 3. Quit");


        int input = Integer.parseInt(myObj.nextLine());
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
        System.out.println("13.Sort by price");
        System.out.println("14. Filter clients by name");
        System.out.println("15.Exit");


        Scanner scanner = new Scanner(System.in);
        int input2;

        do{
            System.out.println("Enter your choice: ");
            input2 = Integer.parseInt(scanner.nextLine());
            switch(input2) {
                case 1:
                    System.out.println(employeeController.loadFromDB());
                    break;
                case 2:
                    System.out.println(suppliersController.loadFromDB());
                    break;
                case 3:
                    System.out.println(courierController.loadFromDB());
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
                    List<Articles> allArticles = new ArrayList<>();
                    allArticles.add(newArticle);
                    articleController.saveIntoDB(allArticles);
                    System.out.println("Article added successfully!");
                    break;


                case 5:
                    System.out.println("Give me id, name,role, salary and phone number for the employee");
                    int id2 = Integer.parseInt(scanner.nextLine());
                    String name2 = String.valueOf(scanner.nextLine());
                    String role = String.valueOf(scanner.nextLine());
                    String salary = String.valueOf(scanner.nextLine());
                    Double phone = Double.valueOf(scanner.nextLine());
                    Employee newEmployee = new Employee(id2, name2, salary, phone);
                    newEmployee.setRole(role);
                    List<Employee> employees = new ArrayList<>();
                    employees.add(newEmployee);
                    employeeController.saveIntoDB(employees);
                    System.out.println("Employee added successfully!");
                    break;
                case 6:
                    System.out.println("Give me id, name, salary and phone number for the courier");
                    int id3 = Integer.parseInt(scanner.nextLine());
                    String name3 = String.valueOf(scanner.nextLine());
                    String salary3 = String.valueOf(scanner.nextLine());
                    Double phone3 = Double.valueOf(scanner.nextLine());
                    Courier newCourier = new Courier(id3, name3, salary3, phone3);
                    newCourier.setRole("Courier");
                    List<Courier> couriers = new ArrayList<>();
                    couriers.add(newCourier);
                    courierController.saveIntoDB(couriers);
                    System.out.println("Courier added successfully!");
                    break;
                case 7:
                    System.out.println("Give me id, name, phone number and article type for the supplier");
                    int id4 = Integer.parseInt(scanner.nextLine());
                    String name4 = String.valueOf(scanner.nextLine());
                    Double phone4 = Double.valueOf(scanner.nextLine());
                    String articleType = String.valueOf(scanner.nextLine());
                    Suppliers newSupplier = new Suppliers(id4, name4, phone4, articleType);
                    List<Suppliers> suppliers1 = new ArrayList<>();
                    suppliers1.add(newSupplier);
                    suppliersController.saveIntoDB(suppliers1);
                    System.out.println("Supplieradded successfully!");
                    break;
                case 8:
                    System.out.println("Enter employee ID to delete:");
                    int idEmployee = Integer.parseInt(scanner.nextLine());
                    employeeController.delete(idEmployee);
                    break;

                case 9:
                    System.out.println("Enter supplier ID to delete:");
                    int idSupplier = Integer.parseInt(scanner.nextLine());
                    suppliersController.delete(idSupplier);
                    break;

                case 10:
                    System.out.println("Enter article ID to delete:");
                    int idArticle = Integer.parseInt(scanner.nextLine());
                    articleController.delete(idArticle);
                    break;

                case 11:
                    System.out.println("Enter article ID to update price:");
                    int id1 = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter new price:");
                    Float price1 = Float.valueOf(scanner.nextLine());

                    articleController.updatePrice(id1,price1);
                    break;


                case 12:
                    System.out.println("Enter brand to filter articles:");
                    String brandFilter = scanner.nextLine();

                    System.out.println(articleController.filterByBrand(brandFilter));
                    break;


                case 13:
                    System.out.println(articleController.sortByPriceAsc());
                    break;

                case 14:
                    System.out.println("Enter the name you want the client to be filtered by: ");
                    String givenName = scanner.nextLine();
                    clientController.filterByName(givenName);
                    break;


                case 15:
                    System.out.println("Exiting Manager Menu.");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }



        }while(input2 != 15);
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
        System.out.println("8. Update cart quantity");
        System.out.println("9.Exit");
        Scanner scanner = new Scanner(System.in);
        int input2;

        do {
            System.out.println("Enter your choice: ");
            input2 = Integer.parseInt(scanner.nextLine());
            switch (input2) {
                case 1:
                    System.out.println(articleController.loadFromDB());
                    break;

                case 2:
                    System.out.println("Please enter your id");
                    int id = Integer.parseInt(scanner.nextLine());
                    Client client = clientController.findById(id);
                    System.out.println(client.getCart());
                    break;

                case 3:
                    System.out.println("Please enter your id");
                    int id1 = Integer.parseInt(scanner.nextLine());
                    Client client1 = clientController.findById(id1);
                    System.out.println(client1.getOrders());
                    break;

                case 4:
                    System.out.println("Give me id, number of stars, comment, date, your id and also the id of the reviewed article");
                    int id2 = Integer.parseInt(scanner.nextLine());
                    String stars = String.valueOf(scanner.nextLine());
                    String comment = String.valueOf(scanner.nextLine());
                    String date = String.valueOf(scanner.nextLine());

                    int ClientId = Integer.parseInt(scanner.nextLine());
                    int ArticleId = Integer.valueOf(Integer.parseInt(scanner.nextLine()));
                    Review newR = new Review(id2, stars, comment, date);
                    List<Review> reviewList = new ArrayList<>();
                    reviewList.add(newR);
                    reviewController.saveIntoDB(reviewList);
                    Client client2 = clientController.findById(ClientId);
                    clientController.addReview(id2,ClientId);
                    Articles article =articleController.findById(ArticleId);
                    articleController.addReview(ArticleId, newR.getId());
                    break;

                case 5:
                    break;


                case 6:
                    System.out.println("Give me your id: ");
                    int id4 = Integer.parseInt(scanner.nextLine());
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
                    String date1 = scanner.nextLine();

                    Order order = new Order(orderId, orderNr, amount, paymentMethod, address, date1);
                    List<Order> orderList = new ArrayList<>();
                    orderController.saveIntoDB(orderList);

                    Client client4 = clientController.findById(id4);
                    clientController.addOrder(orderId, id4);
                    break;

                case 7:
                    System.out.println("Enter you id: ");
                    int idClient = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter you new address: ");
                    String newAddress = scanner.nextLine();

                    clientController.updateAddress(idClient, newAddress);
                    break;

                case 8:
                    System.out.println("Enter cart ID to update quantity:");
                    int id6 = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter new quantity:");
                    double quantity = Double.parseDouble(scanner.nextLine());

                    cartController.updateQuantity(id6, quantity);
                    break;

                case 9:
                    System.out.println("Exiting menu....");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }while(input2!=9);
    }
}

