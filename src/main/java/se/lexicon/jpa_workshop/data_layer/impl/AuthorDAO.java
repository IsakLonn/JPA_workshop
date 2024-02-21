package se.lexicon.jpa_workshop.data_layer.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.jpa_workshop.data_layer.Interface.IDAOBase;
import se.lexicon.jpa_workshop.entity.Author;

import java.util.Collection;

@Repository
public class AuthorDAO implements IDAOBase<Integer, Author> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Author findById(Integer id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public Collection<Author> findAll() {
        return entityManager.createQuery("select a from Author a", Author.class).getResultList();
    }

    @Transactional
    @Override
    public Author create(Author create) {
        entityManager.persist(create);
        return create;
    }
    @Transactional
    @Override
    public Author update(Author update) {return entityManager.merge(update);}
    @Transactional
    @Override
    public void delete(Author delete) { entityManager.remove(delete);}
}
