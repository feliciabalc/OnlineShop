package DB_Controller;

import DB_Repo.WarehouseRepoDB;
import Entities.Warehouse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WarehouseControllerDB {
    private WarehouseRepoDB warehouseRepo;

    public WarehouseControllerDB(WarehouseRepoDB warehouseRepo) {
        this.warehouseRepo = warehouseRepo;
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

}
