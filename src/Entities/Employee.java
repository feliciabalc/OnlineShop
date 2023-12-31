package Entities;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    protected int id;
    protected String name;
    protected String role;
    protected String salary;
    protected double telefon;
    protected List<Order> orders= new ArrayList<>();


    public Employee(int id,String name, String salary, double telefon) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public double getTelefon() {
        return telefon;
    }

    public void setTelefon(double telefon) {
        this.telefon = telefon;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", salary='" + salary + '\'' +
                ", telefon=" + telefon +
                '}';
    }




    public void addOrders(Order order){
        orders.add(order);
    }

    public void removeOrders(Order order){
        orders.remove(order);
    }
}
