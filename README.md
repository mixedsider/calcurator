# 내일배움캠프 CH 2 계산기 과제


## 프로그램 구성
![image](https://github.com/user-attachments/assets/9b3058ba-4257-4cd6-8a24-da3d4650b24f)


## 프로그램 사용법

    git clone https://github.com/mixedsider/calcurator.git 

./calculator/src/main/java/com/example/calculator/[원하는 레벨]/App.java 에 있는 main 을 실행시키면 됩니다.

### 사칙 연산 외 더 많은 기능을 추가하는 법
![image](https://github.com/user-attachments/assets/73cb90fd-7499-4af3-8de1-140d7a298370)

Enum Class에 형식에 맞게 추가를 하면 됩니다.

    // ex)
    POWER("^", (a, b) -> Math.pow(a,b));
    // [이름 대문자]("[기호]", ( [피연산자1], [피연산자2] ) -> [계산식] );


### 레벨별 차이

개발 기간 : 4일

- lv1 : 간단한 사칙연산, Integer 타입

- lv2 : 부가기능 추가

- lv3 : 사칙연산 외 기능 추가 가능, Double, Integer 타입



## 개발 환경
- IntellJ IDEA Ultimate Edition 2024.3.1.1

- Java 17.0.11

- Github

- git 2.34.1

- ubuntu Ubuntu 22.04.5 LTS 64bit


## 개발자 블로그

    https://strnetwork.tistory.com/

## 트러블 슈팅 내용

    https://strnetwork.tistory.com/40

### 소감
제네릭과 Enum 클래스를 사용을 처음해보다보니 문제가 많이 있었다.

그리고 깔끔하게 작성을 해서 사용을 하려다보니 BiFunction, FunctionInterface 등

여러 새로운 문법을 찾아서 사용을 해보았는데, 순수함수를 위한 람다식이 많다는 것을 알았다.
