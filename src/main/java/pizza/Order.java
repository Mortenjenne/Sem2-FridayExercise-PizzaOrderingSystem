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
        deliveryStrategy.deliver(pizza);
    }
}
