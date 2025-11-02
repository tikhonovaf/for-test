package main.java.ru.tikhonovaf.samples.stream.middle.sorting.usingComparatorAndCollectors;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<CompetitionResult> competitionResults = List.of(
                new CompetitionResult("Alice", 12.5),
                new CompetitionResult("Bob", 11.8),
                new CompetitionResult("Charlie", 11.9),
                new CompetitionResult("Diana", 10.9),
                new CompetitionResult("Eve", 12.0)
        );

        Map<String, Double> top3Sorted = competitionResults.stream()
                .sorted(
                        Comparator.comparingDouble(CompetitionResult::getTime) // по времени
                                .thenComparing(CompetitionResult::getName)    // если время одинаковое — по имени
                )
                .limit(3)
                .collect(Collectors.toMap(
                        CompetitionResult::getName,     //  key
                        CompetitionResult::getTime,     //  value
                        (e1, e2) -> e1,    // Когда в потоке встречаются дубликаты ключей,
                                                         // Java должна решить, какое значение сохранить.
                                                         //   (e1, e2) -> e1 говорит: оставь первое значение, игнорируй второе.
                        LinkedHashMap::new               // Создаёт новый LinkedHashMap
                ));

        top3Sorted.forEach((name, time) ->
                System.out.println(name + " - " + time + " сек"));

    }
}
