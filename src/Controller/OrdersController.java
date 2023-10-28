package Controller;
import Entities.Orders;
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

    public void save(List<Orders> orders) {
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
        List<Orders> ordersList = loadOrders();
        boolean found = false;

        for (int i = 0; i < ordersList.size(); i++) {
            Orders orders = ordersList.get(i);
            if (orders.getId() == id) {
                orders.setAddress(address);
                found = true;
                break;
            }
        }
        if (found) {
            save(ordersList);
            System.out.println("Order with ID " + id + " has been updated.");
        } else {
            System.out.println("Order with ID " + id + " not found.");
        }
    }

    public void updatetePaymentMethod(int id, String paymentMethod){
        List<Orders> ordersList = loadOrders();
        boolean found = false;

        for (int i = 0; i < ordersList.size(); i++) {
            Orders orders = ordersList.get(i);
            if (orders.getId() == id) {
                orders.setPaymentMethod(paymentMethod);
                found = true;
                break;
            }
        }
        if (found) {
            save(ordersList);
            System.out.println("Orders with ID " + id + " has been updated.");
        } else {
            System.out.println("Orders with ID " + id + " not found.");
        }
    }


    public List<Orders> filteredByDate(String date) {
        List<Orders> orders = loadOrders();
        List<Orders> filteredOrders = new ArrayList<>();
        for (Orders item : orders) {
            if (item.getDate() == date)
                filteredOrders.add(item);
        }
        return filteredOrders;

    }
}
