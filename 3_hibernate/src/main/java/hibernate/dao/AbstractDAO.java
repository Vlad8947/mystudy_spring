package hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO {

    @PersistenceContext(name="persistenceUnit")
    protected EntityManager entityManager;
}
