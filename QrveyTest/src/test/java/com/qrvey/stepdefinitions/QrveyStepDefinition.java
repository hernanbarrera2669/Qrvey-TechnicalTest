package com.qrvey.stepdefinitions;

import com.qrvey.enums.CheckoutProduct;
import com.qrvey.enums.ErrorMessage;
import com.qrvey.enums.LoginUser;
import com.qrvey.exceptions.GeneralExceptions;
import com.qrvey.models.Checkout;
import com.qrvey.models.Login;
import com.qrvey.questions.*;
import com.qrvey.tasks.*;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.qrvey.enums.SessionVariables.REMOVED_PRODUCT;
import static com.qrvey.enums.SessionVariables.SELECTED_PRODUCT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.not;

public class QrveyStepDefinition {

    @DataTableType
    public Login userData(Map<String, String> userData) {
        return new Login(
                userData.get(LoginUser.USER.getValue()),
                userData.get(LoginUser.PASSWORD.getValue()));
    }

    @DataTableType
    public Checkout dataCheckout(Map<String, String> dataCheckout) {
        return new Checkout(
                dataCheckout.get(CheckoutProduct.NAME.getValue()),
                dataCheckout.get(CheckoutProduct.LAST_NAME.getValue()),
                dataCheckout.get(CheckoutProduct.ZIP_CODE.getValue()));
    }

    @When("enter the personal data to access$")
    public void enterCredentials(List<Login> dataLoginUser) {
        String user = dataLoginUser.get(0).getUser();
        String password = dataLoginUser.get(0).getPassword();
        theActorInTheSpotlight().attemptsTo(DataUser.dataOfLogin(user, password));
    }

    @Then("the user could see products in the (.*) page$")
    public void verifyPage(String title) {
        theActorInTheSpotlight().should(seeThat(VerifyProductsPage.isCorrect(), equalTo(title))
                .orComplainWith(
                        GeneralExceptions.class, ErrorMessage.DOES_NOT_EXIST_PRODUCTS_PAGE.getMessageError()));

    }

    @When("the user filter by (.*)$")
    public void filterByName(String filterType) {
        theActorInTheSpotlight().attemptsTo(FilterProduct.sortProduct(filterType));
    }

    @Then("user could see (.*) first in the list$")
    public void verifyFilter(String productDescription) {
        theActorInTheSpotlight().should(seeThat(VerifyFilter.isCorrect(productDescription), equalTo(productDescription))
                .orComplainWith(
                        GeneralExceptions.class, ErrorMessage.FILTER_NOT_APPLY.getMessageError()));
    }

    @When("the user add product (.*) in the shopping car$")
    public void addProduct(String product) {
        List<String> productList = Arrays.asList(product.split(","));
        theActorInTheSpotlight().attemptsTo(AddProduct.selectProduct(productList));
    }

    @Then("the user could see the products in the shopping car")
    public void verifyProductShoppingCar() {
        List<String> verifyProductsList = Serenity.sessionVariableCalled(SELECTED_PRODUCT.getVariableName());
        for (String verifyProducts : verifyProductsList) {
            theActorInTheSpotlight().should(seeThat(VerifyShoppingCar.toExist(verifyProducts.trim()), equalTo(verifyProducts.trim()))
                    .orComplainWith(
                            GeneralExceptions.class, ErrorMessage.DOES_NOT_EXIST_PRODUCTS_IN_THE_SHOPPING_CAR.getMessageError()));
        }
    }

    @When("the user remove the product (.*)$")
    public void removeProduct(String productToRemove) {
        theActorInTheSpotlight().attemptsTo(RemoveProduct.removeProduct(productToRemove));
    }

    @Then("the product was removed correctly$")
    public void verifyRemovedProductShoppingCar() {
        theActorInTheSpotlight().should(seeThat(VerifyProductRemove.isNotVisible(), not(equalTo(Serenity.sessionVariableCalled(REMOVED_PRODUCT.getVariableName()))))
                .orComplainWith(
                        GeneralExceptions.class, ErrorMessage.PRODUCT_NOT_REMOVED.getMessageError()));
    }

    @When("the user end the purchase and buy a product$")
    public void endThePurchaseOfProduct(List<Checkout> dataCheckoutProduct) {
        String name = dataCheckoutProduct.get(0).getName();
        String lastName = dataCheckoutProduct.get(0).getLastName();
        String zipCode = dataCheckoutProduct.get(0).getZipCode();
        theActorInTheSpotlight().attemptsTo(DoCheckout.buyProduct(name, lastName, zipCode));
    }

    @Then("the user can see the message (.*)$")
    public void verifyMessageCheckout(String message) {
        theActorInTheSpotlight().should(seeThat(VerifyMessageCheckout.isCorrect(), equalTo(message.toUpperCase()))
                .orComplainWith(
                        GeneralExceptions.class, ErrorMessage.PRODUCT_NOT_REMOVED.getMessageError()));
    }

    @When("the user close it's session$")
    public void closeSession() {
        theActorInTheSpotlight().attemptsTo(CloseSession.closeSession());
    }

    @Then("the user is returned to initial page$")
    public void verifySessionClosed() {
        theActorInTheSpotlight().should(seeThat(VerifySessionClosed.isCorrect(),  equalTo(true))
                .orComplainWith(
                        GeneralExceptions.class, ErrorMessage.SESSION_DOES_NOT_CLOSE.getMessageError()));
    }
}