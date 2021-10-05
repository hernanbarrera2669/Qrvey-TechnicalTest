package com.qrvey.tasks;

import com.qrvey.userinterfaces.DataShoppingCar;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.qrvey.enums.SessionVariables.REMOVED_PRODUCT;

public class RemoveProduct implements Task {

    private String productToRemove;

    protected RemoveProduct(String productToRemove) {
        this.productToRemove = productToRemove;
    }

    public static RemoveProduct removeProduct(String productToRemove) {
        return Tasks.instrumented(RemoveProduct.class, productToRemove);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String product= productToRemove.toLowerCase().replace(" ","-");
            actor.attemptsTo(
                    Click.on(DataShoppingCar.selectRemoveProduct(product)));
        Serenity.setSessionVariable(REMOVED_PRODUCT.getVariableName()).to(productToRemove);
    }
}
