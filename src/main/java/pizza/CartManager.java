package pizza;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private double total;;
    private List<Pizza> shoppingCart;

    public CartManager() {
        this.total = 0;
        this.shoppingCart = new ArrayList<>();
    }

    public void addToTotal(double amount) {
        this.total += amount;
    }

    public double getTotal() {
        return Math.round(this.total * 100.0) / 100.0;
    }


    public void addToShoppingCart(Pizza pizza) {
        this.shoppingCart.add(pizza);
        addToTotal(pizza.getCost());
    }

    public List<Pizza> getShoppingCart() {
        return new ArrayList<>(shoppingCart);
    }

    public void clearCart() {
        this.shoppingCart.clear();
        this.total = 0;
    }
}

