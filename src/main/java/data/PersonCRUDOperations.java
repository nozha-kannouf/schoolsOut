package data;

import model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PersonCRUDOperations implements CRUDOperations<Person> {
    @Override
    public void create(Person person) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Person retrieve(Person person) {
        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public void delete(Person person) {

    }
}
