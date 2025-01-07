package com.example.calculator.lv3;

import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
import java.util.function.BiFunction;

public class ArithmeticCalculator <T extends Number> {

    // 기존 타입에 들어가는 Integer, Double 이런거를 T, N 이런걸로 바꿔보고
    // 트러블슈팅을 해본다.
    // 이걸 해결한다?


    private T x;
    private T y;
    // 제네릭 타입에서 직접적인 연산자를 사용할수 없다..
//    왜냐하면 컴파일타임에 특정 타입으로 결정되지 않기 때문에
    // 그렇기 때문에 람다 같은 형식에 매이지 않는 Operator나 Function 같은 명시적인 구조를 추가로 정의를 해야한다.
    public ArithmeticCalculator () {}

    public T Calculate(T x, T y, BiFunction<T, T, T> operation) {
        return operation.apply(x, y);
    }

//     default Calculator
}
