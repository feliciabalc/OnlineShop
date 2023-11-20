package UI;

import Controller.WorkersController;
import Entities.Courier;
import Entities.Employee;
import Entities.Order;

import java.util.List;

public class WorkersUI {
    private WorkersController employeeController;

    public WorkersUI(WorkersController employeeController) {
        this.employeeController = employeeController;
    }

    public WorkersController getEmployeeController() {
        return employeeController;
    }

    public void setEmployeeController(WorkersController employeeController) {
        this.employeeController = employeeController;
    }

    public List<Employee> loadEmployees() {
        return employeeController.loadEmployees();
    }

    public void save() {
        employeeController.save();
    }

    public void saveOneObject(int id, String name, String salary, double telefon, String rol){employeeController.saveOneObject(id, name, salary, telefon, rol);}

    public void deleteObj(Employee employee){
        employeeController.deleteObj(employee);}

    public List<Employee> findAll() {
        return employeeController.findAllEmployees();
    }

    public Employee findById(int Id) {
        return employeeController.findEmployeeById(Id);
    }

    public void delete(int id) {
        employeeController.deleteEmployee(id);
    }

    public void updateTheEmployees(int id, Employee employees) {
        employeeController.updateTheEmployees(id, employees);
    }

    public void updateSalary(int id, String salary) {
        employeeController.updateSalary(id, salary);
    }

    public void updateteRole(int id, String role) {
        employeeController.updateteRole(id, role);
    }

    public void updateteOrders(int id, Order order, Order newOrder) {
        employeeController.updateteOrders(id, order, newOrder);
    }

    public List<Employee> filteredByRole(String role) {
        return employeeController.filteredByRole(role);}

    public void addOrderToEmployee(Employee employee,int id){
        employeeController.addOrderToEmployee(employee, id);
    }

    public void removeOrderToEmployee(Employee employee,int id){
        employeeController.removeOrderToEmployee(employee,id);
    }

    public List<Courier> loadCourier() {
        return employeeController.loadCourier();}


    public void deleteObj(Courier courier){ employeeController.deleteObj(courier);}

    public List<Courier> findAllCouriers() {
        return employeeController.findAllCouriers();}

    public Courier findCourierById(int Id) {
        return employeeController.findCourierById(Id);}

    public void deleteCourierById(int id){
        employeeController.deleteCourier(id);}




    public void updateteTelefon(int id, double telefon){
        employeeController.updateteTelefon(id,telefon);}




    public void addOrderToCourier(Courier courier,int id){
        employeeController.addOrderToCurier(courier,id);}

    public void removeOrderToCourier(Courier courier,int id){
        employeeController.removeOrderToCourier(courier,id);}


}
