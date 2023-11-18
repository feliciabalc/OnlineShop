package Repository;

import Entities.*;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientRepo extends AbstractRepo {
    private ReviewRepo reviewRepo;
    private CartRepo cartRepo;
    private OrdersRepo ordersRepo;


    public ClientRepo(String fileName, String ArticlesFile, String specificationFilename, String reviewFilename, String cartFilename, String orderFile) {

        super(fileName);
        this.reviewRepo = new ReviewRepo(reviewFilename);
        this.cartRepo = new CartRepo(cartFilename,  specificationFilename,  ArticlesFile, reviewFilename);
        this.ordersRepo = new OrdersRepo(orderFile, specificationFilename,  reviewFilename, ArticlesFile);
    }

    @Override
    public void save(List objects) {
        super.save(objects);
    }
    public List<Client> loadClient() {
        Type clientListType = new TypeToken<List<Client>>() {}.getType();
        return load(clientListType);
    }


    public void saveOneObject(Client client) {
        List<Client> clients = loadClient();
        Iterator<Client> iterator = clients.iterator();

        while (iterator.hasNext()) {
            Client item = iterator.next();
            if (item.getId() == client.getId()) {
                iterator.remove(); // Remove the existing client
            }
        }

        clients.add(client); // Add the new or updated client
        save(clients);
    }


    public void deleteObj(Client client){
        List<Client> allClient =loadClient();
        allClient.remove(client);
        save(allClient);
    }

    public List<Client> findAll(){
        return loadClient();
    }


    public Client findById(int Id){
        List<Client> allClient = loadClient();
        Client foundItem = null;
        for(Client item : allClient){
            if(item.getId() == Id)
                foundItem =item;

        }

        return foundItem;
    }

    public void delete(int Id) {
        List<Client> clientList = loadClient();
        Client foundItem = null;
        int indexToRemove = -1;

        for (int i = 0; i < clientList.size(); i++) {
            Client item = clientList.get(i);
            if (item.getId() == Id) {
                foundItem = item;
                indexToRemove = i;
                break;
            }
        }

        if (foundItem != null && indexToRemove != -1) {
            clientList.remove(indexToRemove);
            save(clientList);
            System.out.println("Article with ID " + Id + " has been deleted.");
        } else {
            System.out.println("Article with ID " + Id + " not found.");
        }
    }



    public void update(int id, Client updatedClient) {
        List<Client> clientList = loadClient();
        boolean found = false;

        for (int i = 0; i < clientList.size(); i++) {
            Client client = clientList.get(i);
            if (client.getId() == id) {
                client.setName(updatedClient.getName());
                client.setAddress(updatedClient.getAddress());
                client.setTelefon(updatedClient.getTelefon());
                found = true;
                break;
            }
        }

        if (found) {
            save(clientList);
            System.out.println("Article with ID " + id + " has been updated.");
        } else {
            System.out.println("Article with ID " + id + " not found.");
        }
    }

    public void addReviewToClient(Client client, int id){
        Review review = reviewRepo.findById(id);
        client.addReview(review);
        saveOneObject(client);
    }

    public void removeReviewToClient(Client client, int id){
        Review review = reviewRepo.findById(id);
        client.removeReview(review);
        saveOneObject(client);
    }

    public void addOrderToClient(Client client, int id){
        Orders order = ordersRepo.findById(id);
        client.addOrders(order);
        saveOneObject(client);
    }

    public void removeOrderToClient(Client client, int id){
        Orders order = ordersRepo.findById(id);
        client.removeOrders(order);
        saveOneObject(client);
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
            if (item.getName().contains(name))
                filteredClient.add(item);
        }
        return filteredClient;

    }

    public void setCart(Client client, int id){
        Cart cart = cartRepo.findById(id);
        client.setCart(cart);
    }



}