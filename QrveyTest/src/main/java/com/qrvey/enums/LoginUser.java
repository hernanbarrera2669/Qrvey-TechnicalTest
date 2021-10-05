package com.qrvey.enums;

public enum LoginUser {
    USER("user"),
    PASSWORD("password");

    private String value;

    LoginUser(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
