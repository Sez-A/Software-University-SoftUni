import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {

    private static final String PRODUCT_LABEL = "test_label";

    private ProductStock stock;
    private Product testProduct;
    private Product[] products;

    @Before
    public void init() {
        stock = new Instock();
        testProduct = new Product(PRODUCT_LABEL, 10, 1);
    }

    @Test
    public void testAddShouldAddProduct() {
        stock.add(testProduct);
        assertTrue(stock.contains(testProduct));
    }

    @Test
    public void testContains() {
        assertFalse(stock.contains(testProduct));
        stock.add(testProduct);
        assertTrue(stock.contains(testProduct));
    }

    @Test
    public void testCountShouldReturnOneForSingleProduct() {
        stock.add(testProduct);
        assertEquals(1, stock.getCount());
    }

    @Test
    public void testCountShouldReturnTenForTenProducts() {
        int expectedProductCount = 10;
        addProductsToStock(expectedProductCount);
        assertEquals(expectedProductCount, stock.getCount());
    }

    @Test
    public void testCountShouldReturnZeroWhenStockIsEmpty() {
        assertEquals(0, stock.getCount());
    }

    @Test
    public void testFindProductByIndexShouldReturnCorrectProductWhenOnlyOne() {
        stock.add(testProduct);
        assertProductsAreEqual(testProduct, stock.find(0));
    }


    @Test
    public void testFindProductByIndexShouldReturnCorrectProductWhenTenAdded() {
        addProductsToStock(10);
        assertProductsAreEqual(products[products.length - 1], stock.find(products.length - 1));
    }

    @Test
    public void testFindProductByIndexShouldReturnCorrectProductWhenTenAddedAndWeTakeProductInMiddle() {
        addProductsToStock(10);
        assertProductsAreEqual(products[(products.length - 1) / 2], stock.find((products.length - 1) / 2));
    }

    @Test
    public void testFindProductByIndexShouldReturnCorrectProductWhenAllIndexesAreFetched() {
        addProductsToStock(10);
        for (int i = 0; i < 10; i++) {
            assertProductsAreEqual(products[i], stock.find(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindProductByIndexWhenEmpty() {
        stock.find(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindProductByIndexWhenIndexIsHigherThanSize() {
        stock.find(stock.getCount());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindProductByIndexWhenIndexIsNegative() {
        stock.find(-1);
    }

    @Test
    public void testChangeQuantityShouldSetNewQuantityIfProductExistInStock() {
        int newQuantity = testProduct.getQuantity() + 10;
        stock.add(testProduct);
        stock.changeQuantity(testProduct.getLabel(), newQuantity);
        assertEquals(newQuantity, testProduct.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldThrowWhenProductNotExist() {
        stock.changeQuantity("Not exist", 10);
    }

    @Test
    public void testFindByLabelShouldReturnProductIfProductExistInStock() {
        stock.add(testProduct);
        Product expected = new Product(PRODUCT_LABEL, 10, 1);
        Product actual = stock.findByLabel(testProduct.getLabel());

        assertProductsAreEqual(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldThrowWithFakeLabel() {
        stock.findByLabel("Not exist");
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnProducts() {

        addProductsToStock(5);
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(3);
        assertNotNull(iterable);

        List<Product> actual = listFromIterable(iterable);

        actual = actual.
                stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(3)
                .collect(Collectors.toList());

        List<Product> expected = Arrays.stream(this.products).sorted(Comparator.comparing(Product::getLabel))
                .limit(3)
                .collect(Collectors.toList());

        assertEquals(expected.size(), actual.size());

       assertListsOfProductsAreEqual(expected,actual);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyListWhenCountIsGreaterThanProductsStored() {
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(3);

        assertNotNull(iterable);
        List<Product> actual = listFromIterable(iterable);
        assertTrue(actual.isEmpty());

    }

    @Test
    public void testFindAllInRangeShouldReturnProductsInRange() {
        addProductsToStock(10);
        int lowBound = 10;
        int upBound = 12;

        List<Product> expected = Arrays.stream(this.products)
                .filter(p -> p.getPrice() > lowBound && p.getPrice() <= upBound)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        Iterable<Product> iter = stock.findAllInRange(lowBound, upBound);

        assertNotNull(iter);
        List<Product> actual = listFromIterable(iter);

        assertListsOfProductsAreEqual(expected, actual);
    }

    @Test
    public void testFindAllInRangeShouldReturnEmptyListWhenNoProductsInRange() {
        addProductsToStock(10);
        Iterable<Product> iterable = stock.findAllInRange(100, 1000);
        assertNotNull(iterable);
        List<Product> actual = listFromIterable(iterable);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testFindAllByPriceShouldReturnAllProductsWithSamePrice() {
        addProductsToStock(10);
        for (int i = 0; i < 5; i++) {
            products[i].setPrice(5);
        }

        List<Product> expected = Arrays.stream(products)
                .filter(p -> p.getPrice() == 5)
                .collect(Collectors.toList());
        Iterable<Product> iterable = stock.findAllByPrice(5);
        assertNotNull(iterable);
        List<Product> actual = listFromIterable(iterable);
        assertListsOfProductsAreEqual(expected, actual);
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyListWhenNoneMatch() {
        addProductsToStock(10);
        Iterable<Product> iterable = stock.findAllByPrice(5);
        assertNotNull(iterable);
        List<Product> actual = listFromIterable(iterable);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnProductsWithHighestPrice() {
        int n = 4;
        addProductsToStock(10);
        List<Product> expected = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(n)
                .collect(Collectors.toList());

        Iterable<Product> iterable = stock.findFirstMostExpensiveProducts(n);

        assertNotNull(iterable);

        List<Product> actual = listFromIterable(iterable);

        assertListsOfProductsAreEqual(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldThrowWithCountLargerThanProductsStored() {
        addProductsToStock(2);
        stock.findFirstMostExpensiveProducts(5);
    }

    @Test
    public void testFindAllByQuantityShouldReturnAllProductsWithSameQuantity() {
        addProductsToStock(10);
        for (int i = 0; i < 5; i++) {
            products[i].setQuantity(500);
        }

        List<Product> expected = Arrays.stream(products)
                .filter(p -> p.getQuantity() == 500)
                .collect(Collectors.toList());

        Iterable<Product> iterable = stock.findAllByQuantity(500);
        List<Product> actual = listFromIterable(iterable);

        assertListsOfProductsAreEqual(expected, actual);
    }

    @Test
    public void testFindAllByQuantityShouldReturnEmptyListWhenNoneMatchesForQuantityParam() {
        addProductsToStock(10);
        Iterable<Product> iterable = stock.findAllByQuantity(1000);
        List<Product> actual = listFromIterable(iterable);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testIteratorShouldReturnAllProductsInStock() {
        addProductsToStock(10);
        Iterator<Product> iterator = stock.iterator();
        assertNotNull(iterator);
        int index = 0;
        while (iterator.hasNext()) {
            assertProductsAreEqual(this.products[index], iterator.next());
            index++;
        }
    }

    @Test
    public void testIteratorShouldReturnEmptyIterator() {
        Iterator<Product> iterator = stock.iterator();
        assertFalse(iterator.hasNext());
    }

    private void assertListsOfProductsAreEqual(List<Product> expected, List<Product> actual) {
        for (int i = 0; i < expected.size(); i++) {
            assertProductsAreEqual(expected.get(i), actual.get(i));
        }
    }

    private <T> List<T> listFromIterable(Iterable<T> iterable) {
        List<T> products = new ArrayList<>();
        for (T product : iterable) {
            products.add(product);
        }
        return products;
    }

    private void addProductsToStock(int count) {
        products = new Product[count];
        for (int i = 0; i < count; i++) {
            products[i] = new Product(i + "", i + 10, i);
            stock.add(products[i]);
        }
    }

    private void assertProductsAreEqual(Product expected, Product actual) {
        assertEquals(expected.getLabel(), actual.getLabel());
        assertEquals(expected.getPrice(), actual.getPrice(), 0.00);
        assertEquals(expected.getQuantity(), actual.getQuantity());
    }


}