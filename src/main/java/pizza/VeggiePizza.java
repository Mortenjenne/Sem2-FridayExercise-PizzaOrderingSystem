package pizza;

public class VeggiePizza implements Pizza {
    @Override
    public String getDescription() {
        return "Veggie Pizza";
    }

    @Override
    public double getCost() {
        return 6.0;
    }

}
