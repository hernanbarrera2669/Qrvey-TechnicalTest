package com.qrvey.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class DataUserInterface extends PageObject {

    public static final Target TXT_USER =
            Target.the("Specific the user name in this field").located(By.id("user-name"));

    public static final Target TXT_PASSWORD =
            Target.the("Specific the password in this field").located(By.id("password"));

    public static final Target BTN_LOGIN =
            Target.the("Clic here allows user to next page").located(By.id("login-button"));
}
