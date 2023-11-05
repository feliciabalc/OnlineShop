package Controller;

import Entities.*;
import Repository.CourierRepo;
import Repository.EmployeesRepo;

import java.util.ArrayList;
import java.util.List;

public class WorkersController {
    private EmployeesRepo employeesRepo;

    private WorkersFactory workersFactory;

    private CourierRepo courierRepo;

    public WorkersController(EmployeesRepo employeesRepo, CourierRepo courierRepo, WorkersFactory workersFactory) {
        this.employeesRepo = employeesRepo;
        this.courierRepo = courierRepo;
        this.workersFactory = workersFactory;
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


        Orders o1 = new Orders(1, 12, 120, "cash", "Gruia 15", "10.12.2022");
        Employee e1 = employeesRepo.findById(1);
        e1.addOrders(o1);
        Courier c1 = courierRepo.findById(1);
        c1.addOrders(o1);

        Warehouse war1= new Warehouse(1,"R&F","Gruia 58");
        e1.setWarehouse(war1);

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

    public void updateteOrders(int id, Orders order, Orders newOrder){
        employeesRepo.updateteOrders(id, order, newOrder);
    }

    public List<Employee> filteredByRole(String role) {
        return employeesRepo.filteredByRole(role);

    }

    public void addOrderToEmployee(Orders order, Employee employee){
       employeesRepo.addOrderToEmployee(order,employee);
    }

    public void removeOrderToEmployee(Orders order, Employee employee){ employeesRepo.removeOrderToEmployee(order,employee);
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

    public void addOrderToCurier(Orders order, Courier courier){
        courierRepo.addOrderToCurier(order, courier);}

    public void removeOrderToCourier(Orders order, Courier courier){
        courierRepo.removeOrderToCourier(order, courier);}

    public void updateteTelefon(int id, double telefon){
        courierRepo.updateteTelefon(id,telefon);}

}

