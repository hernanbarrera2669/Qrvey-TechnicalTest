package com.qrvey.enums;

public enum CheckoutProduct {
    NAME("name"),
    LAST_NAME("lastName"),
    ZIP_CODE("zipCode");

    private String value;

    CheckoutProduct(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
