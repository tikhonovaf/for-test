package ru.tikhonovaf.samples.stream.parsingException.wrapCheckedFunction;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<String> dates = List.of("2025-11-06", "invalid", "2024-12-31");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<java.util.Date> parsedDates = dates.stream()
                .map(CheckedWrapper.wrapCheckedFunction(sdf::parse)) // Optional<Date>
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        parsedDates.forEach(System.out::println);
    }
}
