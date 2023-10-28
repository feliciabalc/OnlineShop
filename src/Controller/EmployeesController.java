package Controller;

import Entities.Articles;
import Entities.Employee;
import Entities.Orders;
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

    public void save(List<Employee> employees) {
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
            save(employeeList);
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
            save(employeeList);
            System.out.println("Employee with ID " + id + " has been updated.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void updateteOrders(int id, Orders order, int position){
        List<Employee> employeeList = loadEmployees();
        boolean found = false;

        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (employee.getId() == id) {
                Orders[] orders=employee.getOrders();
                orders[position]=order;
                found = true;
                break;
            }
        }
        if (found) {
            save(employeeList);
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
}

