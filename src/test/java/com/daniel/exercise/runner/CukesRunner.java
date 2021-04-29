package com.daniel.exercise.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/return.txt"
        },
        features = "src/test/resources/features",
        glue = "com/daniel/exercise/step_definitions",
        dryRun = false
)
public class CukesRunner {}
