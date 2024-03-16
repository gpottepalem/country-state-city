package com.giri.countrystatecity.service;

import com.giri.countrystatecity.domain.Country;

import java.util.List;

/**
 *
 * @author Giri Pottepalem
 * created Mar 16, 2024
 */
public interface CountryStateCityService {
    Country getCountryByName(String name);
    Country getCountryByNameSingleQuery(String name);

    List<Country> getAllCountries();
    List<Country> getAllCountriesSingleQuery();
}
