package pizza.service;

import pizza.delivery.DeliveryStrategy;
import pizza.model.Pizza;

import java.util.List;

public class Order {
    private DeliveryStrategy deliveryStrategy;
    private PizzaPrinter printer;
    private CartManager cartManager;

    public Order(CartManager cartManager, PizzaPrinter printer) {
        this.cartManager = cartManager;
        this.printer = printer;
    }

    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public void processOrder() {
        deliveryStrategy.deliver(cartManager,printer);
    }
}
