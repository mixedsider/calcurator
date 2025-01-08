package com.example.calculator.lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long number1, number2;
        char operation;
        String input;

        while (true) {
            // 피연산자1 or 명령어 입력
            do {
                System.out.println("숫자를 입력해주세요. : ");
                input = scanner.next();
                if (input.equals("exit")) return; // exit 입력시 프로램 종료
            } while ( !(Long.parseLong(input) > 0 || input.isEmpty()) );
            number1 = Long.parseLong(input);

            // 기호 입력
            do {
                System.out.println("기호를 입력해주세요. : ");
                input = scanner.next();
                if( input.equals("exit") ) return;
            } while ( input.isBlank() || !(input.charAt(0) == '+' || input.charAt(0) == '-' || input.charAt(0) == '/' || input.charAt(0) == '*') );
            operation = input.charAt(0);

            // 피연산자2 입력
            do {
                System.out.println("숫자를 입력해주세요. : ");
                input = scanner.next();
                if( input.equals("exit") ) return;
            } while ( !(Long.parseLong(input) > 0 || input.isEmpty()) );
            number2 = Long.parseLong(input);

            // 계산
            switch (operation) {
                case '+':
                    System.out.println(number1 + number2);
                    break;
                case '-':
                    System.out.println(number1 - number2);
                    break;
                case '/':
                    if( number2 == 0 ) {
                        System.out.println("나누기의 분모는 0이 될 수 없습니다.");
                        break;
                    }
                    System.out.println(number1 / number2);
                    break;
                case '*':
                    System.out.println(number1 * number2);
                    break;
                default:
            }
        }
    }
}
