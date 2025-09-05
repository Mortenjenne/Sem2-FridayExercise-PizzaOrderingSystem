package pizza.model.toppings;

import pizza.model.Pizza;

public abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;
    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}
