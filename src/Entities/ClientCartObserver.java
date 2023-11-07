package Entities;

public class ClientCartObserver implements CartObserver {
    private Client client;

    public ClientCartObserver(Client client) {
        this.client = client;
    }


    @Override
    public void update(Cart cart) {
        System.out.println("Articles fron you cart has changes............Take a look....Cart with id " + cart.getId());
    }
}
