package ru.tikhonovaf.samples.stream.terminal.reduce;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        // Пример 1: Сумма чисел
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                .reduce(0, Integer::sum); // 15
        //  0 — начальное значение (identity)
        //  Integer::sum — функция объединения

        // ✖️ Пример 2: Произведение чисел
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b); // 120

        // 🔗 Пример 3: Конкатенация строк
        List<String> words = List.of("Java", "Stream", "API");
        String result = words.stream()
                .reduce("", (a, b) -> a + " " + b);

        // 🧮 Пример 4: Поиск максимального значения
        Optional<Integer> max = numbers.stream()
                .reduce(Integer::max);
        // Optional[5]

        // 📦 Пример 5: Без начального значения
        // Если не указать identity, результат будет Optional<T>:

        Optional<Integer> sumOpt = numbers.stream()
                .reduce((a, b) -> a + b);
        // Optional[15]

        // 🧠 Пример 6: Подсчёт длины всех слов
        List<String> names = List.of("Alice", "Bob", "Charlie");

        int totalLength = names.stream()
                .map(String::length)
                .reduce(0, Integer::sum); // 16    }

    }
}
