package com.giri.countrystatecity.repository;

import com.giri.countrystatecity.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Giri Pottepalem
 * created Mar 16, 2024
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);

    @Query("""
        SELECT DISTINCT country from Country country
            JOIN FETCH country.states state
            JOIN FETCH state.cities city
        WHERE country.name = :name
    """)
    Optional<Country> findByNameSingleQueryJoinFetch(@Param("name") String name);

    List<Country> findAll();

    @Query("""
        SELECT DISTINCT country from Country country
            JOIN FETCH country.states state
            JOIN FETCH state.cities city
    """)
    List<Country> findAllSingleQueryJoinFetch();
}
