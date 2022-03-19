package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    private Shop shop;

    @Before
    public void setUp() {
        this.shop = new Shop();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelvesShouldThrow() {
        shop.getShelves().clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowWithNonExistingShelf() throws OperationNotSupportedException {
        shop.addGoods("non_existing_shelf", new Goods("test_good", "test_code"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldThrowWithAlreadyTakenShelf() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", new Goods("test_good", "test_code"));
        shop.addGoods("Shelves1", new Goods("test_good", "test_code"));
    }

    @Test
    public void testAddGoodsShouldAddGoodAndReturnProperlyMessage() throws OperationNotSupportedException {
        String actual = shop.addGoods("Shelves1", new Goods("test_good", "test_code"));
        String expected = "Goods: test_code is placed successfully!";

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldThrowWithNonExistingShelf() {
        shop.removeGoods("non_existing_shelf", new Goods("test_good", "test_code"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeGoodsShouldThrowWithNonExistingGood() {
        shop.removeGoods("Shelves1", new Goods("non_existing", "test_code"));
    }

    @Test
    public void testRemoveGoodsShouldRemoveGoodAndReturnProperlyMessage() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        shop.addGoods("Shelves1", goods);
        String actual = shop.removeGoods("Shelves1", goods);
        String expected = "Goods: test_code is removed successfully!";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveGoodsShouldRemoveGoodAndSetValueToNull() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods);
        Goods actual = shop.getShelves().get("Shelves1");
        //Goods expected = null;
        Assert.assertNull(actual);
    }
}