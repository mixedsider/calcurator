package com.example.calculator.lv3.Calculator;

import java.util.function.BiFunction;

public class ArithmeticCalculator<T extends Number> {

    //실제 계산
    public T calculate(T x, T y, BiFunction<Double, Double, Double> operation) {
        return (T) operation.apply(x.doubleValue(), y.doubleValue());
    }
}
