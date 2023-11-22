package DB_Controller;

import DB_Repo.*;
import Entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WarehouseControllerDB {
    private WarehouseRepoDB warehouseRepo;

    private ArticleRepoDB articleRepo;
    private SuppliersRepoDB suppliersRepo;
    private CourierRepoDB courierRepoDB;
    private EmployeeRepoDB employeeRepo;

    public WarehouseControllerDB(WarehouseRepoDB warehouseRepo, ArticleRepoDB articleRepo,
                                 SuppliersRepoDB suppliersRepo, CourierRepoDB courierRepoDB, EmployeeRepoDB employeeRepo) {
        this.warehouseRepo = warehouseRepo;
        this.articleRepo = articleRepo;
        this.suppliersRepo = suppliersRepo;
        this.courierRepoDB = courierRepoDB;
        this.employeeRepo = employeeRepo;
    }

    public void saveIntoDB(List<Warehouse> warehouses) {
        warehouseRepo.saveIntoDB(warehouses);
    }

    public Warehouse createWarehouseFromResultSet(ResultSet resultSet) throws SQLException {
        return warehouseRepo.createWarehouseFromResultSet(resultSet);
    }

    public List<Warehouse> loadFromDB() {
        return warehouseRepo.loadFromDB();
    }
    public Warehouse findById(int Id) {
        return warehouseRepo.findById(Id);
    }

    public void delete(int Id) {
        warehouseRepo.delete(Id);
    }

    public List<Warehouse> filterByAddress(String address) {
        return warehouseRepo.filterByAddress(address);
    }

    public Articles getArticle(int warehouseId){
        Articles article = null;
        int ID = warehouseRepo.getArticleId(warehouseId);
        if(ID != -1)
            article = articleRepo.findById(ID);
        return article;
    }

    public Suppliers getSupplier(int warehouseId){
        Suppliers supplier = null;
        int ID = warehouseRepo.getSupplierId(warehouseId);
        if(ID != -1)
            supplier = suppliersRepo.findById(ID);
        return supplier;
    }

    public Courier getCourier(int warehouseId){
        Courier courier = null;
        int ID = warehouseRepo.getArticleId(warehouseId);
        if(ID != -1)
            courier = courierRepoDB.findById(ID);
        return courier;
    }

    public Employee getEmployee(int warehouseId){
        Employee employee = null;
        int ID = warehouseRepo.getArticleId(warehouseId);
        if(ID != -1)
            employee = employeeRepo.findById(ID);
        return employee;
    }


}
