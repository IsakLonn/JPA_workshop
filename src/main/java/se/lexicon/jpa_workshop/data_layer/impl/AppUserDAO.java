package se.lexicon.jpa_workshop.data_layer.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.jpa_workshop.data_layer.Interface.IDAOBase;
import se.lexicon.jpa_workshop.entity.AppUser;
import se.lexicon.jpa_workshop.entity.Details;

import java.util.Collection;

@Repository
public class AppUserDAO implements IDAOBase<Integer, AppUser> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AppUser findById(Integer id) {
        return entityManager.find(AppUser.class, id);
    }

    @Override
    public Collection<AppUser> findAll() {
        TypedQuery<AppUser> query = entityManager.createQuery("SELECT a FROM AppUser a", AppUser.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void create(AppUser create) {
        entityManager.persist(create);
    }

    @Override
    @Transactional
    public AppUser update(AppUser update) {
        return entityManager.merge(update);
    }

    @Override
    @Transactional
    public void delete(AppUser delete) {
        entityManager.remove(delete);
    }
}
