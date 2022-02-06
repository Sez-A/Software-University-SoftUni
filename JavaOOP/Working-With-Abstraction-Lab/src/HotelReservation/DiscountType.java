package HotelReservation;

public enum DiscountType {
    
    VIP(0.8),
    SECONDVISIT(0.9),
    NONE(1);

    private double percent;

    DiscountType(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }
}
