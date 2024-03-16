package com.giri.countrystatecity.controller;

import com.giri.countrystatecity.domain.Country;
import com.giri.countrystatecity.service.CountryStateCityService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * CountryStateCity Controller
 *
 * @author Giri Pottepalem
 * created Mar 16, 2024
 */
@Controller
@Slf4j
public class CountryStateCityController {
    private CountryStateCityService countryStateCityService;

    public CountryStateCityController(CountryStateCityService countryStateCityService) {
        this.countryStateCityService = countryStateCityService;
    }

    @QueryMapping
    Country countryByName(@NonNull @Argument String name) {
        return countryStateCityService.getCountryByName(name);
    }

    @QueryMapping
    List<Country> allCountries() {
        return countryStateCityService.getAllCountries();
    }

    @QueryMapping
    Country countryByNameSingleQuery(@NonNull @Argument String name) {
        return countryStateCityService.getCountryByNameSingleQuery(name);
    }

    @QueryMapping
    Country countryByNameEntityGraph(@NonNull @Argument String name) {
        return countryStateCityService.getCountryByNameEntityGraph(name);
    }

    @QueryMapping
    List<Country> allCountriesSingleQuery() {
        return countryStateCityService.getAllCountriesSingleQuery();
    }
}
