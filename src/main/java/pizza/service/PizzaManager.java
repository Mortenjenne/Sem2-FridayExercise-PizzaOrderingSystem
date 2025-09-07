package pizza.service;

import pizza.delivery.DeliveryStrategy;
import pizza.delivery.DroneDelivery;
import pizza.delivery.HomeDelivery;
import pizza.delivery.Pickup;
import pizza.discount.TenPercentDiscount;
import pizza.model.Pizza;
import pizza.model.toppings.*;
import pizza.util.UserInterface;

public class PizzaManager {
    String shopName;
    boolean appRunning;
    UserInterface ui;
    PizzaFactory factory;
    CartManager cart;
    PizzaPrinter pizzaPrinter;
    Order order;

    public PizzaManager(String shopName){
        this.appRunning = true;
        this.shopName = shopName;
        this.ui = new UserInterface(shopName);
        this.factory = new PizzaFactory();
        this.cart = new CartManager();
        this.pizzaPrinter = new PizzaPrinter();
        this.order = new Order(cart,pizzaPrinter);
    }

    public void start(){

        while (appRunning){
            ui.showMenu();
            String input = ui.readInput("Awaiting command...");

            switch (input){
                case "1" -> showMenu();
                case "2" -> orderPizza();
                case "3" -> checkOut();
                case "x" -> quit();
                default -> ui.printMessage("Didnt recognize this command, try again.");
            }
        }
    }

    private void showMenu(){
        pizzaPrinter.print(factory.getAvaliblePizzas());
    }

    private void orderPizza() {
        selectPizza();
        handleMultiplePizzaOrder();
    }


    private boolean isValidIndex(int index){
        return index >= 0 && index < factory.getAvaliblePizzas().size();
    }

    private Pizza choosePizza(){
        Pizza pizza = null;
        while (pizza == null){
            int choice = ui.promptNumeric("Which pizza would you like to order? \nChoose by number");
            choice--;
            if(isValidIndex(choice)){
                try {
                    String type = factory.getAvaliblePizzas().get(choice).getName();
                    pizza = factory.createPizza(type.toUpperCase());
                } catch (IllegalArgumentException e){
                }
            } else {
                ui.printMessage("Invalid pizza number. Please enter a number between 1 and " + factory.getAvaliblePizzas().size());
            }
        }
        return pizza;
    }

    private void selectPizza(){
        showMenu();
        Pizza pizza = choosePizza();

        boolean userWantsToAddTopping = ui.promptBinary("Would you like to add topping to your pizza? Press (Y/N)");

        if(userWantsToAddTopping){
            pizza = selectTopping(pizza);
        }
        ui.printMessage("Ordered pizza: " + pizza.getDescription() + " | Total: " + pizza.getCost() + "$");
        cart.addToShoppingCart(pizza);
    }

    private void handleMultiplePizzaOrder(){
        boolean continueOrdering = true;
        while (continueOrdering) {
            continueOrdering = ui.promptBinary("Do you want order more pizza? Press (Y/N)");
            if (continueOrdering) {
                selectPizza();
            } else {
                ui.printMessage("Go to checkout to pay and choose delivery");
                break;
            }
        }
    }

    private Pizza selectTopping(Pizza basePizza){
        boolean addingToppings = true;
        Pizza decoratedPizza = basePizza;

        while (addingToppings){
            ui.printMessage("Choose a topping:");
            ui.printMessage("1) Cheese \n2) Mushrooms \n3) Olive \n4) Pancetta \n5) Pepperoni \n6) Jalapenos \nx) Done");

            String choice = ui.readInput("Your choice:").trim().toLowerCase();

            switch (choice){
                case "1" -> decoratedPizza = new CheeseTopping(decoratedPizza);
                case "2" -> decoratedPizza = new MushroomTopping(decoratedPizza);
                case "3" -> decoratedPizza = new OlivesTopping(decoratedPizza);
                case "4" -> decoratedPizza = new PancettaTopping(decoratedPizza);
                case "5" -> decoratedPizza = new PepperoniTopping(decoratedPizza);
                case "6" -> decoratedPizza = new JalapenosTopping(decoratedPizza);
                case "x" -> addingToppings = false;
                default -> ui.printMessage("Invalid choice. Try again");
            }
        }
        return decoratedPizza;
    }


    private void checkOut() {
        showShoppingCart();
        if(cart.getShoppingCart().isEmpty()){
            return;
        }
        boolean customerWantsToPay = ui.promptBinary("Would you like to pay and choose delivery options Y/N");

        if (customerWantsToPay) {
            applyDiscountOption();
            executeOrder();
        } else {
            ui.printMessage("Checkout cancelled. You can still order more pizzas");
        }
    }

    private void showShoppingCart() {
        if (cart.getShoppingCart() == null || cart.getShoppingCart().isEmpty()) {
            ui.printMessage("None pizza's has been added to your order");
            return;
        }
        ui.printMessage("Your order:");
        pizzaPrinter.print(cart.getShoppingCart());
        pizzaPrinter.printTotal(cart.getTotal());
    }

    private void applyDiscountOption() {
        boolean hasCoupon = ui.promptBinary("Do you have a discount coupon? (Y/N)");
        if (hasCoupon) {
            cart.setDiscount(new TenPercentDiscount());
            ui.printMessage("10% discount applied!");
        }
    }

    private DeliveryStrategy chooseDelivery(){
        System.out.println("Choose delivery method:");
        System.out.println("1) Pickup");
        System.out.println("2) Home Delivery");
        System.out.println("3) Drone Delivery");

        DeliveryStrategy strategy = null;

        while(strategy == null) {
            String choice = ui.readInput("Enter the number of your choice:");

            switch (choice) {
                case "1" -> strategy = new Pickup();
                case "2" -> strategy = new HomeDelivery();
                case "3" -> strategy = new DroneDelivery();
                default -> ui.printMessage("Invalid choice");
            }
        }
        return strategy;
    }

    private void executeOrder(){
        DeliveryStrategy delivery = chooseDelivery();
        order.setDeliveryStrategy(delivery);
        order.processOrder();
        ui.printMessage("Thank you for your order! Bon Appetito! 🍕");
        cart.clearCart();
    }

    private void quit() {
        ui.printMessage("Thank you for visiting " + shopName);
        appRunning = false;
    }
}
