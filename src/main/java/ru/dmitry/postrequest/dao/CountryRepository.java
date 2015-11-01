package ru.dmitry.postrequest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dmitry.postrequest.entities.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
}
