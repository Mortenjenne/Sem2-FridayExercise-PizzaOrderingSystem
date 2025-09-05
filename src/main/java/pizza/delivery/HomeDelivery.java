package pizza.delivery;

import pizza.model.Pizza;

public class HomeDelivery implements DeliveryStrategy {
    @Override
    public void deliver(Pizza pizza) {
        System.out.println("Order: " + pizza.getDescription() + " $" + pizza.getCost());
        System.out.println("Delivery method: Home Delivery selected. Your pizza will arrive soon!\n");
    }
}
