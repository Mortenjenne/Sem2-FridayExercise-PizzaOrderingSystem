package pizza;

public class PepperoniTopping extends ToppingDecorator {
    public PepperoniTopping(Pizza pizza) {
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
