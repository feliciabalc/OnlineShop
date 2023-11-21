package DB_Controller;

import DB_Repo.SuppliersRepoDB;
import Entities.Suppliers;
import Repository.SuppliersRepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SuppliersControllerDB {
    private SuppliersRepoDB suppliersRepo;

    public SuppliersControllerDB(SuppliersRepoDB suppliersRepoDB) {
        this.suppliersRepo = suppliersRepoDB;
    }

    public void saveIntoDB(List<Suppliers> suppliers) {
        suppliersRepo.saveIntoDB(suppliers);
    }

    public Suppliers createSuppliersFromResultSet(ResultSet resultSet) throws SQLException {
        return suppliersRepo.createSuppliersFromResultSet(resultSet);
    }

    public List<Suppliers> loadFromDB() {
        return suppliersRepo.loadFromDB();
    }

    public Suppliers findById(int Id) {
        return suppliersRepo.findById(Id);
    }

    public void delete(int Id) {
        suppliersRepo.delete(Id);
    }

    public List<Suppliers> filterByName(String name) {
        return suppliersRepo.filterByName(name);
    }
}
