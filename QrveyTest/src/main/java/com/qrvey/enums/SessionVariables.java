package com.qrvey.enums;

public enum SessionVariables {
    SELECTED_PRODUCT("Selected product"),
    REMOVED_PRODUCT("Removed product");

    private String variableName;

    SessionVariables(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }
}
