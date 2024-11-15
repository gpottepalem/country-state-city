package com.giri.countrystatecity.modularity;

import com.giri.countrystatecity.CountryStateCityApplication;
import org.junit.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

/**
 * Modularity test to verify modular dependencies and generate documentation.
 *
 * @author Giri Pottepalem
 * Created Nov 15, 2024
 */
public class ModularityTests {
    ApplicationModules modules = ApplicationModules.of(CountryStateCityApplication.class);

    /**
     * Test to verify application structure. Rejects cyclic dependencies and access to internal types.
     */
    @Test
    public void verifyModularity() {
        modules.verify();
    }

    /**
     * Test to generate Application Module Component diagrams under target/spring-modulith-docs.
     */
    @SuppressWarnings("squid:S2699")
    @Test
    public void writeDocumentationSnippets() {
        new Documenter(modules)
            .writeModulesAsPlantUml()
            .writeIndividualModulesAsPlantUml();
    }
}
