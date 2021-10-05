package com.qrvey.questions;

import com.qrvey.userinterfaces.VerifyFilterProduct;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerifyFilter implements Question<String> {
    private String verifyFilterProduct;

    protected VerifyFilter(String verifyFilter){
        this.verifyFilterProduct= verifyFilter;
    }

    @Override
    public String answeredBy(Actor actor) {
        return VerifyFilterProduct.verifyFilterProduct(verifyFilterProduct).resolveFor(actor).getText();
    }

    public static VerifyFilter isCorrect(String verifyFilterProduct) {
        return new VerifyFilter(verifyFilterProduct);
    }
}
