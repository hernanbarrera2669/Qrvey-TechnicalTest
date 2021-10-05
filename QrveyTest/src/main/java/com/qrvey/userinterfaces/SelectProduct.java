package com.qrvey.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class SelectProduct extends PageObject {

    public static Target selectProduct(String product) {
        return Target.the("Select the product requiered")
                .locatedBy("//div[@class='inventory_item_label']//div[contains(text(), '{0}')]")
                .of(product);
    }

    public static final Target BTN_ADD_TO_CART =
            Target.the("Select the button add to cart")
                    .located(By.xpath("//button[contains(text(), 'Add to cart')]"));

    public static final Target BTN_CART =
            Target.the("Select the shopping cart")
                    .located(By.id("shopping_cart_container"));

    public static final Target BTN_BACK_TO_PRODUCTS =
            Target.the("Select back to products")
                    .located(By.id("back-to-products"));
}
