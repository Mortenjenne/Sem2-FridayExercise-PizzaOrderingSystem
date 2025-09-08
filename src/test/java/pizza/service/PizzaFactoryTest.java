package pizza.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pizza.model.MargheritaPizza;
import pizza.model.Pizza;
import pizza.model.VeggiePizza;

import static org.junit.jupiter.api.Assertions.*;

class PizzaFactoryTest {
    PizzaFactory factory;
    Pizza pizza;

    @BeforeEach
    void setUp() {
        pizza = null;
        factory = new PizzaFactory();
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Factory returns correct Margherita pizza")
    @Test
    void createMargheritaPizza() {
        Pizza pizza = factory.createPizza("MARGHERITA");

        assertTrue(pizza instanceof MargheritaPizza);
        String expected = "Margherita pizza with tomato, mozzarella and basil";
        assertEquals(expected, pizza.getDescription());
        assertEquals(5.0, pizza.getCost());
    }

    @DisplayName("Test Veggie pizza")
    @Test
    void createVeggiePizza() {
        Pizza pizza = factory.createPizza("VEGGIE");

        assertTrue(pizza instanceof VeggiePizza);
        String expected = "Vegetarian pizza with tomato, mozzarella, olives, parmesan and grilled eggplant";
        assertEquals(expected, pizza.getDescription());
        assertEquals(6.0, pizza.getCost());
    }

    @DisplayName("Factory throws exception for invalid pizza type")
    @Test
    void createInvalidPizza() {
        assertThrows(IllegalArgumentException.class, () -> {
            factory.createPizza("CHICKEN");
        });
    }
}