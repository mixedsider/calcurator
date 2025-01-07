package com.example.calculator.lv3;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorType {
    ADD("+", "(x + y) -> x + y"),
    DIVIDE("/", "(x + y) -> x / y"),
    MULTIPLY("*", "(x + y) -> x * y"),
    SUBTRACT("-", "(x + y) -> x - y");

    private final String value;
    private final String type;

    OperatorType(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public String getAllValue() {
        return Arrays.toString(OperatorType.values());
    }

    public static OperatorType getBasicType(String str) {
        return Arrays.stream(values())
                .filter(item -> item.value.equals(str))
                .findAny().orElse(null);
    }
}
