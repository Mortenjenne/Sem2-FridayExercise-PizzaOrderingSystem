package pizza;

public class JalapenosTopping extends ToppingDecorator{
    public JalapenosTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + "Jalapenos";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 0.4;
    }
}
