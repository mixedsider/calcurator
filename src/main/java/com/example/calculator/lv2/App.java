package com.example.calculator.lv2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        String input;
        do {
            do {
                System.out.println("계산을 할 식을 입력해주세요 ex) 10*10");
                input = scanner.next();
            } while ( input.isBlank() );

            // 마지막 로그 삭제하기
            if( input.equals("deleteLastIndex")) {
                calculator.deleteListIndex();
                continue;
            }

//             로그 수정하기
            if( input.equals("updateLog") ) {
                String[] list = calculator.showList();
                for( int i = 0; i < list.length; i++ )
                    System.out.println(i + " " + list[i]);
                int num = 0;
                do {
                    System.out.println("수정할 로그 번호를 입력해주세요. : ");
                    num = scanner.nextInt();
                } while ( !(num >= 0) );
                do {
                    System.out.println("수정할 계산을 할 식을 입력해주세요 ex) 10*10");
                    input = scanner.next();
                } while ( input.isBlank() );
                if( !calculator.initalize(input) ) continue;
                String result = calculator.calculate();
                calculator.updateList(num , result);
                System.out.println(result);
                continue;
            }


            // 로그 보여주기
            if( input.equals("showLog")) {
                for( String str : calculator.showList() )
                    System.out.println(str);
                continue;
            }

            // 계산하는 곳
            if( !calculator.initalize(input) ) continue;
            String result = calculator.calculate();
            calculator.saveList();
            System.out.println(result);
        } while ( !input.equals("exit") );
    }
}
