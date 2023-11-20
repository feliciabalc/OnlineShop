package Controller;
import Entities.*;
import Repository.ArticlesRepo;
import Repository.OrderRepo;

import java.util.ArrayList;
import java.util.List;

public class OrdersController {
    private OrderRepo orderRepo;

    private ArticlesRepo articlesRepo;

    public OrdersController(OrderRepo orderRepo, ArticlesRepo articlesRepo) {
        this.orderRepo = orderRepo;
        this.articlesRepo = articlesRepo;
    }

    public OrderRepo getOrdersRepo() {
        return orderRepo;
    }

    public void setOrdersRepo(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }


    public List<Order> loadOrders() {
        return orderRepo.loadOrders();
    }

    public void saveOneObj(Order order ){
        orderRepo.saveOneObj(order);}

    public void deleteObj(Order order){ orderRepo.deleteObj(order);}

    public void save() {
        Order o1 = new Order(1, 12, 120, "cash", "Gruia 15", "10.12.2022");
        Order o2 = new Order(2, 13 ,100, "card", "Dornei 10", "24.05.2023");
        Order o3 = new Order(3, 15, 98, "card", "Horea 10", "14.09.2023");
        List<Order> orders = new ArrayList<>();
        orders.add(o1);
        orders.add(o2);
        orders.add(o3);


        orderRepo.save(orders);
    }

    public List<Order> findAll() {
        return orderRepo.loadOrders();
    }

    public Order findById(int Id) {

        return orderRepo.findById(Id);
    }

    public void delete(int id) {
        orderRepo.delete(id);
    }

    public void updateTheOrders(int id, Order order) {
        orderRepo.update(id, order);
    }



    public void updateAddress(int id, String address){
        orderRepo.updateAddress(id, address);
    }

    public void updatetePaymentMethod(int id, String paymentMethod){
        orderRepo.updatetePaymentMethod(id, paymentMethod);
    }


    public List<Order> filteredByDate(String date) {
       return orderRepo.filteredByDate(date);

    }





    public void addArticleToOrder(Order order, int id){
        Articles article=articlesRepo.findById(id);
        orderRepo.addArticleToOrder(order, article);
    }

    public void removeArticleToOrder(Order order, int id){
        Articles article=articlesRepo.findById(id);
        orderRepo.removeArticleToOrder(order, article);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        orderRepo.setPaymentStrategy(paymentStrategy);
    }

    public void processPayment() {
        orderRepo.processPayment();
    }



}
