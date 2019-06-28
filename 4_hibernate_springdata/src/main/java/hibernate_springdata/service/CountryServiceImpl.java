package hibernate_springdata.service;

import hibernate_springdata.entity.Country;
import hibernate_springdata.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public CountryServiceImpl() {
    }

    @Override
    @Transactional(readOnly = true)
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Country get(int id) {
        return countryRepository.getOne(id);
    }

    @Override
    @Transactional
    public void save(Country country) {
        countryRepository.save(country);
    }
}
