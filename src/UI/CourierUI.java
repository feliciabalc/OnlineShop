package UI;

import Controller.CourierController;
import Entities.Courier;
import Entities.Orders;

import java.util.List;

public class CourierUI {
    private CourierController courierController;

    public CourierUI(CourierController courierController) {
        this.courierController = courierController;
    }

    public CourierController getCourierController() {
        return courierController;
    }

    public void setCourierController(CourierController courierController) {
        this.courierController = courierController;
    }
    public List<Courier> loadCourier() {
        return courierController.loadCourier();}

    public void save() {
        courierController.save();}

    public void saveOneObject(Courier courier){
        courierController.saveOneObject(courier);
    }

    public void deleteObj(Courier courier){ courierController.deleteObj(courier);}

    public List<Courier> findAll() {
        return courierController.findAll();}

    public Courier findById(int Id) {
        return courierController.findById(Id);}

    public void delete(int id){
        courierController.delete(id);}

    public void updateTheCourier(int id, Courier courier){
        courierController.updateTheCourier(id,courier);}

    public void updateSalary(int id, String salary){
        courierController.updateSalary(id,salary);}

    public void updateteTelefon(int id, double telefon){
        courierController.updateteTelefon(id,telefon);}

    public void updateteShippingAddress(int id, String address) {
        courierController.updateteShippingAddress(id,address);}

    public void updateteOrders(int id, Orders order, Orders newOrder) {
        courierController.updateteOrders(id,order,newOrder);}

    public List<Courier> filteredByShippingAddress(String shippingAddress) {
        return courierController.filteredByShippingAddress(shippingAddress);}

    public void addOrderToCourier(Orders order, Courier courier){
        courierController.addOrderToCurier(order, courier);}

    public void removeOrderToCourier(Orders order, Courier courier){
        courierController.removeOrderToCourier(order, courier);}
}
