package com.qrvey.enums;

public enum ErrorMessage {

    DOES_NOT_EXIST_PRODUCTS_PAGE("Does not exists page of products"),
    FILTER_NOT_APPLY("product in list not found"),
    DOES_NOT_EXIST_PRODUCTS_IN_THE_SHOPPING_CAR("Product in the shopping car not found"),
    PRODUCT_NOT_REMOVED("Product not removed"),
    SESSION_DOES_NOT_CLOSE("Session does not close");

    private final String messageError;

    ErrorMessage(String messageError) {
        this.messageError = messageError;
    }

    public String getMessageError() {
        return messageError;
    }
}
