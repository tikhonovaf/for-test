package ru.tikhonovaf.samples.stream.terminal.agregated;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // count()
        List<String> names = List.of("Alice", "Bob", "Charlie");
        long count = names.stream()
                .filter(name -> name.length() > 3)
                .count(); // 2

        // min() и max()
        List<Integer> numbers = List.of(5, 2, 9, 1, 7);

        int min = numbers.stream()
                .min(Integer::compareTo)
                .orElseThrow(); // 1

        int max = numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(); // 9

        //  findFirst() и findAny()
        List<String> items = List.of("apple", "banana", "cherry");

        Optional<String> first = items.stream()
                .filter(s -> s.startsWith("b"))
                .findFirst(); // banana

        Optional<String> any = items.stream()
                .filter(s -> s.length() > 5)
                .findAny(); // может быть banana или cherry

        //  anyMatch(), allMatch(), noneMatch()

        List<Integer> nums = List.of(3, 5, 7, 9);

        boolean anyEven = nums.stream().anyMatch(n -> n % 2 == 0); // false
        boolean allOdd = nums.stream().allMatch(n -> n % 2 != 0);  // true
        boolean noneNegative = nums.stream().noneMatch(n -> n < 0); // true

    }
}
