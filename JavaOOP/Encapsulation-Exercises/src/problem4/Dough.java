package problem4;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;
    private double bakingTechniqueModifier;
    private double flourTypeModifier;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    private void setFlourType(String flourType) {
        switch (flourType) {
            case "White":
                this.flourType = flourType;
                this.setFlourTypeModifier(1.5);
                break;
            case "Wholegrain":
                this.flourType = flourType;
                this.setFlourTypeModifier(1.0);
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public String getFlourType() {
        return flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                this.bakingTechnique = bakingTechnique;
                this.setBakingTechniqueModifier(0.9);
                break;
            case "Chewy":
                this.bakingTechnique = bakingTechnique;
                this.setBakingTechniqueModifier(1.1);
                break;
            case "Homemade":
                this.bakingTechnique = bakingTechnique;
                this.setBakingTechniqueModifier(1.0);
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public String getBakingTechnique() {
        return bakingTechnique;
    }

    public void setBakingTechniqueModifier(double bakingTechniqueModifier) {
        this.bakingTechniqueModifier = bakingTechniqueModifier;
    }


    public void setFlourTypeModifier(double flourTypeModifier) {
        this.flourTypeModifier = flourTypeModifier;
    }



    public double calculateCalories() {
        return (this.getWeight() * 2) * bakingTechniqueModifier * flourTypeModifier;
    }
}
