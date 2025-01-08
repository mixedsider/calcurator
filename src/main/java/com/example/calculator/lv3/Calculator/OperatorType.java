package com.example.calculator.lv3.Calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorType {
    // value : 타입, operate : 계산식
    ADD("+", (a, b) -> a + b),
    DIVIDE("/", (a, b) -> a / b),
    MULTIPLY("*", (a, b) -> a * b),
    SUBTRACT("-", (a, b) -> a - b),
    REMAIN("%", (a, b) -> a % b);

    private final String value;
    private final BiFunction<Double, Double, Double> operate;

    OperatorType(String value, BiFunction<Double, Double, Double> operate) {
        this.value = value;
        this.operate = operate;
    }

    // + 등 타입을 가져오기
    public String getValue() {
        return value;
    }

    // 계산식 가져오기
    public BiFunction<Double, Double, Double> getOperate() {
        return operate;
    }

    // value : + -> OperatorType.ADD 로 변경
    public static OperatorType getBasicType(String str) {
        return Arrays.stream(values())
                .filter(item -> item.value.equals(str))
                .findAny().orElse(null);
    }
}
