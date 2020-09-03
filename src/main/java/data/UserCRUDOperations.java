package data;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class UserCRUDOperations implements CRUDOperations<User> {

    @Override
    public void create(User user) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Optional<User> retrieve(User user) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        User foundUser = em.find(User.class, user.getLogin());
        return Optional.of(foundUser);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {}
}
