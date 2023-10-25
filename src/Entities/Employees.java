package Entities;

public class Employees {
    protected int id;
    protected String name;
    protected String role;
    protected String salary;
    protected double telefon;
    protected Orders[] orders;
    protected Warehouse warehouse;

    public Employees(int id,String name, String role, String salary, double telefon, Orders[] orders,
                     Warehouse warehouse) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.telefon = telefon;
        this.orders = orders;
        this.warehouse = warehouse;
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
