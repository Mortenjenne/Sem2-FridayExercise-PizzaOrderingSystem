package pizza.model.toppings;

import pizza.model.Pizza;

public class PancettaTopping extends ToppingDecorator{
    public PancettaTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getName() {
        return pizza.getName();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pancetta";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 4.0;
    }
}
