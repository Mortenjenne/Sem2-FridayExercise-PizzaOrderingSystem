package pizza.service;

import pizza.model.PizzaType;
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

    PizzaManager(String shopName){
        this.appRunning = true;
        this.shopName = shopName;
        this.ui = new UserInterface(shopName);
        this.factory = new PizzaFactory();
        this.cart = new CartManager();
        this.pizzaPrinter = new PizzaPrinter();
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
                    checkout();
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
        PizzaType[] pizzaTypes = PizzaType.values();
        while(true){
            if(isValidTaskNumber(choice)){
                PizzaType type = pizzaTypes[choice];
                Pizza pizza = factory.createPizza(type);
                return pizza;
            }
        }
    }

    private void selectPizza(){
        showMenu();
        int choice = ui.promptNumeric("Which pizza would you like to order? \nChoose by number");
        Pizza pizza = choosePizza(choice - 1);

        boolean userWantsToAddTopping = ui.promptBinary("Would you like to add topping to your pizza?");

        if(userWantsToAddTopping){
            pizza = selectTopping(pizza);
        }
        ui.printMessage("Ordered pizza: " + pizza.getDescription() + " | Total: " + pizza.getCost() + "$");
        cart.addToShoppingCart(pizza);
    }

    private void handleMultiplePizzaOrder(){
        boolean continueOrdering = true;
        while (continueOrdering) {
            continueOrdering = ui.promptBinary("Do you want order more pizza?");
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
            ui.printMessage("1) Cheese \n2) Mushrooms \n3) Olive \n4) Pancetta \nPepperoni \nJalapenos \nx) Done");

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

//    private void showShoppingCart() {
//        if (cart.getShoppingCart().isEmpty()) {
//            ui.printMessage("None pizza's has been added to your order");
//        } else {
//            ui.printMessage("Your order:");
//            showFlowersInBasket();
//            ui.printMessage("Total: " + cartManager.getTotal() + " Kr.");
//        }
//    }

    private void checkOut() {
        if (cart.getShoppingCart().isEmpty()) {
            ui.printMessage("None pizza's has been added to your order");
            return;
        }

        boolean pay = ui.promptBinary("Would you like to pay Y/N");
        if (pay) {
            ui.printMessage("---Receipt---");
            pizzaPrinter.print(cart.getShoppingCart());
            ui.printMessage("----------------");
            ui.printMessage("Total: " + cart.getTotal() + "$");
            ui.printMessage("Tak for dit køb");
            cart.clearCart();
        }
    }

    private void quit() {
        ui.printMessage("Thank you for visiting " + shopName);
        appRunning = false;
    }




}
