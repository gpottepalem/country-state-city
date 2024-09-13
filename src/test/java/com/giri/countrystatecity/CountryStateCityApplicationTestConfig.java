package com.giri.countrystatecity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

/**
 * Test Configuration.
 *
 * @author Giri Pottepalem
 * created Sep 13, 2024
 */
@TestConfiguration(proxyBeanMethods = false)
public class CountryStateCityApplicationTestConfig {

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
    }

    public static void main(String[] args) {
        SpringApplication.from(CountryStateCityApplication::main).with(CountryStateCityApplicationTestConfig.class).run(args);
    }

}
