package data;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class UserCRUDOperations implements CRUDOperations<User> {

    @Override
    public Optional<User> create(User user) {
        //TODO
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        return retrieve(user.getLogin());
    }

    @Override
    public Optional<User> retrieve(Object identity) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        User foundUser = em.find(User.class, identity);
        em.close();
        return Optional.ofNullable(foundUser);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(User user) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        boolean userExists = retrieve(user.getLogin()).isPresent();
        if(userExists){
            em.remove(em.contains(user) ? user : em.merge(user));
            em.getTransaction().commit();
            em.close();
            System.out.println("User deleted with success");
            return true;
        }
        else{
            System.out.println("This User don't exist in the DB");
            return false;
        }

    }
}
