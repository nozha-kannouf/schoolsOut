package data;

import model.Course;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class CourseCRUDOperations implements CRUDOperations<Course> {
    @Override
    public void create(Course course) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Optional<Course> retrieve(Course course) {
        return null;
    }

    @Override
    public Course update(Course course) {
        return null;
    }

    @Override
    public void delete(Course course) {

    }
}
