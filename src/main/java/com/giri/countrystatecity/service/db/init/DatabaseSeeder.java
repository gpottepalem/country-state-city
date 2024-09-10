package com.giri.countrystatecity.service.db.init;

import com.giri.countrystatecity.domain.City;
import com.giri.countrystatecity.domain.Country;
import com.giri.countrystatecity.domain.State;
import com.giri.countrystatecity.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @author Giri Pottepalem
 * created Mar 16, 2024
 */
@Service
@Profile({"default"})
@Slf4j
public class DatabaseSeeder {
    private CountryRepository countryRepository;

//    @Value("${spring.profiles.active}")
//    private String activeProfile;

    @Autowired
    public DatabaseSeeder(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    @Transactional
    public void seedDatabase() {
        // one-time seeding of database
        if (countryRepository.count() == 0) {
            log.info("Seeding database with one-time data...");
            var india = Country.builder().name("India").build();
            var andhraPradesh = State.builder().name("Andhra Pradesh").code("AP").population(49_577_103L).build();
            andhraPradesh.addCities(Set.of(
                City.builder().name("Nellore").population(838_000L).build(),
                City.builder().name("Chittoor").population(175_647L).build()
            ));

            var telangana = State.builder().name("Telangana").code("TS").population(35_003_674L).build();
            telangana.addCities(Set.of(
                City.builder().name("Hyderabad").population(11_069_000L).build(),
                City.builder().name("Secunderabad").population(204_182L).build()
            ));
            india.addStates(Set.of(andhraPradesh, telangana));

            var usa = Country.builder().name("United States of America").build();
            var massachusetts = State.builder().name("Massachusetts").code("MA").population(7_029_917L).build();
            massachusetts.addCities(Set.of(
                City.builder().name("Boston").population(650_706L).build(),
                City.builder().name("Canton").population(24_370L).build()
            ));

            var illinois = State.builder().name("Illinois").code("IL").population(12_812_508L).build();
            illinois.addCities(Set.of(
                City.builder().name("Naperville").population(149_540L).build(),
                City.builder().name("Urbana").population(38_468L).build()
            ));
            usa.addStates(Set.of(massachusetts, illinois));

            countryRepository.saveAll(List.of(india, usa));

            log.info("Seeded database with one-time data...");
        } else {
            log.info("Database was already seeded with data. No need to seed...");
        }
    }
}
