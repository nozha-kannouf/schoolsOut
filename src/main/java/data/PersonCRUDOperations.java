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
    public Optional<Person> update(Person person) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Person personToUpdate = em.find(Person.class, person.getId());
        if(personToUpdate!= null){
            personToUpdate.setFirstName(person.getFirstName());
            personToUpdate.setFamilyName(person.getFamilyName());
            personToUpdate.setGender(person.getGender());
            personToUpdate.setCourse(person.getCourse());

            em.getTransaction().begin();
            em.merge( person.getCourse() );
            em.merge(personToUpdate);
            em.getTransaction().commit();
            em.close();
            System.out.println("User updated with success");
        }else System.out.println("user not updated");

        return Optional.ofNullable(personToUpdate);
    }

    @Override
    public boolean delete(Person person) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Optional<Person> personExists = retrieve(person.getId());
       if(personExists.isPresent()){
            em.remove(personExists.get());
            em.getTransaction().commit();
            em.close();
            System.out.println("person deleted with success");
            return true;
        }
        else{
            System.out.println("This person don't exist in the DB");
            return false;
        }
    }
}
