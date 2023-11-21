package Repository;
import Entities.Courier;
import Entities.Order;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class CourierRepo extends AbstractRepo {
    public CourierRepo(String fileName){
        super(fileName);

    }
    @Override
    public void save(List objects) {
        super.save(objects);
    }
    public void saveOneObject(Courier courier) {
        List<Courier> couriers = loadCourier();
        Iterator<Courier> iterator = couriers.iterator();

        while (iterator.hasNext()) {
            Courier item = iterator.next();
            if (item.getId() == courier.getId()) {
                iterator.remove();
            }
        }

        couriers.add(courier);
        save(couriers);
    }


    public void deleteObj(Courier courier){
        List<Courier> allCourier =loadCourier();
        allCourier.remove(courier);
        save(allCourier);
    }

    public List<Courier> loadCourier() {
        Type courierListType = new TypeToken<List<Courier>>() {}.getType();
        return load(courierListType);
    }

    public List<Courier> findAll(){
        return loadCourier();
    }


    public Courier findById(int Id){
        List<Courier> allCourier = loadCourier();
        Courier foundItem = null;
        for(Courier item : allCourier){
            if(item.getId() == Id)
                foundItem =item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        List<Courier> courierList = loadCourier();
        Courier foundItem = null;
        int indexToRemove = -1;

        for (int i = 0; i < courierList.size(); i++) {
            Courier item = courierList.get(i);
            if (item.getId() == Id) {
                foundItem = item;
                indexToRemove = i;
                break;
            }
        }

        if (foundItem != null && indexToRemove != -1) {
            courierList.remove(indexToRemove);
            save(courierList);
            System.out.println( Id + " has been deleted.");
        } else {
            System.out.println(Id + " not found.");
        }
    }




    public void addOrderToCurier( Courier courier, Order order){
        courier.addOrders(order);
        saveOneObject(courier);
    }

    public void removeOrderToCourier(Courier courier, Order order){
        courier.removeOrders(order);
        saveOneObject(courier);
    }

    public void updateSalary(int id, String salary){
        List<Courier> courierList = loadCourier();
        boolean found = false;

        for (int i = 0; i < courierList.size(); i++) {
            Courier courier = courierList.get(i);
            if (courier.getId() == id) {
                courier.setSalary(salary);
                found = true;
                break;
            }
        }
        if (found) {
            save(courierList);
            System.out.println("Courier with ID " + id + " has been updated.");
        } else {
            System.out.println("Courier with ID " + id + " not found.");
        }
    }

    public void updateteTelefon(int id, double telefon){
        List<Courier> courierList = loadCourier();
        boolean found = false;

        for (int i = 0; i < courierList.size(); i++) {
            Courier courier = courierList.get(i);
            if (courier.getId() == id) {
                courier.setTelefon(telefon);
                found = true;
                break;
            }
        }
        if (found) {
            save(courierList);
            System.out.println("Courier with ID " + id + " has been updated.");
        } else {
            System.out.println("Courier with ID " + id + " not found.");
        }
    }



    public void updateteOrders(int id, Order order, Order newOrder) {
        List<Courier> courierList = loadCourier();
        boolean found = false;

        for (int i = 0; i < courierList.size(); i++) {
            Courier courier = courierList.get(i);
            if (courier.getId() == id) {
                List<Order> orders = courier.getOrders();
                for (int j = 0; j <=orders.size(); j++)
                    if (orders.get(j) == order) {
                        orders.set(j, newOrder);
                        found = true;
                        break;
                    }
            }
        }
        if (found) {
            save(courierList);
            System.out.println("Order has been updated.");
        } else {
            System.out.println("Order not found.");
        }
    }




}