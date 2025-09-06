package pizza.model;

public class VeggiePizza implements Pizza{

    @Override
    public String getName() {
        return "Veggie";
    }

    @Override
    public String getDescription() {
        return "Vegetarian pizza with tomato, mozzarella, olives, parmesan and grilled eggplant";
    }

    @Override
    public double getCost() {
        return 6.0;
    }

}
