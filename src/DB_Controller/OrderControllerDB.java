package DB_Controller;

import DB_Repo.OrderRepoDB;
import Entities.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderControllerDB {
    private OrderRepoDB orderRepo;

    public OrderControllerDB(OrderRepoDB orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void saveIntoDB(List<Order> orders) {
        orderRepo.saveIntoDB(orders);
    }

    public Order createOrderFromResultSet(ResultSet resultSet) throws SQLException {
        return orderRepo.createOrderFromResultSet(resultSet);
    }

    public List<Order> loadFromDB() {
        return orderRepo.loadFromDB();
    }

    public Order findById(int Id) {
        return orderRepo.findById(Id);
    }
    public void delete(int Id) {
        orderRepo.delete(Id);
    }

    public void updateAddress(int Id, String newAddress) {
        orderRepo.updateAddress(Id, newAddress);
    }

    public void updatePaymentMethod(int Id, String newPaymentMethod) {
        orderRepo.updatePaymentMethod(Id, newPaymentMethod);
    }

    public List<Order> filterByDate(String date) {
        return orderRepo.filterByDate(date);
    }



}
