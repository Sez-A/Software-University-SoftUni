import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private List<Product> products;

    public Instock() {
        products = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.products.contains(product);
    }

    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        boolean flag = false;
        for (Product value : this.products) {
            if (value.getLabel().equals(product)) {
                value.setQuantity(quantity);
                flag = true;
            }
        }

        if (!flag) {
            throw new IllegalArgumentException("This product not exist in stock!");
        }
    }

    @Override
    public Product find(int index) {
        return this.products.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        for (Product product : this.products) {
            if (product.getLabel().equals(label)) {
                return product;
            }
        }
        throw new IllegalArgumentException("Product not exist in stock!");
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count < 0 || count >= this.products.size()) {
            return new ArrayList<>();
        }

        return this.products
                .stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product> result = new ArrayList<>();
        result = this.products
                .stream().filter(p -> p.getPrice() > lo && p.getPrice() <= hi)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        return result;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        List<Product> result = new ArrayList<>();

        result = this.products
                .stream()
                .filter(p -> p.getPrice() == price)
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count >= this.products.size()) {
            throw new IllegalArgumentException("The count " + count
                    + " is higher than current products count which is " + products.size());
        }

        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {

      return   this.products
                .stream()
                .filter(p -> p.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
       return this.products.iterator();
    }
}
