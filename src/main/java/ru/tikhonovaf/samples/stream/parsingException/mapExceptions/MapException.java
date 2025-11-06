package ru.tikhonovaf.samples.stream.parsingException.mapExceptions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapException {

    public static void main(String[] args) {
        //  IllegalStateException
        // Причина: Если в потоке встречаются дубликаты ключей, а вы не указали функцию объединения (merge function),
        // Java не знает, какое значение сохранить.

        List<String> words = List.of("apple", "banana", "apple");

        Map<String, Integer> map = words.stream()
                .collect(Collectors.toMap(
                        word -> word,
                        word -> 1,
                        // нет merge-функции!
                        (e1, e2) -> e1
                         ));

        // NullPointerException

    }
}
