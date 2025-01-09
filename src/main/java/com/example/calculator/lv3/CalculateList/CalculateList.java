package com.example.calculator.lv3.CalculateList;

import java.util.ArrayList;
import java.util.List;

public class CalculateList {

    private List<String> list = new ArrayList<>();

    public CalculateList() {
    }

    /*List 보여주기*/
    public void showList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " : " + list.get(i));
        }
    }

    /*list 사이즈 가져오기*/
    public int getSize() {
        return list.size();
    }

    /*리스트 중에 하나 가져오기*/
    public String getListIndex(int num) {
        if (list.size() - 1 < num) return null;
        System.out.println(list.get(num));
        return list.get(num);
    }

    /*리스트에 저장하기*/
    public void saveList(String str) {
        this.list.add(str);
    }

    /*리스트 수정하기*/
    public void updateList(int num, String str) {
        this.list.set(num, str);
    }

    /*리스트 마지막 인덱스 삭제하기*/
    public void deleteLastIndex() {
        this.list.remove(list.size() - 1);
    }

    /*조건보다 큰 index 보여주기*/
    public void showBiggerList(String number) {
        double num = Double.parseDouble(number);
        list.stream()
                .filter(item ->
                        Double.parseDouble(item.split("=")[1].trim()) > num)
                .forEach(System.out::println);
    }
}
