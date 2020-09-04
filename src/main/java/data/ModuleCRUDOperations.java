package data;

import model.Module;
import model.Person;

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

    private Optional<Module> retrieve(Object identity, EntityManager em) {
        Module foundModule = em.find(Module.class, identity);
        return Optional.ofNullable(foundModule);
    }
    @Override
    public Module update(Module module) {
//        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        boolean moduleExists = retrieve(module.getId()).isPresent();
//        if(moduleExists){
//            em.remove(em.contains(module) ? module : em.merge(module));
//            em.getTransaction().commit();
//            em.close();
//            System.out.println("module updated with success");
//            return true;
//        }
//        else{
//            System.out.println("This module is notupdated");
//            return false;
//        }
        return null;
    }

    @Override
    public boolean delete(model.Module module) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Optional<model.Module> moduleExists = retrieve(module.getId(),em);

        if(moduleExists.isPresent()){

            em.remove(em.find(model.Module.class, module.getId()));

            em.getTransaction().commit();
            em.close();
            System.out.println("The module deleted with success");
            return true;
        }
        else{
            System.out.println("This module don't exist in the DB");
            return false;
        }
    }
}
