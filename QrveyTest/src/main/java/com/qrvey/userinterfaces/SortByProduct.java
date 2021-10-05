package com.qrvey.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class SortByProduct extends PageObject {
    public static final Target CMB_FILTER =
            Target.the("Help to user for choise products").located(By.xpath("//select[@class='product_sort_container']"));
}
