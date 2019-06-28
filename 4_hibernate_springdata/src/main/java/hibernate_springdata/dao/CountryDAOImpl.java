package hibernate_springdata.dao;

import hibernate_springdata.entity.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CountryDAOImpl implements CountryDAO {

    @PersistenceContext
    private EntityManager em;

    public CountryDAOImpl() {
    }

    @Override
    public List<Country> findAll() {
        // Использует именованный запрос Country.findAll
        return em.createNamedQuery("Country.findAll", Country.class).getResultList();
    }

    @Override
    public void save(Country country) {
        em.persist(country);
    }

    @Override
    public Country findById(long id) {
        return em.find(Country.class,id);
    }

    @Override
    public void update(Country country) {
        em.merge(country);
    }

    @Override
    public void delete(Country country) {
        em.remove(country);
    }

}
