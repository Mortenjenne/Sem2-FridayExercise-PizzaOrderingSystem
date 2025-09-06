package pizza.model;

public class PotatoPizza implements Pizza{

    @Override
    public String getName() {
        return "Potato";
    }

    @Override
    public String getDescription() {
        return "Potato pizza with ricotta and rosemary";
    }

    @Override
    public double getCost() {
        return 8.25;
    }
}
