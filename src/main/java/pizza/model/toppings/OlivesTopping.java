package pizza.model.toppings;

import pizza.model.Pizza;

public class OlivesTopping extends ToppingDecorator {
    public OlivesTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getName() {
        return pizza.getName();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 0.75;
    }
}
