package com.qrvey.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/")
public class Webpage extends PageObject {

    public static final Target BTN_MENU =
            Target.the("")
                    .located(By.id("react-burger-menu-btn"));

    public static final Target BTN_LOGOUT =
            Target.the("")
                    .located(By.id("logout_sidebar_link"));
}
