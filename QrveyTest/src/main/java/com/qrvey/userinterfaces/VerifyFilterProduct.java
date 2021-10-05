package com.qrvey.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class VerifyFilterProduct extends PageObject {

    public static Target verifyFilterProduct(String productFilter) {
        return Target.the("This label show information about T-shirt (red) as first in the list")
                .locatedBy("//div[@class='inventory_item_label']//div[contains(text(), '{0}')]")
                .of(productFilter);
    }
}

