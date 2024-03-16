package com.giri.countrystatecity.config;

import graphql.scalars.ExtendedScalars;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

/**
 * GraphQL Configuration for extended scalar types like Long, DateTime etc.
 *
 * @author Giri Pottepalem
 * created Mar 16, 2024
 */
@Configuration
@Slf4j
public class GraphQLConfig {
    /**
     * Custom scalar support for UUID, Long, and DateTime. Registers extended scalar types used GraphQL query schema.
     */
    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        log.info("Registering extended GraphQL scalar types for Long, DateTime...");

        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.GraphQLLong)
                                    .scalar(ExtendedScalars.DateTime);
    }
}
