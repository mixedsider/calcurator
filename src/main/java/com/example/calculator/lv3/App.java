package com.example.calculator.lv3;

import com.example.calculator.lv3.CalculateList.CalculateList;
import com.example.calculator.lv3.Calculator.Calculator;

import java.util.Scanner;

public class App {

    private final Calculator<Number> calculator = new Calculator<>();
    private final CalculateList calculateList = new CalculateList();

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    private void start() {
        String input = "";
        System.out.println("리스트를 확인 하기 : showList");
        System.out.println("리스트 중에 입력값 보다 큰 숫자 리스트 가져오기 : showBigList");
        System.out.println("리스트 마지막 내용 삭제하기 : deleteLastIndex");
        System.out.println("리스트 중에 내용 수정하기 : updateList");
        System.out.println("프로그램 종료 : exit");
        System.out.println();
        do {
            input = getInput("계산을 할 식을 입력해주세요 ex) 10*10", "String");

            // 비교 대상보다 더 큰 숫자 알려주기
            if (input.equals("showbiglist")) {
                if (calculateList.getSize() == 0) {
                    System.out.println("아직 리스트가 없습니다.");
                    continue;
                }
                calculateList.showList();

                input = getInput("비교 숫자를 입력해주세요. : ", "Number");
                calculateList.showBiggerList(input);
                continue;
            }

            // 리스트 보여주기
            if (input.equals("showlist")) {
                calculateList.showList();
                continue;
            }

            // 리스트 마지막 index 삭제하기
            if (input.equals("deletelastindex")) {
                calculateList.deleteLastIndex();
                continue;
            }

            // 리스트 수정하기
            int num = -1;
            if (input.equals("updatelist")) {
                if (calculateList.getSize() == 0) {
                    System.out.println("아직 리스트가 없습니다.");
                    continue;
                }
                calculateList.showList();

                input = getInput("수정할 리스트 번호를 입력해주세요. : ", "Number");

                int inputNumber = Integer.parseInt(input);
                if (inputNumber < 0 || calculateList.getListIndex(inputNumber) == null) {
                    System.out.println("잘못된 번호입니다.");
                    continue;
                }

                input = getInput("수정할 계산을 할 식을 입력해주세요 ex) 10*10", "String");
                run(input, num);
                continue;
            }

            // 계산하는 곳
            run(input, num);
        } while (!input.equals("exit"));
    }

    private String getInput(String value, String returnType) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        do {
            System.out.println(value);
            input = scanner.nextLine();
            if (returnType.equals("Number") && !input.matches("^[0-9]*$")) input = "";
            else if (returnType.equals("String")) input = input.toLowerCase();
        } while (input.isBlank());

        return input;
    }

    private void run(String input, int num) {
        String result = "";
        try {
            // 초기화
            if (input.contains(".")) { // 입력받는 것에 . 이 포함되어있나 => Double
                if (calculator.initialize(input.trim(), Double::parseDouble))
                    throw new CalculatorIOException();

            } else {
                if (calculator.initialize(input.trim(), Integer::parseInt))
                    throw new CalculatorIOException();

            }

            // 계산
            result = calculator.calculate();
            System.out.println(result);

            // 리스트에 저장 && 업데이트
            if (num >= 0) calculateList.updateList(num, result);
            else calculateList.saveList(result);

        } catch (CalculatorIOException e) {
            System.out.println(e.getMessage());
        }
    }
}