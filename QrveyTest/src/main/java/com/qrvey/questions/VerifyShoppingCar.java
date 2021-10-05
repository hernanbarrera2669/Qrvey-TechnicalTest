package com.qrvey.questions;

import com.qrvey.userinterfaces.DataShoppingCar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerifyShoppingCar implements Question<String> {

    private String verifyProducts;

    protected VerifyShoppingCar(String verifyProducts) {
        this.verifyProducts = verifyProducts;
    }

    @Override
    public String answeredBy(Actor actor) {
        return DataShoppingCar.selectProduct(verifyProducts).resolveFor(actor).getText();
    }

    public static VerifyShoppingCar toExist(String verifyProducts) {
        return new VerifyShoppingCar(verifyProducts);
    }
}
