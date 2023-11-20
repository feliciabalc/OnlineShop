package UI;

import Controller.OrdersController;
import Entities.*;

import java.util.List;

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

    public List<Order> loadOrders() {
        return ordersController.loadOrders();
    }

    public void save() {
        ordersController.save();
    }

    public void saveOneOrder(Order order){
        ordersController.saveOneObj(order);
    }
    public void deleteObj(Order order) {
        ordersController.deleteObj(order);
    }

    public List<Order> findAll() {
        return ordersController.findAll();
    }

    public Order findById(int Id) {
        return ordersController.findById(Id);
    }

    public void delete(int id) {
        ordersController.delete(id);
    }

    public void updateTheOrders(int id, Order order) {
        ordersController.updateTheOrders(id, order);
    }

    public void updateAddress(int id, String address) {
        ordersController.updateAddress(id, address);
    }

    public void updatetePaymentMethod(int id, String paymentMethod) {
        ordersController.updatetePaymentMethod(id, paymentMethod);
    }

    public List<Order> filteredByDate(String date) {
        return ordersController.filteredByDate(date);
    }



    public void addArticleToOrder(Order order, int id) {
        ordersController.addArticleToOrder(order, id);
    }

    public void removeArticleToOrder(Order order, int id) {
        ordersController.removeArticleToOrder(order, id);
    }



    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        ordersController.setPaymentStrategy(paymentStrategy);
    }

    public void processPayment() {
        ordersController.processPayment();
    }

}