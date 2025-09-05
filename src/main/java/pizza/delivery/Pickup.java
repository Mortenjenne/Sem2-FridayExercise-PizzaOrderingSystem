package pizza.delivery;

import pizza.model.Pizza;

public class Pickup implements DeliveryStrategy {
    @Override
    public void deliver(Pizza pizza) {
        System.out.println("Order: " + pizza.getDescription() + " $" + pizza.getCost());
        System.out.println("Delivery method: Pickup selected. Your pizza will be ready at appointed time\n");
    }

}
