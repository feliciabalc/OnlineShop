package Repository;

import Entities.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderRepo extends AbstractRepo {

    public OrderRepo(String fileName) {

        super(fileName);
    }

    @Override
    public void save(List objects) {
        super.save(objects);
    }

    public void saveOneObj(Order order) {
        List<Order> orders = loadOrders();
        boolean found = false;

        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order existingOrder = iterator.next();
            if (existingOrder.getId() == order.getId()) {
                iterator.remove(); // Use iterator to remove the order
                orders.add(order);
                found = true;
                break;
            }
        }

        if (!found) {
            orders.add(order);
        }

        save(orders);
    }



    public void deleteObj(Order order){
        List<Order> allOrders =loadOrders();
        allOrders.remove(order);
        save(allOrders);
    }

    public List<Order> loadOrders() {
        Type orderListType = new TypeToken<List<Order>>() {}.getType();
        return load(orderListType);
    }

    public List<Order> findAll(){
        return loadOrders();
    }


    public Order findById(int Id){
        List<Order> allOrders = loadOrders();
        Order foundItem = null;
        for(Order item : allOrders){
            if(item.getId() == Id)
                foundItem =item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        List<Order> orderList = loadOrders();
        Order foundItem = null;
        int indexToRemove = -1;

        for (int i = 0; i < orderList.size(); i++) {
            Order item = orderList.get(i);
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



    public void update(int id, Order updatedOrder) {
        List<Order> orderList = loadOrders();
        boolean found = false;

        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            if (order.getId() == id) {
                order.setOrderNumber(updatedOrder.getOrderNumber());
                order.setTotalAmount(updatedOrder.getTotalAmount());
                order.setPaymentMethod(updatedOrder.getPaymentMethod());
                order.setAddress(updatedOrder.getAddress());
                order.setDate(updatedOrder.getDate());
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



    public void addArticleToOrder(Order order, Articles article){
        order.addArticle(article);
        saveOneObj(order);
    }

    public void removeArticleToOrder(Order order, Articles article){
        order.removeArticle(article);
        saveOneObj(order);
    }



    public void updateAddress(int id, String address){
        List<Order> orderList = loadOrders();
        boolean found = false;

        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            if (order.getId() == id) {
                order.setAddress(address);
                found = true;
                break;
            }
        }
        if (found) {
            save(orderList);
            System.out.println("Order with ID " + id + " has been updated.");
        } else {
            System.out.println("Order with ID " + id + " not found.");
        }
    }

    public void updatetePaymentMethod(int id, String paymentMethod){
        List<Order> orderList = loadOrders();
        boolean found = false;

        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            if (order.getId() == id) {
                order.setPaymentMethod(paymentMethod);
                found = true;
                break;
            }
        }
        if (found) {
            save(orderList);
            System.out.println("Orders with ID " + id + " has been updated.");
        } else {
            System.out.println("Orders with ID " + id + " not found.");
        }

    }


    public List<Order> filteredByDate(String date) {
        List<Order> orders = loadOrders();
        List<Order> filteredOrders = new ArrayList<>();
        for (Order item : orders) {
            if (item.getDate() == date)
                filteredOrders.add(item);
        }
        return filteredOrders;

    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        setPaymentStrategy(paymentStrategy);
    }

    public void processPayment() {
        processPayment();
    }







}