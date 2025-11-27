package ru.tikhonovaf.samples.collection;

public class Temp {

    public static void main(String[] args) {
        Short x = 100;
        ++x;

//        modify(x);

        System.out.println(x);
    }

    static void modify(Short val) {
        val = (short) (val + 1);
    }

}
