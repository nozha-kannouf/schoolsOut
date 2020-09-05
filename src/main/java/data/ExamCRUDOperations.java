package data;

import model.Exam;

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

        Optional<Exam> examExists = retrieve(exam.getId(),em);

        if(examExists.isPresent()){
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
