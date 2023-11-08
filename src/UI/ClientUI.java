package UI;

import Controller.ClientController;
import Entities.Cart;
import Entities.Client;
import Entities.Orders;
import Entities.Review;
import Repository.CartRepo;
import Repository.ClientRepo;

import java.util.List;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter you id: ");
        int idClient= Integer.parseInt(scanner.nextLine());
        System.out.println("Enter you new address: ");
        String newAddress = scanner.nextLine();
        clientController.updateAddress(id, address);
    }

    public void updateteCart(int id, Cart cart) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the cart id: ");
        int idCart= Integer.parseInt(scanner.nextLine());
        CartRepo cartRepo = new CartRepo("CartFile.json");
        System.out.println("Please enter the new quantity: " );
        double quantity = Double.parseDouble(scanner.nextLine());
        clientController.updateteCart(id, cart);
    }

    public List<Client> filteredByName(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name you want the client to be filtered by: ");
        String givenName = scanner.nextLine();
        return clientController.filteredByName(givenName);
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