package Entities;

import java.util.Arrays;

public class Warehouse {
    private int id;
    private String name;
    private String address;
    private Articles[] articles;
    private Employee[] employees;
    private Suppliers[] suppliers;
    private Courier[] couriers;


    public Warehouse(int id,String name, String address, Articles[] articles, Employee[] employees,
                     Suppliers[] suppliers, Courier[] couriers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.articles = articles;
        this.employees = employees;
        this.suppliers = suppliers;
        this.couriers = couriers;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Articles[] getArticles() {
        return articles;
    }

    public void setArticles(Articles[] articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", articles=" + Arrays.toString(articles) +
                ", employees=" + Arrays.toString(employees) +
                ", suppliers=" + Arrays.toString(suppliers) +
                ", couriers=" + Arrays.toString(employees) +
                '}';
    }
}
