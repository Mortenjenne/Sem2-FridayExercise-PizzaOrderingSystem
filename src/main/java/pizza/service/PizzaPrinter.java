package pizza.service;

import pizza.model.Pizza;

import java.util.List;

public class PizzaPrinter {

    public void print(List<Pizza> pizzas){
        if(pizzas != null && !pizzas.isEmpty()){
            for(int i= 0; i < pizzas.size(); i++){
                System.out.printf("%d) %s, Price: $%d",i + 1,pizzas.get(i).getDescription(),pizzas.get(i).getCost());
            }
        } else {
            System.out.println("Ingen pizzaer at vise");
        }
    }
}
