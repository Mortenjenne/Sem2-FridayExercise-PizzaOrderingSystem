package pizza.model;

public class QuattroFormaggi implements Pizza{
    @Override
    public String getDescription() {
        return "Quattro formaggi pizza";
    }

    @Override
    public double getCost() {
        return 12.00;
    }
}
