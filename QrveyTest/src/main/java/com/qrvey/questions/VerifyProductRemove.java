package com.qrvey.questions;

import com.qrvey.userinterfaces.DataShoppingCar;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.qrvey.enums.SessionVariables.REMOVED_PRODUCT;

public class VerifyProductRemove implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return DataShoppingCar.selectRemoveProduct(Serenity.sessionVariableCalled(REMOVED_PRODUCT.getVariableName())).resolveFor(actor).isVisible();
    }

    public static VerifyProductRemove isNotVisible() {
        return new VerifyProductRemove();
    }
}
