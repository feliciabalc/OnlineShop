package Repository;

import Entities.Articles;
import Entities.Courier;
import Entities.Employee;
import Entities.Orders;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class OrdersRepo extends AbstractRepo {
    public OrdersRepo(String fileName) {

        super(fileName);
    }

    @Override
    public void save(List objects) {
        super.save(objects);
    }

    public void saveOneObj(Orders order){
        List<Orders> orders =loadOrders();
        for(Orders item : orders)
            if(item.getId()== order.getId())
                item = order;
            else
                orders.add(order);
        save(orders);
    }

    public void deleteObj(Orders orders){
        List<Orders> allOrders =loadOrders();
        allOrders.remove(orders);
        save(allOrders);
    }

    public List<Orders> loadOrders() {
        Type orderListType = new TypeToken<List<Orders>>() {}.getType();
        return load(orderListType);
    }

    public List<Orders> findAll(){
        return loadOrders();
    }


    public Orders findById(int Id){
        List<Orders> allOrders = loadOrders();
        Orders foundItem = null;
        for(Orders item : allOrders){
            if(item.getId() == Id)
                foundItem =item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        List<Orders> orderList = loadOrders();
        Orders foundItem = null;
        int indexToRemove = -1;

        for (int i = 0; i < orderList.size(); i++) {
            Orders item = orderList.get(i);
            if (item.getId() == Id) {
                foundItem = item;
                indexToRemove = i;
                break;
            }
        }

        if (foundItem != null && indexToRemove != -1) {
            orderList.remove(indexToRemove);
            save(orderList);
            System.out.println( Id + " has been deleted.");
        } else {
            System.out.println(Id + " not found.");
        }
    }



    public void update(int id, Orders updatedOrders) {
        List<Orders> orderList = loadOrders();
        boolean found = false;

        for (int i = 0; i < orderList.size(); i++) {
            Orders order = orderList.get(i);
            if (order.getId() == id) {
                order.setOrderNumber(updatedOrders.getOrderNumber());
                order.setTotalAmount(updatedOrders.getTotalAmount());
                order.setPaymentMethod(updatedOrders.getPaymentMethod());
                order.setAddress(updatedOrders.getAddress());
                order.setDate(updatedOrders.getDate());
                found = true;
                break;
            }
        }
        if (found) {
            save(orderList);
            System.out.println( id + " has been updated.");
        } else {
            System.out.println( id + " not found.");
        }
    }

    public void addEmployeeToOrder(Employee employee, Orders order){
        order.addEmployee(employee);
        saveOneObj(order);
    }

    public void removeEmployeeToOrder(Employee employee, Orders order){
        order.removeEmployee(employee);
        saveOneObj(order);
    }

    public void addArticleToOrder(Articles article, Orders order){
        order.addArticle(article);
        saveOneObj(order);
    }

    public void removeArticleToOrder(Articles article, Orders order){
        order.removeArticle(article);
        saveOneObj(order);
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