package com.example.calculator.lv3.Calculator;

import com.example.calculator.lv3.CalculatorIOException;

import java.util.function.BiFunction;
import java.util.regex.Pattern;

public class Calculator<T extends Number> {
    private StringBuilder sb = new StringBuilder();

    private T x;
    private T y;
    private OperatorType operatorType;

    private ArithmeticCalculator<T> arithmeticCalculator = new ArithmeticCalculator<>();

    public Calculator() {
    }

    public boolean initalize(String str, NumberParser<T> parser) {
        sb.delete(0, sb.length());
        String[] strArray;
        String operator;

        // 연산자 찾기
        try {
            int operatorIndex = -1;
            for( OperatorType o : OperatorType.values() ) {
                operatorIndex = str.indexOf(o.getValue());
                if( operatorIndex != -1) break;
            }

            if( operatorIndex == -1 ) throw new CalculatorIOException("타입이 없습니다.");
            operator = "" + str.charAt(operatorIndex); // 연산자 char -> String
            strArray = str.split(Pattern.quote(operator)); // Pattern 을 찾기


            sb.append(str);
            if (strArray[0].matches("^[0-9]*$") || strArray[1].matches("^[0-9]*$"))
                throw new CalculatorIOException("잘못된 숫자 입력입니다.");
            x = parser.parse(strArray[0]); // String -> T
            y = parser.parse(strArray[1]);

            operatorType = OperatorType.getBasicType(operator);
            if( strArray[1].equals("0") && operatorType == OperatorType.DIVIDE )
                throw new CalculatorIOException("분모 에러");
            if( operatorType == null )
                throw new CalculatorIOException("operatorType 에러");
        } catch (CalculatorIOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    // 계산기
    public String calculate() {
        BiFunction<Double, Double, Double> oper = operatorType.getOperate();

        // double 로 계산 되어 와서 result 가 Integer을 입력해도 소수점이 나옴
        // 결론적으론 sb 에서 값을 자르든, BiFunction 을 하나더 만들어서 만들든 해야한다.
        T result = (T) arithmeticCalculator.calculate(x, y, oper);

        if (x.getClass() == Integer.class) { // 계산이 되는 것이
            this.sb.append(" = ").append(Math.round((Double) result));
        } else
            this.sb.append(" = ").append(result);
        return sb.toString();
    }
}
