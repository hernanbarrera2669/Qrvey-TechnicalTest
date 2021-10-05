package com.qrvey.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.qrvey.userinterfaces.DataCheckout.LBL_PURCHASE_COMPLETED;


public class VerifyMessageCheckout implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LBL_PURCHASE_COMPLETED.resolveFor(actor).getText();
    }

    public static VerifyMessageCheckout isCorrect() {
        return new VerifyMessageCheckout();
    }
}
