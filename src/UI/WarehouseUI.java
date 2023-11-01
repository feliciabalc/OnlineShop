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

    public void addArticlesToWarehouse(Articles article, Warehouse warehouse) {
        warehouseController.addArticlesToWarehouse(article, warehouse);
    }

    public void removeArticlesToWarehouse(Articles article, Warehouse warehouse) {
        warehouseController.removeArticlesToWarehouse(article, warehouse);
    }

    public void addEmployeeToWarehouse(Employee employee, Warehouse warehouse) {
        warehouseController.addEmployeeToWarehouse(employee, warehouse);
    }

    public void removeEmployeeToWarehouse(Employee employee, Warehouse warehouse) {
        warehouseController.removeEmployeeToWarehouse(employee, warehouse);
    }

    public void addSupplierToWarehouse(Suppliers supplier, Warehouse warehouse) {
        warehouseController.addSupplierToWarehouse(supplier, warehouse);
    }

    public void removeSupplierToWarehouse(Suppliers supplier, Warehouse warehouse) {
        warehouseController.removeSupplierToWarehouse(supplier, warehouse);
    }

    public void addCourierToWarehouse(Courier courier, Warehouse warehouse) {
        warehouseController.addCourierToWarehouse(courier, warehouse);
    }

    public void removeCourierToWarehouse(Courier courier, Warehouse warehouse) {
        warehouseController.removeCourierToWarehouse(courier, warehouse);
    }
}