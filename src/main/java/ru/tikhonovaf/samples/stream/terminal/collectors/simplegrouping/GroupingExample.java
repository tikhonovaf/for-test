package ru.tikhonovaf.samples.stream.terminal.collectors.simplegrouping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Аня", "A"),
                new Student("Борис", "B"),
                new Student("Вика", "A"),
                new Student("Глеб", "C"),
                new Student("Даша", "B")
        );

        Map<String, List<Student>> grouped = students.stream()
                .collect(Collectors.groupingBy(Student::getGroup));

        grouped.forEach((group, list) -> {
            System.out.println("Группа " + group + ": " + list);
        });
    }
}