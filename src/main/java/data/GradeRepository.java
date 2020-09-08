package data;

import model.Grade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

public class GradeRepository implements  CRUDOperations<Grade>{

    public List<String> getGradeByExamId(Long id){
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
         return em.createQuery("SELECT 'Grade id: '|| g.id ||', grade value: ' || g.gradeValue from Grade g WHERE g.exam.id=?1")
                .setParameter(1, id)
                .getResultList();

    }

    @Override
    public Optional<Grade> create(Grade grade) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(grade);
        em.getTransaction().commit();
        em.close();
        return retrieve(grade.getId());
    }

    @Override
    public Optional<Grade> retrieve(Object identity) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Grade foundGrade = em.find(Grade.class, identity);
        return Optional.ofNullable(foundGrade);
    }

    @Override
    public Optional<Grade> update(Grade grade) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Grade grade) {
        return false;
    }
}
