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

    public void save(List<Client> clients) {
        Client client1= new Client(1,"Ion", "piupiu 23", 0897.6535);
        Client client2= new Client(2,"Mark", "dunarii 1", 0844.6535);
        Client client3= new Client(3,"Sergiu", "copacului 4", 0899.6535);
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clientRepo.save(clients);
    }

    public void saveOneObject(Client client){
        clientRepo.saveOneObject(client);}

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
        List<Client> clientsList = loadClient();
        boolean found = false;

        for (int i = 0; i < clientsList.size(); i++) {
            Client clients = clientsList.get(i);
            if (clients.getId() == id) {
                clients.setAddress(address);
                found = true;
                break;
            }
        }
        if (found) {
            save(clientsList);
            System.out.println("Client with ID " + id + " has been updated.");
        } else {
            System.out.println("Client with ID " + id + " not found.");
        }
    }

    public void updateteCart(int id, Cart cart){
        List<Client> clientList = loadClient();
        boolean found = false;

        for (int i = 0; i < clientList.size(); i++) {
            Client client = clientList.get(i);
            if (client.getId() == id) {
                client.setCart(cart);
                found = true;
                break;
            }
        }
        if (found) {
            save(clientList);
            System.out.println("Courier with ID " + id + " has been updated.");
        } else {
            System.out.println("Courier with ID " + id + " not found.");
        }
    }

    public List<Client> filteredByName(String name) {
        List<Client> clients = loadClient();
        List<Client> filteredClient = new ArrayList<>();
        for (Client item : clients) {
            if (item.getName() == name)
                filteredClient.add(item);
        }
        return filteredClient;

    }
    public void addReviewToClient(Review review, Client client){
        clientRepo.addReviewToClient(review, client);
    }

    public void removeReviewToClient(Review review, Client client){
        clientRepo.removeReviewToClient(review, client);}

    public void addOrderToClient(Orders order, Client client){
        clientRepo.addOrderToClient(order, client);}

    public void removeOrderToClient(Orders order, Client client){
        clientRepo.removeOrderToClient(order, client);}
}
