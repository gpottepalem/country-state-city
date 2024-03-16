package com.giri.countrystatecity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.giri"})
public class CountryStateCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountryStateCityApplication.class, args);
    }

}
