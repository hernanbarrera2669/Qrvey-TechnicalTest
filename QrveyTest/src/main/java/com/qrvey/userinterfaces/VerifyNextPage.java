package com.qrvey.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class VerifyNextPage extends PageObject {
    public static final Target LBL_PRODUCTS =
            Target.the("This label show information about products")
                    .located(By.xpath("//div//span[contains(text(), 'Products')]"));
}
