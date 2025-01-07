package com.example.calculator.lv3;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<String> list = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    private int x;
    private int y;
    private String operator;

    Calculator() {}

    boolean initalize(String str) {
        sb.delete(0, sb.length());
        String[] strArray = str.split("[/*+\\-]");
        if( strArray.length != 2 ) return false;

        sb.append(str);

        // 조건 입력받는 수는 양의 정수임
        if( !(Integer.parseInt(strArray[0]) > 0) ) return false;
        if( !(Integer.parseInt(strArray[1]) > 0) ) return false;
        this.x = Integer.parseInt(strArray[0]);
        this.y = Integer.parseInt(strArray[1]);

        this.operator = str.substring(strArray[0].length(), strArray[0].length()+1);
        if( this.operator.isBlank() ||
            !(
                this.operator.charAt(0) == '+' ||
                this.operator.charAt(0) == '-' ||
                this.operator.charAt(0) == '/' ||
                this.operator.charAt(0) == '*'
            ) ) return false;
        if( !(Integer.parseInt(strArray[1]) != 0 || this.operator.equals("/")) ) return false;
//        System.out.println("x: " + x + " y: " + y + " operator: " + operator);
        return true;
    }

    String calculate() {
        int result = switch (operator) {
            case "+" -> add();
            case "-" -> minus();
            case "*" -> multiply();
            case "/" -> divide();
            case "%" -> remain();
            default -> 0;
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
    int add() {
        return this.x + this.y;
    }

    int minus() {
        return this.x - this.y;
    }

    int multiply() {
        return this.x * this.y;
    }

    int divide() {
        return this.x / this.y;
    }

    int remain() {
        return this.x % this.y;
    }


    // Getter, Setter
    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

    void setOperator(String operator) {
        this.operator = operator;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    String getOperator() {
        return this.operator;
    }
}
