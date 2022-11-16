import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_XP = 100;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void init() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void testWeaponLosesDurabilityAfterEachAttack() {
        axe.attack(dummy);
        int actualPoints = axe.getDurabilityPoints();
        Assert.assertEquals(EXPECTED_DURABILITY, actualPoints);
    }

    @Test(expected = IllegalStateException.class)
    public void testWithBrokenWeapon() {
        for (int i = 0; i < 10; i++) {
            axe.attack(dummy);
        }
        axe.attack(new Dummy(100, 100));
    }
}
