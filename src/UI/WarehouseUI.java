package UI;

import Controller.WarehouseController;
import Entities.Articles;
import Entities.Courier;
import Entities.Employee;
import Entities.Warehouse;

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
        return warehouseController.loadWarehouse();}

    public void save(List<Warehouse> warehouse) {
        warehouseController.save(warehouse);}

    public List<Warehouse> findAll() {
        return warehouseController.findAll();}

    public Warehouse findById(int Id) {
        return warehouseController.findById(Id);}

    public void delete(int id) {
        warehouseController.delete(id);}

    public void updateTheWarehouse(int id, Warehouse warehouse){
        warehouseController.updateTheWarehouse(id, warehouse);}

    public void deleteArticles(int id, Articles article) {
        warehouseController.deleteArticles(id, article);}

    public void deleteEmployees(int id, Employee employee) {
        warehouseController.deleteEmployees(id, employee);}

    public void deleteSupplier(int id, Supplier supplier) {
        warehouseController.deleteSupplier(id, supplier);}

    public void deleteCourier(int id, Courier courier) {
        warehouseController.deleteCourier(id, courier);}

    public List<Warehouse> filteredByAddress(String address) {
        return warehouseController.filteredByAddress(address);}
    }
