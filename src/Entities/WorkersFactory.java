package Entities;

public class WorkersFactory {

    public Employee createEmployee(int id, String name, String salary, double telefon){
        return new Employee(id, name, salary, telefon);
    }

    public Courier createCourier(int id, String name, String salary, double telefon){
        return new Courier(id, name, salary, telefon);
    }
}
