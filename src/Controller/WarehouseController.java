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

    public void save(List<Warehouse> warehouse) {
        warehouseRepo.save(warehouse);
    }

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
                List<Articles> articleList= List.of(warehouse.getArticles());
                for( int j=0; j<articleList.size();j++){
                    if(articleList.get(j) ==article){
                        articleList.remove(article);
                        break;
                    }
                }
            }
        }
        save(warehouseList);
        System.out.println("Article has been deleted.");
    }

    public void deleteEmployees(int id,Employee employee) {
        List<Warehouse> warehouseList = loadWarehouse();
        for(int i=0;i<warehouseList.size();i++){
            Warehouse warehouse = warehouseList.get(i);
            if (warehouse.getId() == id) {
                List<Employee> employeeList= List.of(warehouse.getEmployees());
                for( int j=0; j<employeeList.size();j++){
                    if(employeeList.get(j) ==employee){
                        employeeList.remove(employee);
                        break;
                    }
                }
            }
        }
        save(warehouseList);
        System.out.println("Employee has been deleted.");
    }

    public void deleteSupplier(int id,Supplier supplier) {
        List<Warehouse> warehouseList = loadWarehouse();
        for(int i=0;i<warehouseList.size();i++){
            Warehouse warehouse = warehouseList.get(i);
            if (warehouse.getId() == id) {
                List<Suppliers> supplierList= List.of(warehouse.getSuppliers());
                for( int j=0; j<supplierList.size();j++){
                    if(supplierList.get(j) ==supplier){
                        supplierList.remove(supplier);
                        break;
                    }
                }
            }
        }
        save(warehouseList);
        System.out.println("Article has been deleted.");
    }


    public void deleteCourier(int id,Courier courier) {
        List<Warehouse> warehouseList = loadWarehouse();
        for(int i=0;i<warehouseList.size();i++){
            Warehouse warehouse = warehouseList.get(i);
            if (warehouse.getId() == id) {
                List<Courier> courierList= List.of(warehouse.getCouriers());
                for( int j=0; j<courierList.size();j++){
                    if(courierList.get(j) ==courier){
                        courierList.remove(courier);
                        break;
                    }
                }
            }
        }
        save(warehouseList);
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
}
