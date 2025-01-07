package com.example.calculator.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

public class Calculator<T extends Number> {
    private List<String> list = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    private T x;
    private T y;
    private OperatorType operatorType;

    private ArithmeticCalculator<T> arithmeticCalculator = new ArithmeticCalculator<>();
    ;

    Calculator() {}

    // 초기화
    boolean initalize(String str, NumberParser<T> parser) {
        sb.delete(0, sb.length());
        String[] strArray;
        String operator;

        // 계산식에서 / * + - 아니면 값을 받아드리지 못하는 문제 발견
        // operatorType 값을 돌면서 받아오기
        try {
            int operatorIndex = -1;
            for( OperatorType o : OperatorType.values() ) {
                operatorIndex = str.indexOf(o.getValue());
                if( operatorIndex != -1) break;
            }
            if( operatorIndex == -1 ) throw new CalculatorIOException("타입이 없습니다.");
            operator = "" + str.charAt(operatorIndex);
            strArray = str.split(Pattern.quote(operator)); // Pattern 을 찾기
        } catch (CalculatorIOException e) {
            System.out.println("잘못된 계산식입니다.");
            return false;
        }

        sb.append(str);
        x = parser.parse(strArray[0]);
        y = parser.parse(strArray[1]);

        // 조건 입력받는 수는 양의 정수임
//        if( !(Integer.parseInt(strArray[0]) > 0) ) return false;
//        if( !(Integer.parseInt(strArray[1]) > 0) ) return false;
        // 여기 0 밑 소수점 즉, 0.1234 면 에러가 나올 예정 ( 수정 완 )
        // 기존 Integer 타입은 0 밑 소수점은 자르고 생각함 근대 그것들은 0이 아님
//        간단하게 분모가 되는 수를 "0"하고 비교 => 완벽하게 0 이면 문제가 없을 것

        try {
                // 기존 getValue 하면 ADD, DIVIDE 만 나오는것을 확인
//            스태틱을 사용하여 클래스에서 값을 확인할수 있게 변경
            operatorType = OperatorType.getBasicType(operator);
            if( strArray[1].equals("0") && operatorType == OperatorType.DIVIDE )
                throw new CalculatorIOException("분모 에러");
            if( operatorType == null )
                throw new CalculatorIOException("operatorType 에러");
        } catch (CalculatorIOException e) {
            System.out.println("잘못된 계산식입니다.");
            return false;
        }
        return true;
    }

    // 계산기
    void calculate() {
        // 처음에는 T 자체적으로 계산을 하려고 했지만 T 의 상위 클래스인 Number에서 계산함수를 지원하지 않는다고 한다.
        // 그래서 Integer보다 큰 Double로 계산을 하고 T 로 형변환하는 것으로 진행을 하였다.
        // 내가 생각하는데로 진행을 하려했지만 그러기엔 문제가 좋지 않다는 튜터님의 말을 들으니 뭔가 많이 아쉬웠다.
        BiFunction<Double, Double, Double> oper = operatorType.getOperate();
        T result = (T) arithmeticCalculator.Calculate(x, y, oper);

        this.sb.append(" = ").append(result);
        System.out.println(result);
    }

    // List
    String[] showList() {
        String[] array = list.toArray(new String[0]);
        return array;
    }

    String getList(int num) {
        System.out.println(list.get(num));
        return list.get(num);
    }

    void saveList() {
        this.list.add(sb.toString());
    }

    void updateList(int num, String str) {
        this.list.set(num, str);
    }

    void deleteLastIndex() {
        this.list.remove(list.size()-1);
    }


    // default Calculator
//    int add() {
//        return this.x + this.y;
//    }
//
//    int minus() {
//        return this.x - this.y;
//    }
//
//    int multiply() {
//        return this.x * this.y;
//    }
//
//    int divide() {
//        return this.x / this.y;
//    }
//
//    int remain() {
//        return this.x % this.y;
//    }


    // Getter, Setter
//    void setX(int x) {
//        this.x = x;
//    }
//
//    void setY(int y) {
//        this.y = y;
//    }
//
//    int getX() {
//        return this.x;
//    }
//
//    int getY() {
//        return this.y;
//    }
}
