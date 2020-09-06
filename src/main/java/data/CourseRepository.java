package data;

import model.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class CourseRepository implements CRUDOperations<Course> {
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
    public Optional<Course> update(Course course) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Course courseToUpdate = em.find(Course.class, course.getId());
        if(courseToUpdate!= null){
            courseToUpdate.setName(course.getName());
            courseToUpdate.setCode(course.getCode());
            courseToUpdate.setActive(course.isActive());
            courseToUpdate.setDescription(course.getDescription());
            courseToUpdate.setImageURL(course.getImageURL());

            em.getTransaction().begin();
            em.merge(courseToUpdate);
            em.getTransaction().commit();
            em.close();
            System.out.println("Course updated with success");
        }else System.out.println("Course not updated");

        return Optional.ofNullable(courseToUpdate);
    }

    @Override
    public boolean delete(Course course) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if(em.find(Course.class, course.getId())!= null){
            em.createQuery("UPDATE Person p SET p.course = ?1 WHERE p.course = ?2")
               .setParameter(1, null)
               .setParameter(2, course)
               .executeUpdate();
            em.remove(em.find(Course.class, course.getId()));
            em.getTransaction().commit();
            em.close();
            System.out.println("course deleted with success");
            return true;
        }
        else{
            System.out.println("This course don't exist in the DB");
            return false;
        }
    }
}
