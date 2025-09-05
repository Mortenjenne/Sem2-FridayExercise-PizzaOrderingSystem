package pizza;

public class CheeseTopping extends ToppingDecorator {
    public CheeseTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public double getCost() {
        return 0;
    }

    // TODO: override getDescription() and getCost()
}
