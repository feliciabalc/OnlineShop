package Controller;

import Entities.*;
import Repository.CourierRepo;
import Repository.EmployeesRepo;
import Repository.OrderRepo;

import java.util.List;

public class WorkersController {
    private EmployeesRepo employeesRepo;

    private WorkersFactory workersFactory;

    private CourierRepo courierRepo;

    private OrderRepo orderRepo;

    public WorkersController(EmployeesRepo employeesRepo, WorkersFactory workersFactory, CourierRepo courierRepo, OrderRepo orderRepo) {
        this.employeesRepo = employeesRepo;
        this.workersFactory = workersFactory;
        this.courierRepo = courierRepo;
        this.orderRepo = orderRepo;
    }

    public EmployeesRepo getEmployeesRepo() {
        return employeesRepo;
    }

    public void setEmployeesRepo(EmployeesRepo employeesRepo) {
        this.employeesRepo = employeesRepo;
    }


    public List<Employee> loadEmployees() {
        return employeesRepo.loadEmployee();
    }

    public List<Courier> loadCourier() {
        return courierRepo.loadCourier();
    }


    public void saveOneObject(int id, String name, String salary, double telefon, String rol){
        if ("Courier".equals(rol)) {
            Courier courier = workersFactory.createCourier(id, name, salary, telefon);
            courierRepo.saveOneObject(courier);
        }else {
            Employee employee = workersFactory.createEmployee(id, name, salary, telefon);
            employee.setRole(rol);
             employeesRepo.saveOneObject(employee);}
    }

    public void deleteObj(Employee employee){ employeesRepo.deleteObj(employee);}

    public void save() {

        saveOneObject(1, "Sorin","1500", 0768.23456, "packing");
        saveOneObject(2,"Matei","1500", 0768.23466, "billing");
        saveOneObject(3,"Paul","2500", 0768.23433, "cleaning");
        saveOneObject(1, "Ion",  "1200", 075344, "Courier");
        saveOneObject(2, "Ionut",  "1200", 0753.4568,"Courier");


        Employee e1 = employeesRepo.findById(1);
        employeesRepo.addOrderToEmployee(e1, orderRepo.findById(1));

        Courier c1 = courierRepo.findById(1);
        courierRepo.addOrderToCurier(c1,orderRepo.findById(2));


    }

    public List<Employee> findAllEmployees() {
        return employeesRepo.loadEmployee();
    }

    public Employee findEmployeeById(int Id) {

        return employeesRepo.findById(Id);
    }

    public void deleteEmployee(int id) {
        employeesRepo.delete(id);
    }

    public void updateTheEmployees(int id, Employee employees) {
        employeesRepo.update(id, employees);
    }



    public void updateSalary(int id, String salary){
        employeesRepo.updateSalary(id, salary);
    }

    public void updateteRole(int id, String role){
        employeesRepo.updateteRole(id, role);
    }

    public void updateteOrders(int id, Order order, Order newOrder){
        employeesRepo.updateteOrders(id, order, newOrder);
    }

    public List<Employee> filteredByRole(String role) {
        return employeesRepo.filteredByRole(role);

    }

    public void addOrderToEmployee(Employee employee, int id){
        Order order = orderRepo.findById(id);
       employeesRepo.addOrderToEmployee(employee, order);
    }

    public void removeOrderToEmployee(Employee employee, int id){
        Order order = orderRepo.findById(id);
        employeesRepo.removeOrderToEmployee(employee, order);
    }


    public void deleteObj(Courier courier){ courierRepo.deleteObj(courier);}

    public List<Courier> findAllCouriers() {
        return courierRepo.loadCourier();
    }

    public Courier findCourierById(int Id) {

        return courierRepo.findById(Id);
    }

    public void deleteCourier(int id) {
        courierRepo.delete(id);
    }

    public void addOrderToCurier(Courier courier, int id){
        Order order = orderRepo.findById(id);
        courierRepo.addOrderToCurier(courier, order);}

    public void removeOrderToCourier(Courier courier, int id){
        Order order = orderRepo.findById(id);
        courierRepo.removeOrderToCourier(courier, order);}

    public void updateteTelefon(int id, double telefon){
        courierRepo.updateteTelefon(id,telefon);}

}

