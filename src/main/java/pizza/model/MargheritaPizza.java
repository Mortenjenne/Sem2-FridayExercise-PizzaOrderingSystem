package pizza.model;

public class MargheritaPizza implements Pizza {

    @Override
    public String getName() {
        return "Margherita";
    }

    @Override
    public String getDescription() {
        return "Margherita Pizza with tomato sauce, mozzarella and basil";
    }

    @Override
    public double getCost() {
        return 5.0;
    }

}
