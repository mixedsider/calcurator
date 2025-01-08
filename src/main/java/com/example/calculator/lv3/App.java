package com.example.calculator.lv3;

import com.example.calculator.lv3.CalculateList.CalculateList;
import com.example.calculator.lv3.Calculator.Calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculateList calculateList = new CalculateList();

        String input;
        do {
            do {
                System.out.println("계산을 할 식을 입력해주세요 ex) 10*10");
                input = scanner.nextLine();
            } while (input.isBlank());

            if (input.equals("showBiggerList")) {
                do {
                    System.out.println("비교 숫자를 입력해주세요. : ");
                    input = scanner.nextLine();
                } while (input.isBlank());
                calculateList.showBiggerList(input);
                continue;
            }

            // 로그 보여주기
            if (input.equals("showList")) {
                calculateList.showList();
                continue;
            }

            // 마지막 삭제하기
            if (input.equals("deleteLastIndex")) {
                calculateList.deleteLastIndex();
                continue;
            }

//             로그 수정하기
            int num = -1;
            if (input.equals("updateList")) {
                calculateList.showList();

                do {
                    System.out.println("수정할 리스트 번호를 입력해주세요. : ");
                    num = scanner.nextInt();
                } while (!(num >= 0));

                do {
                    System.out.println("수정할 계산을 할 식을 입력해주세요 ex) 10*10");
                    input = scanner.nextLine();
                } while (input.isBlank());
            }


            // 계산하는 곳
            String result = "";
            try {
                Calculator<Number> calculator = new Calculator<>();
                if (input.contains(".")) { // 입력받는 것에 . 이 포함되어있나 => Double
                    if (!calculator.initalize(input, Double::parseDouble))
                        throw new CalculatorIOException();

                } else {
                    if (!calculator.initalize(input, Integer::parseInt))
                        throw new CalculatorIOException();

                }
                result = calculator.calculate();
            } catch (CalculatorIOException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(result);
            if (num >= 0) calculateList.updateList(num, result);
            else calculateList.saveList(result);

        } while (!input.equals("exit"));
    }
}