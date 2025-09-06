package pizza.service;

import pizza.model.Pizza;

import java.util.List;

public class PizzaPrinter {

    public void print(List<Pizza> pizzas){
        if(pizzas != null && !pizzas.isEmpty()){
            System.out.printf("%s  %-80s %s\n","#","Pizza","Price");
            System.out.printf("--------------------------------------------------------------------------------------------\n");
            for(int i= 0; i < pizzas.size(); i++){
                System.out.printf("%d) %-80s $%.2f\n",
                        i + 1,
                        pizzas.get(i).getDescription(),
                        pizzas.get(i).getCost());
            }
            System.out.printf("--------------------------------------------------------------------------------------------\n");
        } else {
            System.out.println("No pizza's to show");
        }
    }

    public void printDeliveryFee(double fee){
        System.out.printf("%s  %-80s $%.2f\n","#","Delivery cost",fee);
    }

    public void printTotal(double total){
        System.out.printf("%s  %-80s $%.2f\n","#","Total",total);
        System.out.printf("--------------------------------------------------------------------------------------------\n");
    }
}
