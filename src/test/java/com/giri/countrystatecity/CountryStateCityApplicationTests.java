package com.giri.countrystatecity;

import com.giri.countrystatecity.service.CountryStateCityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    useMainMethod = SpringBootTest.UseMainMethod.ALWAYS // Get the main method coverage by this from this smoke test
)
class CountryStateCityApplicationTests {
    @Autowired
    CountryStateCityService countryStateCityService;

    @Test
    void smokeTest_contextLoads() {
        assertThat(countryStateCityService).isNotNull();
    }
}
