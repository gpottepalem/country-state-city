package com.giri.countrystatecity.service;

import com.giri.countrystatecity.domain.Country;
import com.giri.countrystatecity.domain.State;
import com.giri.countrystatecity.domain.StatePopulation;
import com.giri.countrystatecity.repository.CountryRepository;
import com.giri.countrystatecity.repository.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A concrete implementation of {@link CountryStateCityService}
 *
 * @author Giri Pottepalem
 * created Mar 16, 2024
 */
@Service
@AllArgsConstructor
public class CountryStateCityServiceImpl implements CountryStateCityService {
    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;

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
    public Country getCountryByNameEntityGraph(String name) {
        return countryRepository.findByName(name)
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

    @Override
    public List<State> getAllByPopulationGreaterThan(Long population) {
        return stateRepository.findAllByPopulationGreaterThan(population);
    }

    @Override
    public List<StatePopulation> getAllByPopulationGreaterThanJpql(Long population) {
        return stateRepository.findAllStatesByPopulationGreaterThan(population);
    }

    @Override
    public List<StatePopulation> getAllByPopulationGreaterThanJpqlRaw(Long population) {
        List<List<Object>> states = stateRepository.findAllStatesByPopulationGreaterThanJpqlRaw(population);
        return states.stream()
            .map(record -> new StatePopulation((String) record.get(0), (Long)record.get(1)))
            .toList();
    }
}
