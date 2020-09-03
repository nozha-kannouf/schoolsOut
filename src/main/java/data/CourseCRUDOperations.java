package data;

import model.Course;
import model.Exam;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class CourseCRUDOperations implements CRUDOperations<Course> {
    @Override
    public Optional<Course> create(Course course) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        em.close();
        return retrieve(course.getId());
    }

    @Override
    public Optional<Course> retrieve(Object identity) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Course foundCourse = em.find(Course.class, identity);
        return Optional.ofNullable(foundCourse);
    }

    @Override
    public Course update(Course course) {
        return null;
    }

    @Override
    public void delete(Course course) {

    }
}
