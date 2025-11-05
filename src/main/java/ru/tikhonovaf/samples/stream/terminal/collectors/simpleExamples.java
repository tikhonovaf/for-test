package ru.tikhonovaf.samples.stream.terminal.collectors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class simpleExamples {
    public static void main(String[] args) {

        //  1. toList() — собрать в список
        List<String> names = List.of("Alice", "Bob", "Charlie");

        List<String> result = names.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());  // мутабельный
            //  .toList()   //  иммутабельный
        // [Alice, Charlie]


        //  2. toSet() — собрать в множество (уникальные элементы)

        List<String> fruits = List.of("apple", "banana", "apple", "cherry");

        Set<String> uniqueFruits = fruits.stream()
                .collect(Collectors.toSet());
        // [apple, banana, cherry]

        // 3. toMap()
        List<String> words = List.of("one", "two", "three");

        Map<String, Integer> wordLengths = words.stream()
                .collect(Collectors.toMap(
                        word -> word,
                        word -> word.length()
                ));
        // {one=3, two=3, three=5}

        // 4. joining() — объединить строки
        List<String> items = List.of("pen", "pencil", "eraser");

        String joined = items.stream()
                .collect(Collectors.joining(", "));
        // "pen, pencil, eraser"

        // Можно указать префикс и суффикс:

        String fancyJoin = items.stream()
                .collect(Collectors.joining(", ", "[", "]"));
        // "[pen, pencil, eraser]"

        // 5. groupingBy() — сгруппировать по ключу
        List<String> namesGrp = List.of("Anna", "Bob", "Alice", "Brian");

        Map<Character, List<String>> grouped = namesGrp.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        // {A=[Anna, Alice], B=[Bob, Brian]}

        // 6/ partitioningBy() — разделить на две группы по условию
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        // {false=[1, 3, 5], true=[2, 4, 6]}



    }
}
