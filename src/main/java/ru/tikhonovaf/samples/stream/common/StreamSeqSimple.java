package ru.tikhonovaf.samples.stream.common;

import java.util.stream.Stream;

public class StreamSeqSimple {

    public static void main(String[] args) {

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s-> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
//                .sorted()
                .anyMatch(s-> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });


    }
}
