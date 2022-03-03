package problem3.animals.feline;

import java.text.DecimalFormat;

public class Cat  extends Felime {
    private String breed;

    public Cat(String animalName, String animalType,
               Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        //Cat[Gray, Persian, 1.1, Home, 4]
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        String weight = decimalFormat.format(this.getAnimalWeight());
        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getAnimalType(),
                this.getAnimalName(),
                this.getBreed(),weight,
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
