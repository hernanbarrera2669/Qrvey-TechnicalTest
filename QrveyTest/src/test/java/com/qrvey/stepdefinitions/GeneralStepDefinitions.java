package com.qrvey.stepdefinitions;

import com.qrvey.tasks.OpenWebPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class GeneralStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver hisBrowser;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(OnlineCast.whereEveryoneCan(BrowseTheWeb.with(hisBrowser)));
    }

    @Given("that the (.*) enter to the webpage of Saucedemo$")
    public void enteredWebPortal(String actor) {
        theActorCalled(actor).wasAbleTo(OpenWebPage.webPage());
    }
}