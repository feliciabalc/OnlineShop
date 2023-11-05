package Controller;

import Entities.*;
import Repository.CourierRepo;
import Repository.EmployeesRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeesController {
    private EmployeesRepo employeesRepo;

    private WorkersFactory workersFactory;

    private CourierRepo courierRepo;

    public EmployeesController(EmployeesRepo employeesRepo, CourierRepo courierRepo, WorkersFactory workersFactory) {
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

        Employee emp1= new Employee(1,"Sorin","1500", 0768.23456);
        emp1.setRole("impacheteaza");
        Employee emp2= new Employee(2,"Matei","1500", 0768.23466);
        Employee emp3= new Employee(3,"Paul","2500", 0768.23433);
        List<Employee> employees= new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        Orders o1 = new Orders(1, 12, 120, "cash", "Gruia 15", "10.12.2022");
        emp1.addOrders(o1);

        Warehouse war1= new Warehouse(1,"R&F","Gruia 58");
        emp1.setWarehouse(war1);

        employeesRepo.save(employees);
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

}

