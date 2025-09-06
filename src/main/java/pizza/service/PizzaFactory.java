package pizza.service;

import pizza.model.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PizzaFactory {
    private static Map<String,Function<String,Pizza>> registry = new HashMap<>();

    static{
        registry.put("MARGHERITA", type -> new MargheritaPizza());
        registry.put("VEGGIE", type -> new VeggiePizza());
        registry.put("POTATO", type -> new PotatoPizza());
        registry.put("CAULIFLOWER", type -> new CauliflowerTrufflePizza());
        registry.put("PROSCIUTTO", type -> new ProscuittoPizza());
        registry.put("QUATTRO_FORMAGGIO", type -> new QuattroFormaggio());
    }

    public Pizza createPizza(String type){
        Function<String,Pizza> creator = registry.get(type);
        if(creator == null){
            throw new IllegalArgumentException("Invalid pizza type" + type);
        }
        return creator.apply(type);
    }

    public List<Pizza> getAvaliblePizzas(){
        return registry.values()
                .stream()
                .map(type -> type.apply(""))
                .sorted(Comparator.comparing((Pizza::getCost)))
                .collect(Collectors.toList());
    }

}
