package pizza.model;

public class QuattroFormaggi implements Pizza{

    @Override
    public String getName() {
        return "Quattro_Formaggi";
    }

    @Override
    public String getDescription() {
        return "Quattro formaggi pizza with fontina, robiola, straccino and gorgonzola";
    }

    @Override
    public double getCost() {
        return 12.00;
    }
}
