package pizza.service;

import pizza.discount.DiscountStrategy;
import pizza.discount.NoDiscount;
import pizza.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private double total;;
    private List<Pizza> shoppingCart;
    private DiscountStrategy discount;

    public CartManager() {
        this.total = 0;
        this.shoppingCart = new ArrayList<>();
        this.discount = new NoDiscount();
    }

    public void addToTotal(double amount) {
        this.total += amount;
    }

    public double getTotal() {
        double totalAfterDiscount = discount.applyDiscount(total);
        return Math.round(totalAfterDiscount * 100.0) / 100.0;
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

    public void setDiscount(DiscountStrategy discount){
        this.discount = discount;
    }
}

