package pizza.model;

public class ProscuittoPizza implements Pizza{
    @Override
    public String getName() {
        return "Prosciutto";
    }

    @Override
    public String getDescription() {
        return "Prosciutto pizza with tomato, mozzarella, prosciutto di parma and rocket";
    }

    @Override
    public double getCost() {
        return 11.00;
    }
}
