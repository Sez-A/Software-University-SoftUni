public class PriceCalculator {

    public double calculate(double pricePerDay, int daysCount, String season, String discountType) {
        double finalPrice = pricePerDay * daysCount;
        Seasons currSeason = Seasons.valueOf(season.toUpperCase());
        finalPrice *= currSeason.getValue();
        DiscountType discount = DiscountType.valueOf(discountType.toUpperCase());
        finalPrice *= discount.getPercent();
        return finalPrice;
    }
}
