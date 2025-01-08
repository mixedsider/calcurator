package com.example.calculator.lv3;

import com.example.calculator.lv3.CalculateList.CalculateList;
import com.example.calculator.lv3.Calculator.Calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculateList calculateList = new CalculateList();

        String input;
        System.out.println("리스트를 확인 하기 : showList");
        System.out.println("리스트 중에 입력값 보다 큰 숫자 리스트 가져오기 : showBigList");
        System.out.println("리스트 마지막 내용 삭제하기 : deleteLastIndex");
        System.out.println("리스트 중에 내용 수정하기 : updateList");
        System.out.println();
        do {
            do {
                System.out.println("계산을 할 식을 입력해주세요 ex) 10*10");
                input = scanner.nextLine();
            } while (input.isBlank());

            // 비교 대상보다 더 큰 숫자 알려주기
            if (input.equals("showBigList")) {
                if (calculateList.getSize() == 0) {
                    System.out.println("아직 리스트가 없습니다.");
                    continue;
                }
                do {
                    calculateList.showList();
                    System.out.println("비교 숫자를 입력해주세요. : ");
                    input = scanner.nextLine();
                    // 숫자만 들어가있는가
                    if (!input.matches("^[0-9]*$")) input = "";
                } while (input.isBlank());
                calculateList.showBiggerList(input);
                continue;
            }

            // 리스트 보여주기
            if (input.equals("showList")) {
                calculateList.showList();
                continue;
            }

            // 리스트 마지막 index 삭제하기
            if (input.equals("deleteLastIndex")) {
                calculateList.deleteLastIndex();
                continue;
            }

            // 리스트 수정하기
            int num = -1;
            if (input.equals("updateList")) {
                if (calculateList.getSize() == 0) {
                    System.out.println("아직 리스트가 없습니다.");
                    continue;
                }
                calculateList.showList();

                do {
                    System.out.println("수정할 리스트 번호를 입력해주세요. : ");
                    String temp = scanner.nextLine();
                    // 숫자면 변환
                    if (temp.matches("^[0-9]*$"))
                        num = Integer.parseInt(temp);
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
                // 초기화
                if (input.contains(".")) { // 입력받는 것에 . 이 포함되어있나 => Double
                    if (!calculator.initalize(input.trim(), Double::parseDouble))
                        throw new CalculatorIOException();

                } else {
                    if (!calculator.initalize(input.trim(), Integer::parseInt))
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


        } while (!input.equals("exit"));
    }
}