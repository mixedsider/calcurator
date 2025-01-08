package com.example.calculator.lv3.CalculateList;

import java.util.ArrayList;
import java.util.List;

public class CalculateList {

    private List<String> list = new ArrayList<>();

    public CalculateList() {
    }

    // List
    public void showList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " : " + list.get(i));
        }
    }

    public int getSize() {
        return list.size();
    }

    public String getList(int num) {
        System.out.println(list.get(num));
        return list.get(num);
    }

    public void saveList(String str) {
        this.list.add(str);
    }

    public void updateList(int num, String str) {
        this.list.set(num, str);
    }

    public void deleteLastIndex() {
        this.list.remove(list.size() - 1);
    }

    public void showBiggerList(String number) {
        double num = Double.parseDouble(number);
        list.stream().filter(item ->
                        Double.parseDouble(item.split("=")[1].trim()) > num)
                .forEach(System.out::println);
    }
}
