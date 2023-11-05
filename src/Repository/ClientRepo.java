package Repository;

import Entities.*;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ClientRepo extends AbstractRepo {
    public ClientRepo(String fileName) {

        super(fileName);
    }

    @Override
    public void save(List objects) {
        super.save(objects);
    }
    public List<Client> loadClient() {
        Type clientListType = new TypeToken<List<Client>>() {}.getType();
        return load(clientListType);
    }

    public void saveOneObject(Client client){
        List<Client> clients =loadClient();
        for(Client item : clients)
            if(item.getId()== client.getId())
                item = client;
            else
                clients.add(client);
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

    public void addReviewToClient(Review review, Client client){
        client.addReview(review);
        saveOneObject(client);
    }

    public void removeReviewToClient(Review review, Client client){
        client.removeReview(review);
        saveOneObject(client);
    }

    public void addOrderToClient(Orders order, Client client){
        client.addOrders(order);
        saveOneObject(client);
    }

    public void removeOrderToClient(Orders order, Client client){
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
            if (item.getName() == name)
                filteredClient.add(item);
        }
        return filteredClient;

    }



}