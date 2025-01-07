package com.example.calculator.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator<T extends Number> {
    private List<String> list = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    private T x;
    private T y;
    private OperatorType operatorType;

    private ArithmeticCalculator<T> arithmeticCalculator;

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
            strArray = str.split(operator);
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
    String calculate() {
        T result = switch (operatorType) {
            case ADD -> arithmeticCalculator.Calculate(x, y, (x,y) -> x+y);
            case SUBTRACT -> arithmeticCalculator.Calculate(x, y, (x,y) -> x-y);
            case MULTIPLY -> arithmeticCalculator.Calculate(x, y, (x,y) -> x*y);
            case DIVIDE -> arithmeticCalculator.Calculate(x, y, (x,y) -> x/y);
        };

        this.sb.append(" = ").append(result);
        return sb.toString();
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
