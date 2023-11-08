package UI;

import Controller.OrdersController;
import Entities.*;
import Repository.ClientRepo;

import java.util.List;
import java.util.Scanner;

public class OrdersUI {
    private OrdersController ordersController;

    public OrdersUI(OrdersController ordersController) {
        this.ordersController = ordersController;
    }

    public OrdersController getOrdersController() {
        return ordersController;
    }

    public void setOrdersController(OrdersController ordersController) {
        this.ordersController = ordersController;
    }
    public List<Orders> loadOrders() {
        return ordersController.loadOrders();}

    public void save() {
        ordersController.save();}

    public  Orders addOneOrder() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Give me your id: ");
            int id = Integer.parseInt(scanner.nextLine());
            ClientRepo clientRepo = new ClientRepo("ClientFile.json");
            Client client = clientRepo.findById(id);
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
            order.setClient(client);
            ordersController.saveOneObj(order);
            return order;

    }catch (NumberFormatException e){
        handleUserInputError();}
        return null;
    }

    public void deleteObj(Orders orders){ ordersController.deleteObj(orders);}

    public List<Orders> findAll() {
        return ordersController.findAll();}

    public Orders findById(int Id) {
        return ordersController.findById(Id);}

    public void delete(int id){
        ordersController.delete(id);}

    public void updateTheOrders(int id, Orders orders){
        ordersController.updateTheOrders(id,orders);}

    public void updateAddress(int id, String address){
        ordersController.updateAddress(id,address);}

    public void updatetePaymentMethod(int id, String paymentMethod){
        ordersController.updatetePaymentMethod(id,paymentMethod);}

    public List<Orders> filteredByDate(String date) {
        return ordersController.filteredByDate(date);}

    public void addEmployeeToOrder(Employee employee, Orders order){
        ordersController.addEmployeeToOrder(employee,order);
    }

    public void removeEmployeeToOrder(Employee employee, Orders order){
        ordersController.removeEmployeeToOrder(employee,order);}

    public void addArticleToOrder(Articles article, Orders order){
        ordersController.addArticleToOrder(article, order);
    }

    public void removeArticleToOrder(Articles article, Orders order){
        ordersController.removeArticleToOrder(article, order);
    }
        public void handleUserInputError() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Consume the invalid input
        }
    }
