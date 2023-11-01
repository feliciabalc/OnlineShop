package UI;

import Controller.ClientController;
import Entities.Cart;
import Entities.Client;
import Entities.Orders;
import Entities.Review;
import Repository.ClientRepo;

import java.util.List;

public class ClientUI {
    private ClientController clientController;

    public ClientUI(ClientController clientController) {
        this.clientController = clientController;
    }

    public ClientController getClientController() {
        return clientController;
    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public List<Client> loadClient() {
        return clientController.loadClient();
    }

    public void save() {
        clientController.save();
    }

    public void saveOneObject(Client client) {
        clientController.saveOneObject(client);
    }

    public void deleteObj(Client client){ clientController.deleteObj(client);}

    public List<Client> findAll() {
        return clientController.findAll();
    }

    public Client findById(int Id) {
        return clientController.findById(Id);
    }

    public void delete(int id) {
        clientController.delete(id);
    }

    public void updateTheClient(int id, Client client) {
        clientController.updateTheClient(id, client);
    }

    public void updateAddress(int id, String address) {
        clientController.updateAddress(id, address);
    }

    public void updateteCart(int id, Cart cart) {
        clientController.updateteCart(id, cart);
    }

    public List<Client> filteredByName(String name) {
        return clientController.filteredByName(name);
    }


    public void addReviewToClient(Review review, Client client) {
        clientController.addReviewToClient(review, client);
    }
    public void removeReviewToClient(Review review, Client client){
        clientController.removeReviewToClient(review, client);}

    public void addOrderToClient(Orders order, Client client){
        clientController.addOrderToClient(order, client);}

    public void removeOrderToClient(Orders order, Client client){
        clientController.removeOrderToClient(order, client);}
}