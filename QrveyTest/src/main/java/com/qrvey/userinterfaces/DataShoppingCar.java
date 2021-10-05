package com.qrvey.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class DataShoppingCar extends PageObject {
    public static Target selectProduct(String productVerified) {
        return Target.the("Select the product requiered")
                .locatedBy("//div[contains(text(), '{0}')]")
                .of(productVerified);
    }

    public static Target selectRemoveProduct(String productToRemove) {
        return Target.the("Remove the product requiered")
                .locatedBy("//button[@id='remove-{0}']")
                .of(productToRemove);
    }
}
