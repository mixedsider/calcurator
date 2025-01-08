package com.example.calculator.lv3.Calculator;

import com.example.calculator.lv3.CalculatorIOException;

import java.util.function.BiFunction;
import java.util.regex.Pattern;

public class Calculator<T extends Number> {
    // 계산할 값
    private T x;
    private T y;
    private OperatorType operatorType;

    private ArithmeticCalculator<T> arithmeticCalculator = new ArithmeticCalculator<>();

    public Calculator() {
    }

    public boolean initalize(String str, NumberParser<T> parser) {
        String[] strArray;
        String operator;

        try {
            // 연산자 찾기
            int operatorIndex = -1;
            for( OperatorType o : OperatorType.values() ) {
                operatorIndex = str.indexOf(o.getValue());
                if( operatorIndex != -1) break;
            }

            // 연산자 기준으로 문자열 나누기
            if( operatorIndex == -1 ) throw new CalculatorIOException("타입이 없습니다.");
            operator = "" + str.charAt(operatorIndex); // 연산자 char -> String
            strArray = str.split(Pattern.quote(operator)); // Pattern 을 찾기
            strArray[0] = strArray[0].trim();
            strArray[1] = strArray[1].trim();

            // 각 숫자 변환 전 형식 체크
            if (!(strArray[0].matches("^[0-9]*$") || strArray[1].matches("^[0-9]*$")))
                throw new CalculatorIOException("잘못된 숫자 입력입니다.");
            x = parser.parse(strArray[0]); // String -> T
            y = parser.parse(strArray[1]);

            // 계산에 필요한 정보 가져오기 Enum class
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
        StringBuilder sb = new StringBuilder();
        // 순수함수 계산식 가져오기 ( 람다 )
        BiFunction<Double, Double, Double> oper = operatorType.getOperate();

        T result = (T) arithmeticCalculator.calculate(x, y, oper);

        // 계산 이후 빌드
        sb.append(x).append(" ").append(operatorType.getValue()).append(" ").append(y);
        if (x.getClass() == Integer.class) { // x의 변수에 따라 계산의 값이 바뀜 -> Integer 면 정수, Double이면 실수
            sb.append(" = ").append(Math.round((Double) result));
        } else
            sb.append(" = ").append(result);
        return sb.toString();
    }
}
