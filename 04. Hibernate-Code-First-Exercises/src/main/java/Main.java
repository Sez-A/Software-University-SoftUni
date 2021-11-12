import entity.Product;
import entity.problem5.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence
                .createEntityManagerFactory ("softuni")
                .createEntityManager();

        entityManager.getTransaction().begin();
//        Product macbook = new Product();
//        macbook.setName("Macbook Pro 13.3");
//        macbook.setPrice(BigDecimal.valueOf(1599.99));
//        macbook.setQuantity(15);
//        Product iphone = new Product();
//        iphone.setName("Iphone 13");
//        iphone.setPrice(BigDecimal.valueOf(1299.99));
//        iphone.setQuantity(30);
//        entityManager.persist(macbook);
//        entityManager.persist(iphone);
//        Customer Seza = new Customer();
//        Seza.setName("Seza");
//        Seza.setEmail("seza@gmail.com");
//        Seza.setCreditCardNumber("4478901649104");
//        entityManager.persist(Seza);
//        StoreLocation location = new StoreLocation();
//        location.setLocationName("Shumen Bul.Pliska 44");
//        entityManager.persist(location);

//        Product product = entityManager.find(Product.class, 1L);
//        Set<Sale> sales = product.getSales();
//        for (Sale sale : sales) {
//            System.out.println(sale.getDateTime());
//        }

        User user = new User();
        entityManager.getTransaction().commit();
    }
}
