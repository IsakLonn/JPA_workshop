package se.lexicon.jpa_workshop.data_layer.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import se.lexicon.jpa_workshop.data_layer.Interface.IDAOBase;
import se.lexicon.jpa_workshop.entity.BookLoan;

import java.util.Collection;

@Repository
public class BookLoanDAO implements IDAOBase<Integer, BookLoan> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public BookLoan findById(Integer id) {
        return entityManager.find(BookLoan.class, id);
    }

    @Override
    public Collection<BookLoan> findAll() {
        return entityManager.createQuery("select b from BookLoan b", BookLoan.class).getResultList();
    }

    @Override
    public BookLoan create(BookLoan create) {
        entityManager.persist(create);
        return create;
    }

    @Override
    public BookLoan update(BookLoan update) {
        return entityManager.merge(update);
    }

    @Override
    public void delete(BookLoan delete) {
        entityManager.remove(delete);
    }
}
