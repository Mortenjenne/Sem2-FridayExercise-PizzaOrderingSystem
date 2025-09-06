package pizza.delivery;

import pizza.service.CartManager;
import pizza.service.PizzaPrinter;

public class Pickup implements DeliveryStrategy {
    @Override
    public void deliver(CartManager cartManager, PizzaPrinter printer) {
        double deliveryCost = 0.0;
        cartManager.addToTotal(deliveryCost);
        System.out.println("\n--- Your Order ---");
        printer.print(cartManager.getShoppingCart());
        printer.printTotal(cartManager.getTotal());
        System.out.printf("Delivery method: Pickup selected. Delivery cost : %2.f$\n);",deliveryCost);
        System.out.println("Your pizza will be done as soon as possible!");
    }
}
