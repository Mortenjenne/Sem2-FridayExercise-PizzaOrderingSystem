package pizza.delivery;

import pizza.model.Pizza;
import pizza.service.CartManager;
import pizza.service.PizzaPrinter;

import java.util.List;

public interface DeliveryStrategy {
    void deliver(CartManager cart, PizzaPrinter printer);
}
