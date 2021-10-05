package com.qrvey.tasks;

import com.qrvey.userinterfaces.SelectProduct;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

import java.util.List;

import static com.qrvey.enums.SessionVariables.SELECTED_PRODUCT;
import static com.qrvey.userinterfaces.SelectProduct.*;

public class AddProduct implements Task {

    private List<String> productList;

    protected AddProduct(List<String> productList) {
        this.productList = productList;
    }

    public static AddProduct selectProduct(List<String> productList) {
        return Tasks.instrumented(AddProduct.class, productList);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (String product : productList) {
            actor.attemptsTo(
                    Click.on(SelectProduct.selectProduct(product.trim())),
                    Click.on(BTN_ADD_TO_CART),
                    Click.on(BTN_BACK_TO_PRODUCTS),
                    WaitUntil.the(BTN_ADD_TO_CART, isEnabled()));
        }
        actor.attemptsTo(Click.on(BTN_CART));
        Serenity.setSessionVariable(SELECTED_PRODUCT.getVariableName()).to(productList);
    }

}
