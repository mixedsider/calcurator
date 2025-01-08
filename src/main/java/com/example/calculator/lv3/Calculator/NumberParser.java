package com.example.calculator.lv3.Calculator;

@FunctionalInterface
public interface NumberParser<T extends Number> {
    // 람다식으로 표현하기 위한 인터페이스
    // Double::parseDouble or Integer::parseInt
    T parse(String value);
}
