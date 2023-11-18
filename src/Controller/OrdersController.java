package Controller;
import Entities.*;
import Repository.OrdersRepo;

import java.util.ArrayList;
import java.util.List;

public class OrdersController {
    private OrdersRepo ordersRepo;

    public OrdersController(OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    public OrdersRepo getOrdersRepo() {
        return ordersRepo;
    }

    public void setOrdersRepo(OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }


    public List<Orders> loadOrders() {
        return ordersRepo.loadOrders();
    }

    public void saveOneObj(Orders order ){ordersRepo.saveOneObj(order);}

    public void deleteObj(Orders orders){ ordersRepo.deleteObj(orders);}

    public void save() {
        Orders o1 = new Orders(1, 12, 120, "cash", "Gruia 15", "10.12.2022");
        Orders o2 = new Orders(2, 13 ,100, "card", "Dornei 10", "24.05.2023");
        Orders o3 = new Orders(3, 15, 98, "card", "Horea 10", "14.09.2023");
        List<Orders> orders = new ArrayList<>();
        orders.add(o1);
        orders.add(o2);
        orders.add(o3);


        ordersRepo.save(orders);
    }

    public List<Orders> findAll() {
        return ordersRepo.loadOrders();
    }

    public Orders findById(int Id) {

        return ordersRepo.findById(Id);
    }

    public void delete(int id) {
        ordersRepo.delete(id);
    }

    public void updateTheOrders(int id, Orders orders) {
        ordersRepo.update(id, orders);
    }



    public void updateAddress(int id, String address){
        ordersRepo.updateAddress(id, address);
    }

    public void updatetePaymentMethod(int id, String paymentMethod){
        ordersRepo.updatetePaymentMethod(id, paymentMethod);
    }


    public List<Orders> filteredByDate(String date) {
       return ordersRepo.filteredByDate(date);

    }





    public void addArticleToOrder(Orders order, int id){
        ordersRepo.addArticleToOrder(order, id);
    }

    public void removeArticleToOrder(Orders order, int id){
        ordersRepo.removeArticleToOrder(order, id);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        ordersRepo.setPaymentStrategy(paymentStrategy);
    }

    public void processPayment() {
        ordersRepo.processPayment();
    }



}
