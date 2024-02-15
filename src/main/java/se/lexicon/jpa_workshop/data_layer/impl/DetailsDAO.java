package se.lexicon.jpa_workshop.data_layer.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.jpa_workshop.data_layer.Interface.IDAOBase;
import se.lexicon.jpa_workshop.entity.Details;

import java.util.Collection;

@Repository
public class DetailsDAO implements IDAOBase<Integer, Details> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Details findById(Integer id) {
        return entityManager.find(Details.class, id);
    }

    @Override
    public Collection<Details> findAll() {
        TypedQuery<Details> query = entityManager.createQuery("SELECT d FROM Details d", Details.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Details create(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Override
    @Transactional
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Override
    @Transactional
    public void delete(Details details) {
        entityManager.remove(details);

    }
}
