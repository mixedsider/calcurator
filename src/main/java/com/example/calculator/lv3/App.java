package com.example.calculator.lv3;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // 로그 랑 리스트 이름 둘중에 하나만 사용하기

        // 스트림 api 사용되는 부분이 실시간 데이터 처리하는 부분에서 사용이 됨
        Calculator<Integer> calculator = new Calculator<>();
        calculator.initalize("10%10", Integer::parseInt);

        calculator.calculate();
//        Scanner scanner = new Scanner(System.in);
//
//        String input;
//        do {
//            do {
//                System.out.println("계산을 할 식을 입력해주세요 ex) 10*10");
//                input = scanner.next();
//            } while ( input.isBlank() );
//
//            // 마지막  삭제하기
//            if( input.equals("deleteLastIndex")) {
//                calculator.deleteLastIndex();
//                continue;
//            }
//
////             로그 수정하기
//            if( input.equals("updateList") ) {
//                String[] list = calculator.showList();
//                for( int i = 0; i < list.length; i++ )
//                    System.out.println(i + " " + list[i]);
//                int num = 0;
//                do {
//                    System.out.println("수정할 리스트 번호를 입력해주세요. : ");
//                    num = scanner.nextInt();
//                } while ( !(num >= 0) );
//                do {
//                    System.out.println("수정할 계산을 할 식을 입력해주세요 ex) 10*10");
//                    input = scanner.next();
//                } while ( input.isBlank() );
//                if( !calculator.initalize(input, Double::parseDouble) ) continue;
//                calculator.calculate();
////                calculator.updateList(num , result);
////                System.out.println(result);
//                continue;
//            }
//
//
//            // 로그 보여주기
//            if( input.equals("showList")) {
//                for( String str : calculator.showList() )
//                    System.out.println(str);
//                continue;
//            }
//
//            // 계산하는 곳
//            if( !calculator.initalize(input, Double::parseDouble) ) continue;
//            calculator.calculate();
//            calculator.saveList();
////            System.out.println(result);
//        } while ( !input.equals("exit") );
    }
}



// 1. 사용자에게서 값을 입력을 받는다.
// 2. 값을 확인한후 Integer, Double 인지 결정
//  new ArithmeticCalculator<T>();
// ArithmeticCalculator 안에서 Calculate() 동작