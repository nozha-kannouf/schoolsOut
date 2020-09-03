package data;

import model.Module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class ModuleCRUDOperations implements CRUDOperations<Module> {
    @Override
    public void create(model.Module module) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(module);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Optional<Module> retrieve(Module module) {
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
