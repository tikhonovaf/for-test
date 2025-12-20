package ru.tikhonovaf.samples.core;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 10; i++) {
            j= j++;
            System.out.println(j);
        }

        print(new ArrayList<>());
    }

    public static void print(ArrayList<Integer> list) {
        System.out.println("Integer List");


    }

//    public static void print(ArrayList<String> list) {
//        System.out.println("String  List");
//    }

}
