package se.lexicon.jpa_workshop.data_layer.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.jpa_workshop.data_layer.Interface.IDAOBase;
import se.lexicon.jpa_workshop.entity.AppUser;
import se.lexicon.jpa_workshop.entity.Book;
import se.lexicon.jpa_workshop.entity.BookLoan;

import java.util.Collection;

@Repository
public class BookDAO implements IDAOBase<Integer, Book> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Book findById(Integer id) {
        return entityManager.find(Book.class, id);

    }

    @Override
    public Collection<Book> findAll() {
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }

    @Transactional
    @Override
    public Book create(Book create) {
        entityManager.persist(create);
        return create;
    }

    @Override
    public Book update(Book update) {
        return entityManager.merge(update);
    }

    @Override
    public void delete(Book delete) {
        entityManager.remove(delete);
    }
}
