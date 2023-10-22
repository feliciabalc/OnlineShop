package Entities;

public class Employees {
    private String name;
    private String role;
    private String salary;
    private double telefon;
    private Orders[] orders;
    private Warehouse warehouse;

    public Employees(String name, String role, String salary, double telefon, Orders[] orders,
                     Warehouse warehouse) {
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.telefon = telefon;
        this.orders = orders;
        this.warehouse = warehouse;
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

    public Orders[] getOrders() {
        return orders;
    }

    public void setOrders(Orders[] orders) {
        this.orders = orders;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
