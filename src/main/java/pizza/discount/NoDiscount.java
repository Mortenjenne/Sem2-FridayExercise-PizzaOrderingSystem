package pizza.discount;

public class NoDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double total) {
        return total * 0.0;
    }
}
