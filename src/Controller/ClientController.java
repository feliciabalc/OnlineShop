package Controller;
import Entities.Cart;
import Entities.Client;
import Entities.Orders;
import Entities.Review;
import Repository.ClientRepo;

import java.util.ArrayList;
import java.util.List;

public class ClientController {
    private ClientRepo clientRepo;

    public ClientController(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public ClientRepo getClientRepo() {
        return clientRepo;
    }

    public void setClientRepo(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }


    public List<Client> loadClient() {
        return clientRepo.loadClient();
    }

    public void save() {
        Client client1= new Client(1,"Ion", "piupiu 23", 0897.6535);
        Client client2= new Client(2,"Mark", "dunarii 1", 0844.6535);
        Client client3= new Client(3,"Mark", "copacului 4", 0899.6535);
        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);

        clientRepo.addOrderToClient(client1, 1);
        clientRepo.addReviewToClient(client2,1);
        clientRepo.setCart(client1,1);

        clientRepo.save(clients);
    }

    public void saveOneObject(Client client){
        clientRepo.saveOneObject(client);}

    public void deleteObj(Client client){ clientRepo.deleteObj(client);}

    public List<Client> findAll() {
        return clientRepo.loadClient();
    }

    public Client findById(int Id) {

        return clientRepo.findById(Id);
    }

    public void delete(int id) {
        clientRepo.delete(id);
    }

    public void updateTheClient(int id, Client client) {
        clientRepo.update(id, client);
    }



    public void updateAddress(int id, String address){
        clientRepo.updateAddress(id, address);
    }

    public void updateteCart(int id, Cart cart){
        clientRepo.updateteCart(id, cart);
    }

    public List<Client> filteredByName(String name) {
        return clientRepo.filteredByName(name);

    }
    public void addReviewToClient( Client client, int id){
        clientRepo.addReviewToClient(client, id);
    }

    public void removeReviewToClient(Client client, int id){
        clientRepo.removeReviewToClient( client, id);}

    public void addOrderToClient(Client client, int id){
        clientRepo.addOrderToClient(client, id);}

    public void removeOrderToClient(Client client, int id){
        clientRepo.removeOrderToClient(client, id);}
}
