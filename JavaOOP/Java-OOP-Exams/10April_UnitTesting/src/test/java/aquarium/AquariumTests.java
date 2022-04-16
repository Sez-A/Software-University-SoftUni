package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
    private Aquarium aquarium;

    @Before
    public void setUp() {
        this.aquarium = new Aquarium("Test", 10);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowWithNegativeValue() {
        Aquarium aquarium = new Aquarium("Negative", -1);
    }

    @Test
    public void testSetCapacityShouldWorkProperly() {
        Assert.assertEquals(10, aquarium.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWithNullValue() {
        Aquarium aquarium = new Aquarium(null, 15);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWithEmptyValue() {
        Aquarium aquarium = new Aquarium("               ", 5);
    }

    @Test
    public void testSetNameShouldWorkProperly() {
        Assert.assertEquals("Test", aquarium.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowWithFullCapacity() {
        Aquarium aquarium = new Aquarium("Only one fish aquarium", 1);
        aquarium.add(new Fish("test"));
        aquarium.add(new Fish("test 2"));
    }

    @Test
    public void testAddShouldWorkProperly() {
        aquarium.add(new Fish("test"));
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowWithNonExistingFish() {
        aquarium.remove("non exist");
    }

    @Test
    public void testRemoveShouldWorkProperly() {
        aquarium.add(new Fish("test"));
        Assert.assertEquals(1, aquarium.getCount());
        aquarium.remove("test");
        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishShouldThrowWithNonExistingFish() {
        aquarium.remove("non exist");
    }

    @Test
    public void testSellFishShouldWorkProperly() {
        Fish fish = new Fish("test");
        aquarium.add(fish);

        Fish expected = new Fish("test");
        expected.setAvailable(false);
        Fish actual = aquarium.sellFish("test");

        assertEqualsFish(expected, actual);

    }

    @Test
    public void testReportShouldWorkProperly() {
        aquarium.add(new Fish("first"));
        aquarium.add(new Fish("second"));
        aquarium.add(new Fish("third"));

        String expected = "Fish available at Test: first, second, third";
        String actual = aquarium.report();
        Assert.assertEquals(expected, actual);
    }

    private void assertEqualsFish(Fish expected, Fish actual) {
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertFalse(actual.isAvailable());
    }
}

