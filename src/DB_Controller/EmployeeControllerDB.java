package DB_Controller;

import DB_Repo.EmployeeRepoDB;
import Entities.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeControllerDB {
    private EmployeeRepoDB employeeRepo;

    public EmployeeControllerDB(EmployeeRepoDB employeeRepo) {
        this.employeeRepo = employeeRepo;
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


}
