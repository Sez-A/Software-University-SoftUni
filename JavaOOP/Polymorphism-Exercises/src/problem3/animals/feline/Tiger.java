package problem3.animals.feline;

public class Tiger extends Felime{
    private String livingRegion;
    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }
}
