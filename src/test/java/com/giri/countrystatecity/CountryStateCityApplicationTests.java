package com.giri.countrystatecity;

import com.giri.countrystatecity.service.CountryStateCityService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

/**
 * Integration Smoke Test to ensure that the application starts up.
 *
 * @author Giri Pottepalem
 * created Sep 13, 2024
 */
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    useMainMethod = SpringBootTest.UseMainMethod.ALWAYS // Get the main method coverage by this from this smoke test
)
class CountryStateCityApplicationTests {
    @Autowired
    CountryStateCityService countryStateCityService;

    @Test
    @DisplayName("An integration Smoke Test to ensure that the application context loads and autowiring works.")
    void smokeTest_context_loads_and_autowiring_works() {
        assertThat(countryStateCityService).isNotNull();
    }
}
