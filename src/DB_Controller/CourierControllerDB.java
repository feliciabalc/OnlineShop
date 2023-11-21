package DB_Controller;

import DB_Repo.CourierRepoDB;
import Entities.Courier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CourierControllerDB {
    private CourierRepoDB courierRepo;

    public CourierControllerDB(CourierRepoDB courierRepo) {
        this.courierRepo = courierRepo;
    }

    public void saveIntoDB(List<Courier> couriers) {
        courierRepo.saveIntoDB(couriers);
    }

    public Courier createCourierFromResultSet(ResultSet resultSet) throws SQLException {
        return courierRepo.createCourierFromResultSet(resultSet);
    }

    public List<Courier> loadFromDB() {
        return courierRepo.loadFromDB();
    }

    public Courier findById(int Id) {
        return courierRepo.findById(Id);
    }

    public void delete(int Id) {
        courierRepo.delete(Id);
    }

    public void updateSalary(int Id, String salary) {
        courierRepo.updateSalary(Id,salary);
    }
}
