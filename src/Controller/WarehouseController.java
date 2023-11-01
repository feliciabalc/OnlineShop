package Controller;

import Entities.*;
import Repository.EmployeesRepo;
import Repository.WarehouseRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class WarehouseController {
    private WarehouseRepo warehouseRepo;

    public WarehouseController(WarehouseRepo warehouseRepo) {
        this.warehouseRepo = warehouseRepo;
    }

    public WarehouseRepo getWarehouseRepo() {
        return warehouseRepo;
    }

    public void setWarehouseRepo(WarehouseRepo warehouseRepo) {
        this.warehouseRepo = warehouseRepo;
    }


    public List<Warehouse> loadWarehouse() {
        return warehouseRepo.loadWarehouse();
    }

    public void save() {
        Warehouse war1= new Warehouse(1,"R&F","Gruia 58");
        Warehouse war2= new Warehouse(1,"GoBi","Gruia 56");
        Warehouse war3= new Warehouse(1,"RaFy","Dornei 31");
        List<Warehouse> warehouse = new ArrayList<>();
        warehouse.add(war1);
        warehouse.add(war2);
        warehouse.add(war3);
        Articles a1  = new Articles(1,"bluza", "cx", "bumbac", "maneca", 24);
        Articles a2 = new Articles(2,"tricou", "cx", "bumbac", "maneca", 2);

        war1.addArticles(a1);
        war1.addArticles(a2);

        warehouseRepo.save(warehouse);
    }

    public void saveOneObj(Warehouse warehouse){ warehouseRepo.saveOneObj(warehouse);}

    public void deleteObj(Warehouse warehouse){ warehouseRepo.deleteObj(warehouse);}

    public List<Warehouse> findAll() {
        return warehouseRepo.loadWarehouse();
    }

    public Warehouse findById(int Id) {

        return warehouseRepo.findById(Id);
    }

    public void delete(int id) {
        warehouseRepo.delete(id);
    }

    public void updateTheWarehouse(int id, Warehouse warehouse) {
        warehouseRepo.update(id, warehouse);
    }

    public void deleteArticles(int id,Articles article) {
        List<Warehouse> warehouseList = loadWarehouse();
        for(int i=0;i<warehouseList.size();i++){
            Warehouse warehouse = warehouseList.get(i);
            if (warehouse.getId() == id) {
                List<Articles> articleList= warehouse.getArticles();
                for( int j=0; j<articleList.size();j++){
                    if(articleList.get(j) ==article){
                        articleList.remove(article);
                        break;
                    }
                }
            }
        }
        save();
        System.out.println("Article has been deleted.");
    }

    public void deleteEmployees(int id,Employee employee) {
        List<Warehouse> warehouseList = loadWarehouse();
        for(int i=0;i<warehouseList.size();i++){
            Warehouse warehouse = warehouseList.get(i);
            if (warehouse.getId() == id) {
                List<Employee> employeeList= warehouse.getEmployees();
                for( int j=0; j<employeeList.size();j++){
                    if(employeeList.get(j) ==employee){
                        employeeList.remove(employee);
                        break;
                    }
                }
            }
        }
        save();
        System.out.println("Employee has been deleted.");
    }

    public void deleteSupplier(int id,Supplier supplier) {
        List<Warehouse> warehouseList = loadWarehouse();
        for(int i=0;i<warehouseList.size();i++){
            Warehouse warehouse = warehouseList.get(i);
            if (warehouse.getId() == id) {
                List<Suppliers> supplierList= warehouse.getSuppliers();
                for( int j=0; j<supplierList.size();j++){
                    if(supplierList.get(j) ==supplier){
                        supplierList.remove(supplier);
                        break;
                    }
                }
            }
        }
        save();
        System.out.println("Item has been deleted.");
    }

    public void deleteCourier(int id,Courier courier) {
        List<Warehouse> warehouseList = loadWarehouse();
        for(int i=0;i<warehouseList.size();i++){
            Warehouse warehouse = warehouseList.get(i);
            if (warehouse.getId() == id) {
                List<Courier> courierList= warehouse.getCouriers();
                for( int j=0; j<courierList.size();j++){
                    if(courierList.get(j) ==courier){
                        courierList.remove(courier);
                        break;
                    }
                }
            }
        }
        save();
        System.out.println("Courier has been deleted.");
    }


    public List<Warehouse> filteredByAddress(String address) {
        List<Warehouse> warehouse = loadWarehouse();
        List<Warehouse> filteredWarehouse = new ArrayList<>();
        for (Warehouse item : warehouse) {
            if (item.getAddress() == address)
                filteredWarehouse.add(item);
        }
        return filteredWarehouse;

    }

    public void addArticlesToWarehouse(Articles article, Warehouse warehouse){
        warehouseRepo.addArticlesToWarehouse(article, warehouse);}

    public void removeArticlesToWarehouse(Articles article, Warehouse warehouse){
        warehouseRepo.removeArticlesToWarehouse(article, warehouse);}

    public void addEmployeeToWarehouse(Employee employee, Warehouse warehouse){
        warehouseRepo.addEmployeeToWarehouse(employee, warehouse);}

    public void removeEmployeeToWarehouse(Employee employee, Warehouse warehouse){
        warehouseRepo.removeEmployeeToWarehouse(employee, warehouse);}

    public void addSupplierToWarehouse(Suppliers supplier, Warehouse warehouse){
        warehouseRepo.addSupplierToWarehouse(supplier, warehouse);}

    public void removeSupplierToWarehouse(Suppliers supplier, Warehouse warehouse){
        warehouseRepo.removeSupplierToWarehouse(supplier,warehouse);}

    public void addCourierToWarehouse(Courier courier, Warehouse warehouse){
        warehouseRepo.addCourierToWarehouse(courier, warehouse);}

    public void removeCourierToWarehouse(Courier courier, Warehouse warehouse){
        warehouseRepo.removeCourierToWarehouse(courier,warehouse);}
}
