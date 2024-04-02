package com.epam.microservice;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "com.epam.microservice/src/test/resources/feature",
        glue = "com.epam.microservice.cucumberglue"
)
public class CucumberIntegrationTesting {
}
