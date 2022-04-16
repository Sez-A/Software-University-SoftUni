package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private Spaceship spaceship;

    @Before
    public void setUp() {
        this.spaceship = new Spaceship("Test", 15);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWithNullValue() {
        new Spaceship(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWithEmptyValue() {
        new Spaceship(null, 100);
    }

    @Test
    public void testSetNameShouldWorkProperly() {

        Assert.assertEquals("Test", spaceship.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowWithNegativeValue() {
        new Spaceship("Negative", -1);
    }

    @Test
    public void testSetCapacityShouldWorkProperly() {
        Assert.assertEquals(15, spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWithFullSpaceship() {
        Spaceship spaceship = new Spaceship("Only one astrounat ship", 1);
        spaceship.add(new Astronaut("First", 50));
        spaceship.add(new Astronaut("Second", 30));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWithAlreadyExistAstrounat() {
        Astronaut first = new Astronaut("First", 50);
        spaceship.add(first);
        spaceship.add(first);
    }

    @Test
    public void testAddShouldWorkProperly() {
        Astronaut first = new Astronaut("First", 50);
        Astronaut second = new Astronaut("Second", 110);
        spaceship.add(first);
        spaceship.add(second);

        Assert.assertEquals(2, spaceship.getCount());
    }

    @Test()
    public void testRemoveShouldReturnFalseWithNonExistAstronaut() {
        boolean actual = spaceship.remove("Non exist");
        Assert.assertFalse(actual);
    }

    @Test
    public void testRemoveShouldWorkProperly() {
        Astronaut first = new Astronaut("First", 50);
        spaceship.add(first);
        Assert.assertEquals(1, spaceship.getCount());
        boolean actual = spaceship.remove("First");
        Assert.assertTrue(actual);

    }
}
