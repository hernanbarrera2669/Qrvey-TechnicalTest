package com.qrvey.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.qrvey.userinterfaces.VerifyNextPage.LBL_PRODUCTS;

public class VerifyProductsPage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return LBL_PRODUCTS.resolveFor(actor).getText();
    }

    public static VerifyProductsPage isCorrect() {
        return new VerifyProductsPage();
    }
}
