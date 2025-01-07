package com.example.calculator.lv3;

public class CalculatorIOException extends Exception {
    public CalculatorIOException(String value) {
        super("잘못된 입력입니다! " + value + "을 입력해주세요!");
    }

    public CalculatorIOException(OperatorType operatorType) {
        super("잘못된 입력입니다! " + operatorType + "을 다시 입력해주세요!");
    }
}
