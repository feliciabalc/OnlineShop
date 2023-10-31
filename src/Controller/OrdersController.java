package Controller;
import Entities.Articles;
import Entities.Employee;
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

    public void saveOneObj(Orders order ){ordersRepo.saveOneObj(order);}

    public void save(List<Orders> orders) {
        Orders o1 = new Orders(1, 12, 120, "cash", "Gruia 15", "10.12.2022");
        Orders o2 = new Orders(2, 13 ,100, "card", "Dornei 10", "24.05.2023");
        Orders o3 = new Orders(3, 15, 98, "card", "Horea 10", "14.09.2023");

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

    public void addEmployeeToOrder(Employee employee, Orders order){

        ordersRepo.addEmployeeToOrder(employee,order);
    }

    public void removeEmployeeToOrder(Employee employee, Orders order){
        ordersRepo.removeEmployeeToOrder(employee,order);}



    public void addArticleToOrder(Articles article, Orders order){
        ordersRepo.addArticleToOrder(article, order);
    }

    public void removeArticleToOrder(Articles article, Orders order){
        ordersRepo.removeArticleToOrder(article, order);
    }
}
