package com.qrvey.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

    @RunWith(CucumberWithSerenity.class)
    @CucumberOptions(
            features = "src/test/resources/features/purchase_products.feature",
            snippets = CucumberOptions.SnippetType.CAMELCASE,
            glue = "com.qrvey.stepdefinitions")

    public class SaucedemoRunner {
    }

