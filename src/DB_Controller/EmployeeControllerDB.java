package DB_Controller;

import DB_Repo.EmployeeRepoDB;
import DB_Repo.OrderRepoDB;
import Entities.Employee;
import Entities.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeControllerDB {
    private EmployeeRepoDB employeeRepo;

    private OrderRepoDB orderRepo;

    public EmployeeControllerDB(EmployeeRepoDB employeeRepo, OrderRepoDB orderRepo) {
        this.employeeRepo = employeeRepo;
        this.orderRepo = orderRepo;
    }

    public void saveIntoDB(List<Employee> employees) {
        employeeRepo.saveIntoDB(employees);
    }

    public Employee createEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        return employeeRepo.createEmployeeFromResultSet(resultSet);
    }

    public List<Employee> loadFromDB() {
        return employeeRepo.loadFromDB();
    }
    public Employee findById(int Id) {
        return employeeRepo.findById(Id);
    }

    public void delete(int Id) {
        employeeRepo.delete(Id);
    }

    public void updateSalary(int Id, String salary) {
        employeeRepo.updateSalary(Id,salary);
    }

    public void updateRole(int Id, String role) {
        employeeRepo.updateRole(Id,role);
    }

    public List<Employee> filterByRole(String role) {
        return employeeRepo.filterByRole(role);
    }


    public Order getOrder(int employeeId){
        Order order = null;
        int ID = employeeRepo.getOrderId(employeeId);
        if(ID != -1)
            order=orderRepo.findById(ID);
        return order;
    }

}
