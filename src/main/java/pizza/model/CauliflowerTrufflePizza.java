package pizza.model;

public class CauliflowerTrufflePizza implements Pizza {

    @Override
    public String getName() {
        return "Cauliflower";
    }

    @Override
    public String getDescription() {
        return "Cauliflower pizza with truffle mascarpone and pecorino";
    }

    @Override
    public double getCost() {
        return 13.50;
    }
}
