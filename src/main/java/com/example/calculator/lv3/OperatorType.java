package com.example.calculator.lv3;

public enum OperatorType {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String value;

    OperatorType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
