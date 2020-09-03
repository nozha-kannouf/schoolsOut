package data;

import model.Module;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

public class ModuleCRUDOperations implements CRUDOperations<Module> {
    @Override
    public Optional<Module> create(Module module) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(module);
        em.getTransaction().commit();
        em.close();
        return retrieve(module.getId());
    }

    @Override
    public Optional<Module> retrieve(Object identity) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Module foundModule = em.find(Module.class, identity);
        return Optional.ofNullable(foundModule);
    }

    @Override
    public Module update(Module module) {
        return null;
    }

    @Override
    public void delete(Module module) {

    }
}
