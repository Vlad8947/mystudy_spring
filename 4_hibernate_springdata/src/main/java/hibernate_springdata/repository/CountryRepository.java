package hibernate_springdata.repository;

import hibernate_springdata.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    // Добавляем свой метод, позволяющий искать страну по имени
    Country findByTitle(String title);

    @Query("select a from Country a where a.author = :author")
    List<Country> findArticleByCountry(@Param("country") Country country);

}
