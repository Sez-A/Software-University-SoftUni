import entity.Customer;
import entity.Product;
import entity.Sale;
import entity.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        EntityManager entityManager = Persistence
                .createEntityManagerFactory("softuni")
                .createEntityManager();

        entityManager.getTransaction().begin();
        // TODO If you want to persist some data in DB you can uncomment code below!

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


        entityManager.getTransaction().commit();
    }
}
