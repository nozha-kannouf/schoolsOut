package data;

import model.Module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ModuleCRUDOperations implements CRUDOperations<Module> {
    @Override
    public void create(Module module) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(module);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Module retrieve(Module module) {
        return null;
    }

    @Override
    public Module update(Module module) {
        return null;
    }

    @Override
    public void delete(Module module) {

    }
}
