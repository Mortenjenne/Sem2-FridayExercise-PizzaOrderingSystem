package pizza.model;

public class CauliflowerTrufflePizza implements Pizza {
    @Override
    public String getDescription() {
        return "Cauliflower pizza with truffle mascarpone";
    }

    @Override
    public double getCost() {
        return 13.50;
    }
}
