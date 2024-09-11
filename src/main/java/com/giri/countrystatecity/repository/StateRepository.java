package com.giri.countrystatecity.repository;


import com.giri.countrystatecity.domain.State;
import com.giri.countrystatecity.domain.StatePopulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for entity: {@link State}
 *
 * @author Giri Pottepalem
 * Created Sep 10, 2024
 */
@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    List<State> findAllByPopulationGreaterThan(Long population);

    /**
     * JPQL - Query to fetch specific fields of Entity and return a non-entity custom objects
     *
     * @param population the population
     * @return list of light-weight StatePopulation objects
     */
    @Query("""
        SELECT new com.giri.countrystatecity.domain.StatePopulation(state.name, state.population) from State state
            WHERE state.population > :population
    """)
    List<StatePopulation> findAllStatesByPopulationGreaterThan(Long population);

    /**
     * JPQL - Query to fetch specific fields of Entity and return Raw data
     *
     * @param population the population
     * @return list of light-weight StatePopulation objects
     */
    @Query("""
        SELECT state.name, state.population from State state
            WHERE state.population > :population
    """)
    List<List<Object>> findAllStatesByPopulationGreaterThanJpqlRaw(Long population);
}
