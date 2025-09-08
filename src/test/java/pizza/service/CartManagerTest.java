package pizza.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pizza.discount.TenPercentDiscount;
import pizza.model.MargheritaPizza;
import pizza.model.Pizza;

import static org.junit.jupiter.api.Assertions.*;
class CartManagerTest {
    CartManager cart;
    Pizza pizza;

    @BeforeEach
    void setUp() {
        cart = new CartManager();
        pizza = new MargheritaPizza();
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Adding amount to cart saves in cart manager")
    @Test
    void addToTotal() {
        double expected = 4.0;
        cart.addToTotal(4.0);
        double actual = cart.getTotal();
        assertEquals(expected,actual);
    }

    @DisplayName("Test adding pizza to shoppingCart")
    @Test
    void addToShoppingCart() {
        cart.addToShoppingCart(pizza);
        int expected = 1;
        int actual = cart.getShoppingCart().size();
        assertEquals(expected,actual);
    }

    @DisplayName("Test adding pizza to shoppingCart, increments ammount")
    @Test
    void testTotalAfterAdding2Pizzas() {
        cart.addToShoppingCart(pizza);
        cart.addToShoppingCart(pizza);
        double expected = 10.0;
        double actual = cart.getTotal();
        assertEquals(expected,actual);
    }

    @DisplayName("Test shopping cart is empty after customer pays")
    @Test
    void testClearCart() {
            cart.addToShoppingCart(pizza);
            cart.clearCart();
            int expected = 0;
            int actual = cart.getShoppingCart().size();
            assertEquals(expected,actual);
        }

    @DisplayName("Test total is zero after customer pays")
    @Test
    void testClearCartTotalIsZeroAfter() {
        cart.addToShoppingCart(pizza);
        cart.addToShoppingCart(pizza);
        cart.clearCart();
        double expected = 0.0;
        double actual = cart.getTotal();
        assertEquals(expected,actual);
    }

    @DisplayName("Test customer has a 10% off total cupon")
    @Test
    void testTenPercentDiscount() {
        cart.addToShoppingCart(pizza);
        cart.addToShoppingCart(pizza);
        cart.setDiscount(new TenPercentDiscount());
        double expected = 9.0;
        double actual = cart.getTotal();
        assertEquals(expected,actual);
    }
}