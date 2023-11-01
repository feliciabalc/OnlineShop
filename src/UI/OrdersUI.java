package UI;

import Controller.OrdersController;
import Entities.Articles;
import Entities.Employee;
import Entities.Orders;

import java.util.List;

public class OrdersUI {
    private OrdersController ordersController;

    public OrdersUI(OrdersController ordersController) {
        this.ordersController = ordersController;
    }

    public OrdersController getOrdersController() {
        return ordersController;
    }

    public void setOrdersController(OrdersController ordersController) {
        this.ordersController = ordersController;
    }
    public List<Orders> loadOrders() {
        return ordersController.loadOrders();}

    public void save() {
        ordersController.save();}

    public void saveOneObj(Orders order ){
        ordersController.saveOneObj(order);}

    public void deleteObj(Orders orders){ ordersController.deleteObj(orders);}

    public List<Orders> findAll() {
        return ordersController.findAll();}

    public Orders findById(int Id) {
        return ordersController.findById(Id);}

    public void delete(int id){
        ordersController.delete(id);}

    public void updateTheOrders(int id, Orders orders){
        ordersController.updateTheOrders(id,orders);}

    public void updateAddress(int id, String address){
        ordersController.updateAddress(id,address);}

    public void updatetePaymentMethod(int id, String paymentMethod){
        ordersController.updatetePaymentMethod(id,paymentMethod);}

    public List<Orders> filteredByDate(String date) {
        return ordersController.filteredByDate(date);}

    public void addEmployeeToOrder(Employee employee, Orders order){
        ordersController.addEmployeeToOrder(employee,order);
    }

    public void removeEmployeeToOrder(Employee employee, Orders order){
        ordersController.removeEmployeeToOrder(employee,order);}

    public void addArticleToOrder(Articles article, Orders order){
        ordersController.addArticleToOrder(article, order);
    }

    public void removeArticleToOrder(Articles article, Orders order){
        ordersController.removeArticleToOrder(article, order);
    }
    }
