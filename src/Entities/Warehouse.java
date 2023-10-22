package Entities;

public class Warehouse {
    private String name;
    private String address;
    private Articles[] articles;
    private Employees[] employees;
    private Suppliers[] suppliers;
    private Courier[] couriers;


    public Warehouse(String name, String address, Articles[] articles, Employees[] employees,
                     Suppliers[] suppliers, Courier[] couriers) {
        this.name = name;
        this.address = address;
        this.articles = articles;
        this.employees = employees;
        this.suppliers = suppliers;
        this.couriers = couriers;
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
}
