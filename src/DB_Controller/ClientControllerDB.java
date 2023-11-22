package DB_Controller;

import DB_Repo.CartRepoDB;
import DB_Repo.ClientRepoDB;
import DB_Repo.OrderRepoDB;
import DB_Repo.ReviewRepoDB;
import Entities.Articles;
import Entities.Client;
import Entities.Order;
import Entities.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientControllerDB {
    private ClientRepoDB clientRepo;
    private OrderRepoDB orderRepo;
    private ReviewRepoDB reviewRepo;
    private CartRepoDB cartRepo;

    public ClientControllerDB(ClientRepoDB clientRepo, OrderRepoDB orderRepo, ReviewRepoDB reviewRepo, CartRepoDB cartRepo) {
        this.clientRepo = clientRepo;
        this.orderRepo = orderRepo;
        this.reviewRepo = reviewRepo;
        this.cartRepo = cartRepo;
    }

    public void saveIntoDB(List<Client> clients) {
        clientRepo.saveIntoDB(clients);
    }

    public Client createClientFromResultSet(ResultSet resultSet) throws SQLException {
        return clientRepo.createClientFromResultSet(resultSet);
    }

    public List<Client> loadFromDB() {
        return  clientRepo.loadFromDB();
    }

    public Client findById(int Id) {
        return clientRepo.findById(Id);
    }

    public void delete(int Id) {
        clientRepo.delete(Id);
    }

    public void updateAddress(int Id, String address) {
        clientRepo.updateAddress(Id,address);
    }

    public List<Client> filterByName(String name) {
        return clientRepo.filterByName(name);
    }

    public void addOrder(int orderId, int clientId){
        clientRepo.addOrder(orderId, clientId);
    }

    public void addReview(int revId, int clientId){
        clientRepo.addReview(revId, clientId);
    }

    public Order getOrder(int clientId){
        Order order = null;
        if(clientRepo.getOrderId(clientId) != -1) {
            int aId = clientRepo.getOrderId(clientId);
            order  = orderRepo.findById(aId);
        }
        return order;
    }


    public Review getReview(int clientId){
        Review review = null;
        int id = clientRepo.getRevId(clientId);
        if(id != -1) {
            review = reviewRepo.findById(id);
        }
        return review;
    }


}
