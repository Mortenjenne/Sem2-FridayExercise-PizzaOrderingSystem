package pizza.delivery;

import pizza.model.Pizza;

public class DroneDelivery implements DeliveryStrategy {
    @Override
    public void deliver(Pizza pizza) {
        System.out.println("Order: " + pizza.getDescription() + " $" + pizza.getCost());
        System.out.println("Delivery method: Drone Delivery selected. Your pizza will arrive soon!\n");
    }

}
