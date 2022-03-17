package viceCity.models.guns;

public class Pistol extends BaseGun {
    public Pistol(String name) {
        super(name, 10, 100);
    }

    @Override
    public int fire() {
        if (this.getBulletsPerBarrel() >= 1) {
            this.setBulletsPerBarrel(this.getBulletsPerBarrel() - 1);
        } else {
            this.setBulletsPerBarrel(10);
            this.setTotalBullets(this.getTotalBullets() - 10);
        }
        return 1;
    }
}
