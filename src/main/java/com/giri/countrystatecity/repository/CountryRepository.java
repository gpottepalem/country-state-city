package com.giri.countrystatecity.repository;

import com.giri.countrystatecity.domain.Country;
import org.springframework.data.jpa.repository.EntityGraph;
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
//    Optional<Country> findByName(String name);

    /**
     * JPQL - Java Persistence Query language
     * Queries for Country by name and returns related one-to-many relationships data by generating single query with
     * sql INNER joins (JOIN). Also, initializes relationship objects with data (FETCH).
     *
     * NOTE: LEFT JOIN FETCH can be used if LEFT JOIN is needed. Also, make sure to use DISTINCT
     * @param name
     * @return
     */
    @Query("""
        SELECT DISTINCT country from Country country
            JOIN FETCH country.states state
            JOIN FETCH state.cities city
        WHERE country.name = :name
    """)
    Optional<Country> findByNameSingleQueryJoinFetch(@Param("name") String name);

    /**
     * JPA EntityGraph
     * Finds country by fetching related object graphs by generating single query with sql LEFT joins (JOIN).
     * Also, initializes related object graphs with data of all related paths specified through attributePaths.
     * Multiple levels of related object graphs can be specified by using nested properties property.nestedProperty.
     * First level relationship, property: country has many states, property name (states).
     *   {@link Country#states}
     * Nested relationship, property: state has many cities, property name (states.cities
     *   {@link com.giri.countrystatecity.domain.State#cities}
     *
     * @param name the name of the country to find
     * @return the {@link Country} found with the complete object graph of relationships
     */
    @EntityGraph(attributePaths = {"states", "states.cities"})
    Optional<Country> findByName(String name);

    List<Country> findAll();

    /**
     * JPQL - Java Persistence Query language
     * Queries for all countries and returns related one-to-many relationships data by generating single query with
     * sql INNER joins (JOIN). Also, initializes relationship objects with data (FETCH).
     *
     * NOTE: LEFT JOIN FETCH can be used if LEFT JOIN is needed.
     *       Also, make sure to use DISTINCT, otherwise cartesian product
     * @return all countries with related objects
     */
    @Query("""
        SELECT DISTINCT country from Country country
            JOIN FETCH country.states state
            JOIN FETCH state.cities city
    """)
    List<Country> findAllSingleQueryJoinFetch();
}
