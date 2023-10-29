package UI;

import Controller.CartController;

public class CartUI {
    private CartController cartController;

    public CartUI(CartController cartController) {
        this.cartController = cartController;
    }

    public CartController getCartController() {
        return cartController;
    }

    public void setCartController(CartController cartController) {
        this.cartController = cartController;
    }
}
