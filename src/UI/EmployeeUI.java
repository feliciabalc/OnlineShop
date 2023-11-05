package UI;

import Controller.EmployeesController;
import Entities.Employee;
import Entities.Orders;

import java.util.List;

public class EmployeeUI {
    private EmployeesController employeeController;

    public EmployeeUI(EmployeesController employeeController) {
        this.employeeController = employeeController;
    }

    public EmployeesController getEmployeeController() {
        return employeeController;
    }

    public void setEmployeeController(EmployeesController employeeController) {
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
        return employeeController.findAll();
    }

    public Employee findById(int Id) {
        return employeeController.findById(Id);
    }

    public void delete(int id) {
        employeeController.delete(id);
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

    public void updateteOrders(int id, Orders order, Orders newOrder) {
        employeeController.updateteOrders(id, order, newOrder);
    }

    public List<Employee> filteredByRole(String role) {
        return employeeController.filteredByRole(role);}

    public void addOrderToEmployee(Orders order, Employee employee){
        employeeController.addOrderToEmployee(order,employee);
    }

    public void removeOrderToEmployee(Orders order, Employee employee){
        employeeController.removeOrderToEmployee(order,employee);
    }


}
