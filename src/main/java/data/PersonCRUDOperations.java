package data;

import model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class PersonCRUDOperations implements CRUDOperations<Person> {
    @Override
    public Optional<Person> create(Person person) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
        return retrieve(person.getId());
    }

    @Override
    public Optional<Person> retrieve(Object identity) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Person foundPerson = em.find(Person.class, identity);
        return Optional.ofNullable(foundPerson);

    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public void delete(Person person) {

    }
}
