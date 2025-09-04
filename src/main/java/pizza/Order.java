package pizza;

public class Order {
    private DeliveryStrategy deliveryStrategy;
    private Pizza pizza;

    public Order(Pizza pizza) {
        this.pizza = pizza;
    }

    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public void processOrder() {
        System.out.println("Order: " + pizza.getDescription() + " $" + pizza.getCost());
        // TODO: call deliver on the selected strategy
    }
}
