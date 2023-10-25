package Entities;

import java.util.List;

public class Courier extends Employees{
    private List<String> Shipping_address;

    public Courier(int id,String name, String role, String salary, double telefon, Orders[] orders, Warehouse warehouse, List<String> shipping_address) {
        super(id,name, role, salary, telefon, orders, warehouse);
        Shipping_address = shipping_address;
    }

    public List<String> getShipping_address() {
        return Shipping_address;
    }

    public void setShipping_address(List<String> shipping_address) {
        Shipping_address = shipping_address;
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
