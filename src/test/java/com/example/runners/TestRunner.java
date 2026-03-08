package com.example.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Cucumber test runner class for executing BDD test scenarios.
 * Configures and orchestrates the execution of all feature files with their
 * corresponding step definitions.
 *
 * This runner is executed by JUnit and loads all feature files from the
 * src/test/resources/features directory. Step definitions are discovered
 * in the com.example.stepdefinitions package.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.stepdefinitions",
        plugin = {"pretty"}//,
//        tags = "@"
)
public class TestRunner {
}

