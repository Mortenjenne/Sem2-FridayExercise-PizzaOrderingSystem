package pizza.service;

import pizza.delivery.DeliveryStrategy;
import pizza.delivery.DroneDelivery;
import pizza.delivery.HomeDelivery;
import pizza.delivery.Pickup;
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
                case "1":
                    showMenu();
                    break;
                case "2":
                    orderPizza();
                    break;
                case "3":
                    checkOut();
                    break;
                case "x":
                    quit();
                    break;
                default:
                    ui.printMessage("Didnt recognize this command, try again.");
                    break;
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

    private void checkout(){

    }

    private boolean isValidTaskNumber(int index){
        if(index >= 0 && index < factory.getAvaliblePizzas().size()){
            return true;
        } else {
            ui.printMessage("Invalid task number. Please enter a number between 1 and " + factory.getAvaliblePizzas().size());
            return false;
        }
    }

    private Pizza choosePizza(int choice){
        while(true){
            if(isValidTaskNumber(choice)) {
                try {
                    String type = factory.getAvaliblePizzas().get(choice).getName();
                    Pizza pizza = factory.createPizza(type.toUpperCase());
                    return pizza;
                } catch (IllegalArgumentException e){
                }
            }
        }
    }

    private void selectPizza(){
        showMenu();
        int choice = ui.promptNumeric("Which pizza would you like to order? \nChoose by number");
        Pizza pizza = choosePizza(choice - 1);

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

            String choice = ui.readInput("Your choice:");
            switch (choice){
                case "1":
                    decoratedPizza = new CheeseTopping(decoratedPizza);
                    break;
                case "2":
                    decoratedPizza = new MushroomTopping(decoratedPizza);
                    break;
                case "3":
                    decoratedPizza = new OlivesTopping(decoratedPizza);
                    break;
                case "4":
                    decoratedPizza = new PancettaTopping(decoratedPizza);
                    break;
                case "5":
                    decoratedPizza = new PepperoniTopping(decoratedPizza);
                    break;
                case "6":
                    decoratedPizza = new JalapenosTopping(decoratedPizza);
                    break;
                case "x":
                    addingToppings = false;
                    break;
                default:
                    ui.printMessage("Invalid choice. Try again");
            }
        }
        return decoratedPizza;
    }


    private void checkOut() {
        showShoppingCart();
        boolean customerWantsToPay = ui.promptBinary("Would you like to pay and choose delivery options Y/N");

        if (customerWantsToPay) {
            DeliveryStrategy delivery = chooseDelivery();
            order.setDeliveryStrategy(delivery);
            order.processOrder();
            cart.clearCart();
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
        ui.printMessage("Total: " + cart.getTotal() + "$");
    }

    private DeliveryStrategy chooseDelivery(){
        System.out.println("Choose delivery method:");
        System.out.println("1) Pickup");
        System.out.println("2) Home Delivery");
        System.out.println("3) Drone Delivery");

        int choice = ui.promptNumeric("Enter the number of your choice:");
        DeliveryStrategy strategy;
        while(true) {
            switch (choice) {
                case 1:
                    return strategy = new Pickup();
                case 2:
                    return strategy = new HomeDelivery();
                case 3:
                    return strategy = new DroneDelivery();
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void printReceipt(){
            ui.printMessage("---Receipt---");
            pizzaPrinter.print(cart.getShoppingCart());
            ui.printMessage("----------------");
            ui.printMessage("Total: " + cart.getTotal() + "$");
            ui.printMessage("Thank you for your order");
            cart.clearCart();
    }

    private void quit() {
        ui.printMessage("Thank you for visiting " + shopName);
        appRunning = false;
    }
}
