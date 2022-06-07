import entities.Bike;
import entities.Car;
import entities.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManager em = Persistence
                .createEntityManagerFactory("softuni")
                .createEntityManager();

        em.getTransaction().begin();
//        Vehicle bike = new Bike();
//        Bike second = new Bike();
//        em.persist(bike);
//        em.persist(second);
        Car car = new Car();
        em.persist(car);
        em.getTransaction().commit();

    }
}
