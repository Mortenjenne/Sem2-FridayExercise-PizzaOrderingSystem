package pizza.delivery;

import pizza.model.Pizza;

public interface DeliveryStrategy {
    void deliver(Pizza pizza);
}
