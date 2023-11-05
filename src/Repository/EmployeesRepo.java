package Repository;

import Entities.Client;
import Entities.Courier;
import Entities.Employee;
import Entities.Orders;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeesRepo extends AbstractRepo {
    public EmployeesRepo(String fileName) {

        super(fileName);
    }

    @Override
    public void save(List objects) {
        super.save(objects);
    }

    public void saveOneObject(Employee employee) {
        List<Employee> employees = loadEmployee();
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Employee item = iterator.next();
            if (item.getId() == employee.getId()) {
                iterator.remove(); // Remove the existing item from the list
            }
        }

        employees.add(employee); // Add the new employee to the list
        save(employees);
    }


    public void deleteObj(Employee employee){
        List<Employee> allEmployee =loadEmployee();
        allEmployee.remove(employee);
        save(allEmployee);
    }

    public List<Employee> loadEmployee() {
        Type employeeListType = new TypeToken<List<Employee>>() {}.getType();
        return load(employeeListType);
    }

    public List<Employee> findAll(){
        return loadEmployee();
    }


    public Employee findById(int Id){
        List<Employee> allEmployees = loadEmployee();
        Employee foundItem = null;
        for(Employee item : allEmployees){
            if(item.getId() == Id)
                foundItem =item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        List<Employee> employeesList = loadEmployee();
        Employee foundItem = null;
        int indexToRemove = -1;

        for (int i = 0; i < employeesList.size(); i++) {
            Employee item = employeesList.get(i);
            if (item.getId() == Id) {
                foundItem = item;
                indexToRemove = i;
                break;
            }
        }

        if (foundItem != null && indexToRemove != -1) {
            employeesList.remove(indexToRemove);
            save(employeesList);
            System.out.println( Id + " has been deleted.");
        } else {
            System.out.println(Id + " not found.");
        }
    }



    public void update(int id, Employee updatedEmployees) {
        List<Employee> employeesList = loadEmployee();
        boolean found = false;

        for (int i = 0; i < employeesList.size(); i++) {
            Employee employees = employeesList.get(i);
            if (employees.getId() == id) {
                employees.setName(updatedEmployees.getName());
                employees.setRole(updatedEmployees.getRole());
                employees.setTelefon(updatedEmployees.getTelefon());
                employees.setSalary(updatedEmployees.getSalary());
                found = true;
                break;
            }
        }

        if (found) {
            save(employeesList);
            System.out.println( id + " has been updated.");
        } else {
            System.out.println( id + " not found.");
        }
    }

    public void addOrderToEmployee(Orders order, Employee employee){
        employee.addOrders(order);
        saveOneObject(employee);
    }

    public void removeOrderToEmployee(Orders order, Employee employee){
        employee.removeOrders(order);
        saveOneObject(employee);
    }

    public void updateSalary(int id, String salary){
        List<Employee> employeeList = loadEmployee();
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
        List<Employee> employeeList = loadEmployee();
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

    public void updateteOrders(int id, Orders order, Orders newOrder){
        List<Employee> employeeList = loadEmployee();
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
            save(employeeList);
            System.out.println("Courier with ID " + id + " has been updated.");
        } else {
            System.out.println("Courier with ID " + id + " not found.");
        }
    }

    public List<Employee> filteredByRole(String role) {
        List<Employee> employee = loadEmployee();
        List<Employee> filteredEmployee = new ArrayList<>();
        for (Employee item : employee) {
            if (item.getRole() == role)
                filteredEmployee.add(item);
        }
        return filteredEmployee;

    }

}