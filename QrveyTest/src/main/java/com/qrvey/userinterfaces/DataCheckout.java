package com.qrvey.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class DataCheckout extends PageObject {

    public static final Target BTN_CHECKOUT =
            Target.the("").located(By.id("checkout"));

    public static final Target TXT_NAME =
            Target.the("").located(By.id("first-name"));

    public static final Target TXT_LAST_NAME =
            Target.the("").located(By.id("last-name"));

    public static final Target TXT_ZIP_CODE =
            Target.the("").located(By.id("postal-code"));

    public static final Target BTN_CONTINUE =
            Target.the("").located(By.id("continue"));

    public static final Target BTN_FINISH =
            Target.the("").located(By.id("finish"));

    public static final Target LBL_PURCHASE_COMPLETED =
            Target.the("").located(By.xpath("//div//h2[@class='complete-header']"));
}
