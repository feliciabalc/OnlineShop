package Entities;

public class ClientOrderObserver implements OrderObserver {
    private Client client;

    public ClientOrderObserver(Client client) {
        this.client = client;
    }


    @Override
    public void update(Orders order) {
        System.out.println("Order with id " + order.getId() + " has been updated succesfully for client: " + client.getName() + " with id " + client.getId());
    }
}
