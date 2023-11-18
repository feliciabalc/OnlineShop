package UI;

import Controller.WarehouseController;
import Entities.*;

import java.util.List;
import java.util.function.Supplier;

public class WarehouseUI {
    private WarehouseController warehouseController;

    public WarehouseUI(WarehouseController warehouseController) {
        this.warehouseController = warehouseController;
    }

    public WarehouseController getWarehouseController() {
        return warehouseController;
    }

    public void setWarehouseController(WarehouseController warehouseController) {
        this.warehouseController = warehouseController;
    }

    public List<Warehouse> loadWarehouse() {
        return warehouseController.loadWarehouse();
    }

    public void save() {
        warehouseController.save();
    }

    public void saveOneObj(Warehouse warehouse) {
        warehouseController.saveOneObj(warehouse);
    }

    public void deleteObj(Warehouse warehouse){ warehouseController.deleteObj(warehouse);}

    public List<Warehouse> findAll() {
        return warehouseController.findAll();
    }

    public Warehouse findById(int Id) {
        return warehouseController.findById(Id);
    }

    public void delete(int id) {
        warehouseController.delete(id);
    }

    public void updateTheWarehouse(int id, Warehouse warehouse) {
        warehouseController.updateTheWarehouse(id, warehouse);
    }

    public void deleteArticles(int id, Articles article) {
        warehouseController.deleteArticles(id, article);
    }

    public void deleteEmployees(int id, Employee employee) {
        warehouseController.deleteEmployees(id, employee);
    }

    public void deleteSupplier(int id, Supplier supplier) {
        warehouseController.deleteSupplier(id, supplier);
    }

    public void deleteCourier(int id, Courier courier) {
        warehouseController.deleteCourier(id, courier);
    }

    public List<Warehouse> filteredByAddress(String address) {
        return warehouseController.filteredByAddress(address);
    }

    public void addArticlesToWarehouse(Warehouse warehouse,int id) {
        warehouseController.addArticlesToWarehouse(warehouse,id);
    }

    public void removeArticlesToWarehouse(Warehouse warehouse,int id) {
        warehouseController.removeArticlesToWarehouse(warehouse,id);
    }

    public void addEmployeeToWarehouse(Warehouse warehouse,int id) {
        warehouseController.addEmployeeToWarehouse(warehouse,id);
    }

    public void removeEmployeeToWarehouse(Warehouse warehouse,int id) {
        warehouseController.removeEmployeeToWarehouse(warehouse,id);
    }

    public void addSupplierToWarehouse(Warehouse warehouse,int id) {
        warehouseController.addSupplierToWarehouse(warehouse,id);
    }

    public void removeSupplierToWarehouse(Warehouse warehouse,int id) {
        warehouseController.removeSupplierToWarehouse(warehouse,id);
    }

    public void addCourierToWarehouse(Warehouse warehouse,int id) {
        warehouseController.addCourierToWarehouse(warehouse,id);
    }

    public void removeCourierToWarehouse(Warehouse warehouse,int id) {
        warehouseController.removeCourierToWarehouse(warehouse,id);
    }
}