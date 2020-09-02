package data;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserCRUD implements CRUD<User>{

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
    public User retrieve(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {}
}
