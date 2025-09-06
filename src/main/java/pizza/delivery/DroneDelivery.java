package pizza.delivery;

import pizza.model.Pizza;
import pizza.service.CartManager;
import pizza.service.PizzaPrinter;

import java.util.List;

public class DroneDelivery implements DeliveryStrategy {
    @Override
    public void deliver(CartManager cartManager, PizzaPrinter printer) {
        double deliveryCost = 5.0;
        cartManager.addToTotal(deliveryCost);
        System.out.println("\n--- Your Order ---");
        printer.print(cartManager.getShoppingCart());
        System.out.println("Delivery method: Drone Delivery selected");
        printer.printDeliveryFee(deliveryCost);
        printer.printTotal(cartManager.getTotal());
        System.out.println("Your pizza will arrive soon!\n");
    }

}
