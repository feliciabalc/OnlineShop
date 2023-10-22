package Entities;

public class Courier {
    private String name;
    private double telefon;
    private Orders[] orders;
    private Warehouse warehouse;

    public Courier(String name, double telefon, Orders[] orders, Warehouse warehouse) {
        this.name = name;
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
