package pizza.model.toppings;

import pizza.model.Pizza;

public class JalapenosTopping extends ToppingDecorator {
    public JalapenosTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getName() {
        return pizza.getName();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Jalapenos";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 0.4;
    }
}
