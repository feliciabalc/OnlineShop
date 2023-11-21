package DB_Controller;

import DB_Repo.SpecificationsRepoDB;
import Entities.Specifications;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SpecificationsControllerDB {
    private SpecificationsRepoDB specificationsRepo;

    public SpecificationsControllerDB(SpecificationsRepoDB specificationsRepo) {
        this.specificationsRepo = specificationsRepo;
    }

    public void saveIntoDB(List<Specifications> specification) {
        specificationsRepo.saveIntoDB(specification);
    }

    public Specifications createSpecificationsFromResultSet(ResultSet resultSet) throws SQLException {
        return specificationsRepo.createSpecificationsFromResultSet(resultSet);
    }

    public List<Specifications> loadFromDB() {
        return specificationsRepo.loadFromDB();
    }

    public Specifications findById(int Id) {
        return specificationsRepo.findById(Id);
    }

    public void delete(int Id) {
        specificationsRepo.delete(Id);
    }

    public List<Specifications> filterBySize(String size) {
        return specificationsRepo.filterBySize(size);
    }

    public List<Specifications> filterByColor(String color) {
        return specificationsRepo.filterByColor(color);
    }

    public void updateQuantity(int Id, double newQuantity) {
        specificationsRepo.updateQuantity(Id, newQuantity);
    }
}
