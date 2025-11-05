package ru.tikhonovaf.samples.stream.terminal.iteration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
      // 1. forEach(Consumer)
        List<String> names = List.of("Alice", "Bob", "Charlie");

        names.stream()
                .forEach(name -> System.out.println(name.toUpperCase()));
        names.stream()
                .forEach(System.out::println);
        names.parallelStream()
                .forEach(name -> System.out.println(name.toUpperCase()));

        //  forEachOrdered(Consumer)
        names.parallelStream()
                .forEachOrdered(name -> System.out.println(name.toUpperCase()));

    }

}
