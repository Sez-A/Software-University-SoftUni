package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    private ComputerManager computerManager;
    private Computer macbook;

    @Before
    public void setUp() {
        computerManager = new ComputerManager();
        this.macbook = new Computer("Apple", "Macbook", 2500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldThrowWithNullValue() {
        this.computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldThrowWithAlreadyExistComputer() {

        this.computerManager.addComputer(this.macbook);
        this.computerManager.addComputer(this.macbook);
    }

    @Test
    public void testAddComputerShouldWorkProperly() {
        this.computerManager.addComputer(this.macbook);
        Assert.assertEquals(1, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowWithNullValueForManufacturer() {
        this.computerManager.getComputer(null, "Macbook");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowWithNullValueForModel() {
        this.computerManager.getComputer("Apple", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerShouldThrowWithNonExistComputer() {
        this.computerManager.getComputer("Lenovo", "Thinkpad");
    }

    @Test
    public void testGetComputerShouldWorkProperly() {
        this.computerManager.addComputer(this.macbook);
        Computer actual = this.computerManager.getComputer("Apple", "Macbook");
        Assert.assertEquals(this.macbook.getManufacturer(), actual.getManufacturer());
        Assert.assertEquals(this.macbook.getModel(), actual.getModel());
    }

    @Test
    public void testRemoveComputerShouldWorkProperly() {
        this.computerManager.addComputer(this.macbook);
        Assert.assertEquals(1, this.computerManager.getCount());
        this.computerManager.removeComputer("Apple", "Macbook");
        Assert.assertEquals(0, this.computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersByManufacturerShouldThrowWithNullValue() {
        this.computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void testGetComputersByManufacturerShouldWorkProperly() {
        Computer macbookAir = new Computer("Apple", "Macbook Air", 2000);
        Computer lenovo = new Computer("Lenovo", "Ideapad", 700);
        this.computerManager.addComputer(this.macbook);
        this.computerManager.addComputer(macbookAir);
        this.computerManager.addComputer(lenovo);
        List<Computer> appleComputers =
                this.computerManager.getComputersByManufacturer("Apple");
        Assert.assertEquals(2, appleComputers.size());
    }
}