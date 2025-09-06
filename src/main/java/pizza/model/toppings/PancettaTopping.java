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
        return ", Pancetta";
    }

    @Override
    public double getCost() {
        return 4.0;
    }
}
