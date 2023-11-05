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




    public void save() {
        Courier c1 = new Courier(1, "Ion",  "1200", 075344);
        Courier c2 = new Courier(2, "Ionut",  "1200", 0753.4568);
        List<Courier> couriers = new ArrayList<>();
        couriers.add(c1);
        couriers.add(c2);
        Orders o1 = new Orders(1, 12, 120, "cash", "Gruia 15", "10.12.2022");
        c1.addOrders(o1);

        courierRepo.save(couriers);
    }






    public void updateSalary(int id, String salary){
       courierRepo.updateSalary(id, salary);
    }

    public void updateteTelefon(int id, double telefon){
        courierRepo.updateteTelefon(id, telefon);
    }



    public void updateteOrders(int id, Orders order, Orders newOrder) {
        courierRepo.updateteOrders(id, order, newOrder);
    }


    public void addOrderToCurier(Orders order, Courier courier){
        courierRepo.addOrderToCurier(order, courier);}

    public void removeOrderToCourier(Orders order, Courier courier){
        courierRepo.removeOrderToCourier(order, courier);}
}
