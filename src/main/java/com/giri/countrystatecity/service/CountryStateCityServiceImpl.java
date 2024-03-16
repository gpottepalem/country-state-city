package com.giri.countrystatecity.service;

import com.giri.countrystatecity.domain.Country;
import com.giri.countrystatecity.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A concrete implementation of {@link CountryStateCityService}
 *
 * @author Giri Pottepalem
 * created Mar 16, 2024
 */
@Service
public class CountryStateCityServiceImpl implements CountryStateCityService {
    private CountryRepository countryRepository;

    public CountryStateCityServiceImpl(CountryRepository cityRepository) {
        this.countryRepository = cityRepository;
    }

    @Override
    public Country getCountryByName(String name) {
        return countryRepository.findByName(name)
            .orElseThrow(()-> new IllegalArgumentException(String.format("Illegal Country name:%s", name)));
    }

    @Override
    public Country getCountryByNameSingleQuery(String name) {
        return countryRepository.findByNameSingleQueryJoinFetch(name)
            .orElseThrow(()-> new IllegalArgumentException(String.format("Illegal Country name:%s", name)));
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public List<Country> getAllCountriesSingleQuery() {
        return countryRepository.findAllSingleQueryJoinFetch();
    }
}
