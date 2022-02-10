package problem4;

public class Topping {
    private String toppingType;
    private double weight;
    private double modifier;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public void setModifier(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
                this.toppingType = toppingType;
                this.setModifier(1.2);
                break;
            case "Veggies":
                this.toppingType = toppingType;
                this.setModifier(0.8);
                break;
            case "Cheese":
                this.toppingType = toppingType;
                this.setModifier(1.1);
                break;
            case "Sauce":
                this.toppingType = toppingType;
                this.setModifier(0.9);
                break;
            default:
                throw new IllegalArgumentException(
                        String.format("Cannot place %s on top of your pizza."
                                , toppingType));
        }
    }

    public String getToppingType() {
        return toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(
                    String.format("%s weight should be in the range [1..50].", this.getToppingType()));
        }
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double calculateCalories() {
        return (this.getWeight() * 2) * this.getModifier();
    }
}
