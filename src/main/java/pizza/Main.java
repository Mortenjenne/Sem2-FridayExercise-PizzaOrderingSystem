package pizza;

public class Main {
    public static void main(String[] args) {
        Pizza margerita = new PizzaFactory().createPizza("MARGARITA");
        Pizza veggie = new PizzaFactory().createPizza("Veggie");

        System.out.println(margerita.getDescription() + " $" + margerita.getCost());
        System.out.println(veggie.getDescription() + " $" + veggie.getCost());


    }
}
