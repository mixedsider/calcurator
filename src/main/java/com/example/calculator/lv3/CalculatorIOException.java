package com.example.calculator.lv3;

public class CalculatorIOException extends Exception {
    public CalculatorIOException(String value) {
        super("잘못된 입력입니다! " + value + "을 입력해주세요!");
    }

    public CalculatorIOException() {
        super("초기화 실패" + " 잘못된 입력입니다!");
    }
}
