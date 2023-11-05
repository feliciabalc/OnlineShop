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
        warehouseRepo.deleteArticles(id, article);
    }

    public void deleteEmployees(int id,Employee employee) {
        warehouseRepo.deleteEmployees(id, employee);
    }

    public void deleteSupplier(int id,Supplier supplier) {
       warehouseRepo.deleteSupplier(id, supplier);
    }

    public void deleteCourier(int id,Courier courier) {
        warehouseRepo.deleteCourier(id, courier);
    }


    public List<Warehouse> filteredByAddress(String address) {
       return warehouseRepo.filteredByAddress(address);

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
