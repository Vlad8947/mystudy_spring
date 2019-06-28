package hibernate_springdata.dao;

import hibernate_springdata.entity.Country;

import java.util.List;

public interface CountryDAO {

    // Получить все сущности Article из БД
    List<Country> findAll();

    // Сохранить сущности в БД
    void save(Country country);

    // Получить сущность из БД по id
    Country findById(long id);

    // Обновить сущность в БД
    void update(Country country);

    // Удалить сущность из БД
    void delete(Country country);

}
