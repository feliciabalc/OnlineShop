package Entities;

import java.util.Arrays;

public class Courier extends Employee{
    private String Shipping_Address;

    public Courier(int id, String name, String role, String salary, double telefon, String shipping_Address) {
        super(id, name, role, salary, telefon);
        Shipping_Address = shipping_Address;
    }

    public String getShipping_Address() {
        return Shipping_Address;
    }

    public void setShipping_Address(String shipping_Address) {
        Shipping_Address = shipping_Address;
    }


    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", salary='" + salary + '\'' +
                ", telefon=" + telefon +
                                '}';
    }
}
