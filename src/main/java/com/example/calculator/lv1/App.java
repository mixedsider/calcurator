package com.example.calculator.lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long number1, number2;
        char operation;
        String input;

        while (true) {
            do {
                System.out.println("숫자를 입력해주세요. : ");
                input = scanner.next();
                if( input.equals("exit") ) return;
            } while ( !(Long.parseLong(input) > 0 || input.isEmpty()) );
            number1 = Long.parseLong(input);

            do {
                System.out.println("기호를 입력해주세요. : ");
                input = scanner.next();
                if( input.equals("exit") ) return;
            } while ( input.isBlank() || !(input.charAt(0) == '+' || input.charAt(0) == '-' || input.charAt(0) == '/' || input.charAt(0) == '*') );
            operation = input.charAt(0);

            do {
                System.out.println("숫자를 입력해주세요. : ");
                input = scanner.next();
                if( input.equals("exit") ) return;
            } while ( !(Long.parseLong(input) > 0 || input.isEmpty()) );
            number2 = Long.parseLong(input);

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
