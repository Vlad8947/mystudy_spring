package hibernate_springdata.service;

import hibernate_springdata.entity.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAll();

    Country get(int id);

    void save(Country country);
}
