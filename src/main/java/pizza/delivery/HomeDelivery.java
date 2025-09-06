package pizza.delivery;

import pizza.model.Pizza;
import pizza.service.CartManager;
import pizza.service.PizzaPrinter;

import java.util.List;

public class HomeDelivery implements DeliveryStrategy {
    @Override
    public void deliver(CartManager cartManager, PizzaPrinter printer) {
        double deliveryCost = 2.0;
        cartManager.addToTotal(deliveryCost);
        System.out.println("\n--- Your Order ---");
        printer.print(cartManager.getShoppingCart());
        System.out.println("Delivery method: Home Delivery selected.\n");
        printer.printDeliveryFee(deliveryCost);
        printer.printTotal(cartManager.getTotal());
        System.out.println("Your pizza will arrive soon!\n");
    }
}
