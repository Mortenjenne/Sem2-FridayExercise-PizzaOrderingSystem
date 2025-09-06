package pizza.service;

import pizza.model.Pizza;

import java.util.List;

public class PizzaPrinter {

    public void print(List<Pizza> pizzas){
        if(pizzas != null && !pizzas.isEmpty()){
            System.out.printf("%s  %-45s %s\n","#","Pizza","Price");
            System.out.printf("------------------------------------------------------\n");
            for(int i= 0; i < pizzas.size(); i++){
                System.out.printf("%d) %-45s $%.2f\n",
                        i + 1,
                        pizzas.get(i).getDescription(),
                        pizzas.get(i).getCost());
            }
        } else {
            System.out.println("Ingen pizzaer at vise");
        }
    }
}
