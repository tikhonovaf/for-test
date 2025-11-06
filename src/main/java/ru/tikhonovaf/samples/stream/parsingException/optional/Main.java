package ru.tikhonovaf.samples.stream.parsingException.optional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        List<String> dateStrings = List.of("2025-11-06", "invalid-date", "2024-12-31");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<java.util.Date> parsedDates = dateStrings.stream()
                .map(dateStr -> parseDateSafely(dateStr, sdf))   // Optional<Date>
                .filter(Optional::isPresent)                           // отфильтровываем пустые
                .map(Optional::get)                                    // извлекаем значение
                .collect(Collectors.toList());

        parsedDates.forEach(System.out::println);
    }

    private static Optional<Date> parseDateSafely(String dateStr, SimpleDateFormat sdf) {
        try {
            return Optional.of(sdf.parse(dateStr));
        } catch (ParseException e) {
            return Optional.empty(); // безопасно игнорируем ошибку
        }
    }
}
