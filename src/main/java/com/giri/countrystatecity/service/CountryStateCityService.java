package com.giri.countrystatecity.service;

import com.giri.countrystatecity.domain.Country;
import com.giri.countrystatecity.domain.State;
import com.giri.countrystatecity.domain.StatePopulation;

import java.util.List;

/**
 * Defines interface for CountryStateCityS ervice
 *
 * @author Giri Pottepalem
 * created Mar 16, 2024
 */
public interface CountryStateCityService {
    Country getCountryByName(String name);

    Country getCountryByNameSingleQuery(String name);

    Country getCountryByNameEntityGraph(String name);

    List<Country> getAllCountries();
    List<Country> getAllCountriesSingleQuery();

    List<State> getAllByPopulationGreaterThan(Long population);
    List<StatePopulation> getAllByPopulationGreaterThanJpql(Long population);
    List<StatePopulation> getAllByPopulationGreaterThanJpqlRaw(Long population);
}
