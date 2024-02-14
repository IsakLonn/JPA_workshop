package se.lexicon.jpa_workshop.data_layer.Interface;

import java.util.Collection;

public interface IDAOBase <ID, TYPE>{

    TYPE findById(ID id);

    Collection<TYPE> findAll();

    void create(TYPE create);

    TYPE update(TYPE update);

    void delete(TYPE delete);
}
