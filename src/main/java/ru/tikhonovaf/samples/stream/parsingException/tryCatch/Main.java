package ru.tikhonovaf.samples.stream.parsingException.tryCatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = readPeopleFromResource("data/people.txt");
        people.forEach(System.out::println);
    }

    static List<Person> readPeopleFromResource(String fileName) {
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            return reader.lines()
                    .map(line -> {
                        try {
                            return parsePerson(line);
                        } catch (ParseException e) {
                            System.err.println("Ошибка парсинга: " + line + " → " + e.getMessage());
                            return null;
                        }
                    })
                    .filter(p -> p != null)
                    .collect(Collectors.toList());

        } catch (IOException | NullPointerException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            return List.of();
        }
    }

    static Person parsePerson(String line) throws ParseException {
        String[] parts = line.split(",");
        if (parts.length != 2) throw new ParseException("Неверный формат строки", 0);

        String name = parts[0].trim();
        try {
            int age = Integer.parseInt(parts[1].trim());
            return new Person(name, age);
        } catch (NumberFormatException e) {
            throw new ParseException("Возраст не число: " + parts[1], 1);
        }
    }
}
