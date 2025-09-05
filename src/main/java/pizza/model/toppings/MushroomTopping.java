package pizza.model.toppings;

import pizza.model.Pizza;

public class MushroomTopping extends ToppingDecorator {
    public MushroomTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + "Mushroom";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 0.65;
    }
}
