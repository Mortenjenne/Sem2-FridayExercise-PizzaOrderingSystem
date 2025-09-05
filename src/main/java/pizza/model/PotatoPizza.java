package pizza.model;

public class PotatoPizza implements Pizza{
    @Override
    public String getDescription() {
        return "Potato pizza with rosemary";
    }

    @Override
    public double getCost() {
        return 8.25;
    }
}
