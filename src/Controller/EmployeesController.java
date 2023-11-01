package Controller;

import Entities.Articles;
import Entities.Employee;
import Entities.Orders;
import Entities.Warehouse;
import Repository.EmployeesRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeesController {
    private EmployeesRepo employeesRepo;

    public EmployeesController(EmployeesRepo employeesRepo) {
        this.employeesRepo = employeesRepo;
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

    public void saveOneObject(Employee employee){
        employeesRepo.saveOneObject(employee);
    }

    public void deleteObj(Employee employee){ employeesRepo.deleteObj(employee);}

    public void save() {

        Employee emp1= new Employee(1,"Sorin","Impacheteaza","1500", 0768.23456);
        Employee emp2= new Employee(2,"Matei","Impacheteaza","1500", 0768.23466);
        Employee emp3= new Employee(3,"Paul","Impacheteaza","2500", 0768.23433);
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

    public List<Employee> findAll() {
        return employeesRepo.loadEmployee();
    }

    public Employee findById(int Id) {

        return employeesRepo.findById(Id);
    }

    public void delete(int id) {
        employeesRepo.delete(id);
    }

    public void updateTheEmployees(int id, Employee employees) {
        employeesRepo.update(id, employees);
    }



    public void updateSalary(int id, String salary){
        List<Employee> employeeList = loadEmployees();
        boolean found = false;

        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (employee.getId() == id) {
                employee.setSalary(salary);
                found = true;
                break;
            }
        }
        if (found) {
            save();
            System.out.println("Employee with ID " + id + " has been updated.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void updateteRole(int id, String role){
        List<Employee> employeeList = loadEmployees();
        boolean found = false;

        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (employee.getId() == id) {
                employee.setRole(role);
                found = true;
                break;
            }
        }
        if (found) {
            save();
            System.out.println("Employee with ID " + id + " has been updated.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void updateteOrders(int id, Orders order, Orders newOrder){
        List<Employee> employeeList = loadEmployees();
        boolean found = false;

        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (employee.getId() == id) {
                List<Orders> orders=employee.getOrders();
                for(int j= 0; j<= orders.size(); j++)
                    if(orders.get(j)==order){
                        orders.set(j, newOrder);
                        found = true;
                        break;
            }}
        }
        if (found) {
            save();
            System.out.println("Courier with ID " + id + " has been updated.");
        } else {
            System.out.println("Courier with ID " + id + " not found.");
        }
    }

    public List<Employee> filteredByRole(String role) {
        List<Employee> employee = loadEmployees();
        List<Employee> filteredEmployee = new ArrayList<>();
        for (Employee item : employee) {
            if (item.getRole() == role)
                filteredEmployee.add(item);
        }
        return filteredEmployee;

    }

    public void addOrderToEmployee(Orders order, Employee employee){
       employeesRepo.addOrderToEmployee(order,employee);
    }

    public void removeOrderToEmployee(Orders order, Employee employee){ employeesRepo.removeOrderToEmployee(order,employee);
    }
}

