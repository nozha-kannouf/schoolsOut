package data;

import model.Exam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ExamCRUDOperations implements CRUDOperations<Exam> {
    @Override
    public void create(Exam exam) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(exam);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Exam retrieve(Exam exam) {
        return null;
    }

    @Override
    public Exam update(Exam exam) {
        return null;
    }

    @Override
    public void delete(Exam exam) {

    }
}
