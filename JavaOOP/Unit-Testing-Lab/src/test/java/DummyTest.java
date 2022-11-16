import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    @Test
    public void testDummyLosesHealthIfAttacked() {
        Dummy dummy = new Dummy(100, 100);
        dummy.takeAttack(10);

        int expectedHealth = 90;
        int actualHealth = dummy.getHealth();
        Assert.assertEquals(expectedHealth, actualHealth);
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrows() {
        new Dummy(0, 100).takeAttack(0);
    }

    @Test
    public void testDeadDummyCanGiveExperience() {
        Dummy dummy = new Dummy(0, 100);
        int expectedExperience = 100;
        int actualExperience = dummy.giveExperience();
        Assert.assertEquals(expectedExperience, actualExperience);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyCannotGiveExperience() {
        new Dummy(1,100).giveExperience();
    }
}