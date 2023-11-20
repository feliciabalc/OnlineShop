package UI;

import Controller.ClientController;
import Entities.Cart;
import Entities.Client;

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


    public void addReviewToClient(Client client, int id) {
        clientController.addReviewToClient(client, id);
    }

    public void removeReviewToClient(Client client, int id){
        clientController.removeReviewToClient(client, id);}

    public void addOrderToClient(Client client, int id){
        clientController.addOrderToClient(client, id);}

    public void removeOrderToClient(Client client, int id){
        clientController.removeOrderToClient(client, id);}



}