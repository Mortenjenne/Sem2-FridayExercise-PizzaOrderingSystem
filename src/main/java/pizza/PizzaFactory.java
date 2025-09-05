package pizza;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PizzaFactory {
    private static Map<String, Function<String, Pizza>> registry = new HashMap<>();

    static{
        registry.put("MARGARITA", type -> new MargheritaPizza());
        registry.put("VEGGIE", type -> new VeggiePizza());
    }

    public Pizza createPizza(String type){
        Function<String,Pizza> creator = registry.get(type.toUpperCase());
        if(creator == null){
            throw new IllegalArgumentException("Invalid pizza type" + type);
        }
        return creator.apply(type);
    }
}
