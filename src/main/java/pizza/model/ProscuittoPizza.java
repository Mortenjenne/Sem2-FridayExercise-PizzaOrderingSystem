package pizza.model;

public class ProscuittoPizza implements Pizza{
    @Override
    public String getDescription() {
        return "Prosciutto pizza with tomato and parmesan";
    }

    @Override
    public double getCost() {
        return 11.00;
    }
}
