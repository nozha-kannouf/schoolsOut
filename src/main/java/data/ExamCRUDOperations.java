package data;

import model.Exam;
import model.Module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class ExamCRUDOperations implements CRUDOperations<Exam> {
    @Override
    public Optional<Exam> create(Exam exam) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(exam);
        em.getTransaction().commit();
        em.close();
        return retrieve(exam.getId());
    }

    @Override
    public Optional<Exam> retrieve(Object identity) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Exam foundExam = em.find(Exam.class, identity);
        return Optional.ofNullable(foundExam);
    }

    @Override
    public Exam update(Exam exam) {
        return null;
    }

    @Override
    public void delete(Exam exam) {

    }
}
