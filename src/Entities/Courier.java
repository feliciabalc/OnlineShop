package Entities;

import java.util.Arrays;

public class Courier extends Employee{

    public Courier(int id, String name, String salary, double telefon) {
        super(id, name, salary, telefon);
    }


    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", telefon=" + telefon +
                '}';
    }
}
