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

        warehouseRepo.addArticlesToWarehouse(war1,1);
        warehouseRepo.addArticlesToWarehouse(war2, 2);
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

    public void addArticlesToWarehouse(Warehouse warehouse, int id){
        warehouseRepo.addArticlesToWarehouse(warehouse, id);}

    public void removeArticlesToWarehouse(Warehouse warehouse, int id){
        warehouseRepo.removeArticlesToWarehouse(warehouse, id);}

    public void addEmployeeToWarehouse(Warehouse warehouse,int id){
        warehouseRepo.addEmployeeToWarehouse(warehouse, id);}

    public void removeEmployeeToWarehouse(Warehouse warehouse,int id){
        warehouseRepo.removeEmployeeToWarehouse(warehouse, id);}

    public void addSupplierToWarehouse(Warehouse warehouse,int id){
        warehouseRepo.addSupplierToWarehouse(warehouse, id);}

    public void removeSupplierToWarehouse(Warehouse warehouse,int id){
        warehouseRepo.removeSupplierToWarehouse(warehouse, id);}

    public void addCourierToWarehouse(Warehouse warehouse,int id){
        warehouseRepo.addCourierToWarehouse(warehouse, id);}

    public void removeCourierToWarehouse(Warehouse warehouse,int id){
        warehouseRepo.removeCourierToWarehouse(warehouse, id);}
}
