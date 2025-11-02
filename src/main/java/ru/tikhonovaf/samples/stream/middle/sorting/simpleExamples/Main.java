package main.java.ru.tikhonovaf.samples.stream.middle.sorting.simpleExamples;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //  Пример 1: Сортировка строк по алфавиту
        List<String> names = List.of("Charlie", "Alice", "Bob");
        List<String> sortedNames = names.stream()
                .sorted()
                .toList();
        System.out.println(sortedNames);

        // Пример 2: Сортировка чисел по убыванию
        List<Integer> numbers = List.of(5, 2, 9, 1);

        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(sortedDesc);

        // Пример 3: Сортировка объектов по полю
        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("Bob", 45)
        );

        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .toList();

        System.out.println("sortedByAge");
        sortedByAge.forEach(System.out::println);

        //  Пример 4: Сортировка по нескольким критериям
        List<Person> sortedByNameThenAge = people.stream()
                .sorted(Comparator.comparing((Person::getName))
                        .thenComparingInt(Person::getAge))
                .toList();
        System.out.println("sortedByNameThenAge");
        sortedByNameThenAge.forEach(System.out::println);

    }
}
