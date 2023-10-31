package Controller;

import Entities.Articles;
import Entities.Cart;
import Entities.Courier;
import Entities.Orders;
import Repository.CourierRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CourierController {
    private CourierRepo courierRepo;

    public CourierController(CourierRepo courierRepo) {
        this.courierRepo = courierRepo;
    }

    public CourierRepo getCourierRepo() {
        return courierRepo;
    }

    public void setCourierRepo(CourierRepo courierRepo) {
        this.courierRepo = courierRepo;
    }


    public List<Courier> loadCourier() {
        return courierRepo.loadCourier();
    }

    public void save(List<Courier> couriers) {
        courierRepo.save(couriers);
    }

    public void saveOneObject(Courier courier){
        courierRepo.saveOneObject(courier);
    }

    public List<Courier> findAll() {
        return courierRepo.loadCourier();
    }

    public Courier findById(int Id) {

        return courierRepo.findById(Id);
    }

    public void delete(int id) {
        courierRepo.delete(id);
    }

    public void updateTheCourier(int id, Courier courier) {
        courierRepo.update(id, courier);
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

    public void updateteShippingAddress(int id, String address){
        List<Courier> courierList = loadCourier();
        boolean found = false;

        for (int i = 0; i < courierList.size(); i++) {
            Courier courier = courierList.get(i);
            if (courier.getId() == id) {
                courier.setShipping_Address(address);
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

    public void updateteOrders(int id, Orders order, Orders newOrder) {
        List<Courier> courierList = loadCourier();
        boolean found = false;

        for (int i = 0; i < courierList.size(); i++) {
            Courier courier = courierList.get(i);
            if (courier.getId() == id) {
                List<Orders> orders = courier.getOrders();
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

    public List<Courier> filteredByShippingAddress(String shippingAddress) {
        List<Courier> couriers = loadCourier();
        List<Courier> filteredCouriers = new ArrayList<>();
        for (Courier item : couriers) {
            if (item.getShipping_Address() == shippingAddress)
                filteredCouriers.add(item);
        }
        return filteredCouriers;

    }
    public void addOrderToCurier(Orders order, Courier courier){
        courierRepo.addOrderToCurier(order, courier);}

    public void removeOrderToCourier(Orders order, Courier courier){
        courierRepo.removeOrderToCourier(order, courier);}
}
