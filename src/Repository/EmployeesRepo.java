package Repository;

import Entities.Employee;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class EmployeesRepo extends AbstractRepo {
    public EmployeesRepo(String fileName) {

        super(fileName);
    }

    @Override
    public void save(List objects) {
        super.save(objects);
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

}