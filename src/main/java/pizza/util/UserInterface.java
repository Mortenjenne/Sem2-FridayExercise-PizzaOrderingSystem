package pizza.util;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private String shopName;

    public UserInterface(String shopName) {
        this.scanner = new Scanner(System.in);
        this.shopName = shopName;
    }

    public void showMenu() {
        System.out.println("");
        System.out.println(shopName);
        System.out.println("1) Menu");
        System.out.println("2) Order pizza");
        System.out.println("x) Quit");
    }

    public String readInput(String message) {
        System.out.println(message);
        String input = scanner.nextLine();
        return input;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public int promptNumeric(String message) {
        System.out.println(message);
        int numberInput = 0;
        boolean isNumberValid = false;
        while (!isNumberValid) {
            String input = scanner.nextLine();
            try {
                numberInput = Integer.parseInt(input);
                isNumberValid= true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer");
            }
        }
        return numberInput;
    }
}
