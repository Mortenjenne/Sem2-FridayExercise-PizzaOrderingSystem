package pizza.service;

import pizza.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PizzaFactory {
    private static Map<PizzaType, Supplier<Pizza>> registry = new HashMap<>();

    static{
        registry.put(PizzaType.Margherita,MargheritaPizza::new);
        registry.put(PizzaType.Veggie,VeggiePizza::new);
        registry.put(PizzaType.PATATE,PotatoPizza::new);
        registry.put(PizzaType.CAVOLFIORE,CauliflowerTrufflePizza::new);
        registry.put(PizzaType.PROSCUITTO,ProscuittoPizza::new);
        registry.put(PizzaType.QUATTRO_FORMAGGIO,QuattroFormaggi::new);
    }

    public Pizza createPizza(PizzaType type){
        Supplier<Pizza> creator = registry.get(type);
        if(creator == null){
            throw new IllegalArgumentException("Invalid pizza type" + type);
        }
        return creator.get();
    }

    public List<Pizza> getAvaliblePizzas(){
        return registry.values()
                .stream()
                .map(Supplier::get)
                .collect(Collectors.toList());
    }
}
