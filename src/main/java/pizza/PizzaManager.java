package pizza;

import pizza.util.UserInterface;

public class PizzaManager {
    String shopName;
    boolean appRunning;
    UserInterface ui;
    PizzaFactory factory;
    CartManager cart;
    Order order;

    PizzaManager(String shopName){
        this.appRunning = true;
        this.shopName = shopName;
        this.ui = new UserInterface(shopName);
        this.factory = new PizzaFactory();
        this.cart = new CartManager();
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

    }

    private void orderPizza(){

    }

    private void checkout(){

    }

    private void quit() {
        ui.printMessage("Thank you for visiting " + shopName);
        appRunning = false;
    }
}
