package Controller;

import Entities.Employee;
import Entities.Orders;
import Entities.Warehouse;
import Repository.EmployeesRepo;
import Repository.WarehouseRepo;

import java.util.ArrayList;
import java.util.List;

public class WarehouseController {
    private WarehouseRepo warehouseRepo;

    public WarehouseController(WarehouseRepo warehouseRepo) {
        this.warehouseRepo = warehouseRepo;
    }

    public WarehouseRepo getWarehouseRepo() {
        return warehouseRepo;
    }

    public void setWarehouseRepo(WarehouseRepo warehouseRepo) {
        this.warehouseRepo = warehouseRepo;
    }


    public List<Warehouse> loadWarehouse() {
        return warehouseRepo.loadWarehouse();
    }

    public void save(List<Warehouse> warehouse) {
        warehouseRepo.save(warehouse);
    }

    public List<Warehouse> findAll() {
        return warehouseRepo.loadWarehouse();
    }

    public Warehouse findById(int Id) {

        return warehouseRepo.findById(Id);
    }

    public void delete(int id) {
        warehouseRepo.delete(id);
    }

    public void updateTheWarehouse(int id, Warehouse warehouse) {
        warehouseRepo.update(id, warehouse);
    }



    public void updateSalary(int id, String salary){
        List<Employee> employeeList = loadWarehouse();
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
