package data;

import model.Course;
import model.Exam;
import model.Grade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

public class ExamRepository implements CRUDOperations<Exam> {
    public List<Exam> getSubExams(Long id){
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT e from Exam e WHERE e.examGroup.id=?1",Exam.class)
                 .setParameter(1, id)
                 .getResultList();
    }
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
    public Optional<Exam> retrieveExamWithGrade(Object identity) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Exam foundExam = em.find(Exam.class, identity);
        return Optional.ofNullable(foundExam);
    }

    @Override
    public Optional<Exam> update(Exam exam) {

        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Exam examToUpdate = em.find(Exam.class, exam.getId());
        if(examToUpdate!= null){
            examToUpdate.setDescription(exam.getDescription());
            examToUpdate.setName(exam.getName());
            examToUpdate.setDate(exam.getDate());
            examToUpdate.setModule(exam.getModule());
            examToUpdate.setTotal(exam.getTotal());
            examToUpdate.setWeight(exam.getWeight());
            em.getTransaction().begin();

            em.merge(examToUpdate);
            em.getTransaction().commit();
            em.close();
            System.out.println("Exam updated with success");
        }else System.out.println("Exam not updated");

        return Optional.ofNullable(examToUpdate);
    }

    @Override
    public boolean delete(Exam exam) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        if(em.find(Exam.class, exam.getId())!= null){
            em.createQuery("UPDATE Grade g SET g.exam = ?1 WHERE g.exam.id = ?2")
                    .setParameter(1, null)
                    .setParameter(2, exam.getId())
                    .executeUpdate();
            em.createQuery("UPDATE Exam e SET e.examGroup.id = ?1 WHERE e.id = ?2")
                    .setParameter(1, null)
                    .setParameter(2, exam.getId())
                    .executeUpdate();

            em.remove(em.find(Exam.class, exam.getId()));

            em.getTransaction().commit();
            em.close();
            System.out.println("exam deleted with success");
            return true;
        }
            else{
            System.out.println("This exam don't exist in the DB");
            return false;
        }
    }
    private Optional<Exam> retrieve(Object identity, EntityManager em) {
        Exam foundExam = em.find(Exam.class, identity);
        return Optional.ofNullable(foundExam);
    }
}
