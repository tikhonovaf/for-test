package ru.tikhonovaf.samples.stream.sobes.streampeek;

import java.util.stream.Stream;

public class StreamPeek {
    public static void main(String[] args) {
        Stream.of(new Phone(1, "1"), new Phone(2, "2"))
                .map(Object::toString)
                .peek(System.out::println)
                .peek(System.out::println)
                .filter(s -> s.startsWith("2"))
                .forEach(System.out::println);
    }
}
