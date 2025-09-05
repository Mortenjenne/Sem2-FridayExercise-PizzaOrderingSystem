package pizza;

import pizza.delivery.Pickup;
import pizza.model.PizzaType;
import pizza.model.toppings.CheeseTopping;
import pizza.model.toppings.PepperoniTopping;
import pizza.model.Pizza;
import pizza.service.Order;
import pizza.service.PizzaFactory;

import java.util.List;

public class PizzaDemo {
    public static void main(String[] args) {
        PizzaFactory factory = new PizzaFactory();

        // Base pizzas
        Pizza margarita = factory.createPizza(PizzaType.Margherita);
        Pizza veggie = factory.createPizza(PizzaType.Veggie);

        System.out.println(margarita.getDescription() + " $" + margarita.getCost());
        System.out.println(veggie.getDescription() + " $" + veggie.getCost());
        System.out.println("######################");

        // Decorated pizzas
        Pizza veggieCheese = factory.createPizza(PizzaType.Veggie);
        Pizza margaritaPep = factory.createPizza(PizzaType.Margherita);

        veggieCheese = new CheeseTopping(veggieCheese);
        margaritaPep = new CheeseTopping(margaritaPep);
        margaritaPep = new PepperoniTopping(margaritaPep);

        System.out.println(veggieCheese.getDescription() + " $" + veggieCheese.getCost());
        System.out.println(margaritaPep.getDescription() + " $" + margaritaPep.getCost());
        System.out.println("##########################");

        //Order pizzas
        Order newOrder = new Order(veggieCheese);
        newOrder.setDeliveryStrategy(new Pickup());
        newOrder.processOrder();

        List<Pizza> pizzaList = factory.getAvaliblePizzas();
        pizzaList.forEach(pizza -> pizza.getDescription());
    }
}
