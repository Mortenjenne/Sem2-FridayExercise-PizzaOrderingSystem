package pizza.discount;

public class TenPercentDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double total) {
        return total * 0.90;
    }
}
