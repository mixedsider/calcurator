package com.example.calculator.lv3.Calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorType {
    ADD("+", (a, b) -> a + b),
    DIVIDE("/", (a, b) -> a / b),
    MULTIPLY("*", (a, b) -> a * b),
    SUBTRACT("-", (a, b) -> a - b),
    REMAIN("%", (a, b) -> a % b);

    private final String value;
    private BiFunction<Double, Double, Double> operate;

    OperatorType(String value, BiFunction<Double, Double, Double> operate) {
        this.value = value;
        this.operate = operate;

    }

    public String getValue() {
        return value;
    }

    public BiFunction<Double, Double, Double> getOperate() {
        return operate;
    }

    public static OperatorType getBasicType(String str) {
        return Arrays.stream(values())
                .filter(item -> item.value.equals(str))
                .findAny().orElse(null);
    }
}
