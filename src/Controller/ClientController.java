package Controller;
import Entities.*;
import Repository.CartRepo;
import Repository.ClientRepo;
import Repository.OrderRepo;
import Repository.ReviewRepo;

import java.util.ArrayList;
import java.util.List;

public class ClientController {
    private ClientRepo clientRepo;
    private ReviewRepo reviewRepo;
    private final CartRepo cartRepo;
    private final OrderRepo orderRepo;

    public ClientController(
        ClientRepo clientRepo,
        ReviewRepo reviewRepo,
        CartRepo cartRepo,
        OrderRepo orderRepo
    ) {

        this.clientRepo = clientRepo;
        this.reviewRepo = reviewRepo;
        this.cartRepo = cartRepo;
        this.orderRepo = orderRepo;
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

        clientRepo.addReviewToClient(client2, reviewRepo.findById(1));
        clientRepo.addOrderToClient(client1, orderRepo.findById(1));
        client1.setCart(cartRepo.findById(1));
        clientRepo.save(clients);

    }


    public void saveOneObject(Client client){
        clientRepo.saveOneObject(client);;}

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
        Review review=reviewRepo.findById(id);
        clientRepo.addReviewToClient(client, review);
    }

    public void removeReviewToClient(Client client, int id){
        Review review=reviewRepo.findById(id);
        clientRepo.removeReviewToClient( client, review);}

    public void addOrderToClient(Client client, int id){
        Order order=orderRepo.findById(id);
          clientRepo.addOrderToClient(client, order);
    }

    public void removeOrderToClient(Client client, int id){
        Order order=orderRepo.findById(id);
        clientRepo.removeOrderToClient(client, order);}

    public void setCart(Client client, int id){
        Cart cart = cartRepo.findById(id);
        cartRepo.saveOneObject(cart);
        clientRepo.setCart(client, cart);
    }


}
