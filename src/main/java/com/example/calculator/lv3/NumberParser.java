package com.example.calculator.lv3;

@FunctionalInterface
public interface NumberParser<T extends Number> {
    T parse(String value);
}
