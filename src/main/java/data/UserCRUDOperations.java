package data;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class UserCRUDOperations implements CRUDOperations<User> {

    @Override
    public Optional<User> create(User user) {
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
    public Optional<User> update(User user) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        User userToUpdate = em.find(User.class, user.getLogin());
        if(userToUpdate!= null){
            userToUpdate.setActive(user.isActive());
            userToUpdate.setPasswordHash(user.getPasswordHash());
            em.getTransaction().begin();
            em.merge(userToUpdate);
            em.getTransaction().commit();
            em.close();
            System.out.println("User updated with success");
        }else System.out.println("user not updated");

        return Optional.ofNullable(userToUpdate);
    }

    @Override
    public boolean delete(User user) {

        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Optional<User> userExists = retrieve(user.getLogin());
        if(userExists.isPresent()){
            em.remove(em.contains(userExists.get()) ? userExists.get() : em.merge(userExists.get()));
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
