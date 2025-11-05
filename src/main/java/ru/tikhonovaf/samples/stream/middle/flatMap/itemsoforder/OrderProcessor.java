package ru.tikhonovaf.samples.stream.middle.flatMap.itemsoforder;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.util.Map;
import java.util.Comparator;

public class OrderProcessor {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(List.of(new Product("Apple", 3), new Product("Banana", 2))),
                new Order(List.of(new Product("Apple", 1), new Product("Orange", 5))),
                new Order(List.of(new Product("Banana", 4), new Product("Orange", 1)))
        );

        Map<String, Integer> productTotals = orders.stream()
                .flatMap(order -> order.products.stream())
                .collect(Collectors.groupingBy(
                        product -> product.name,
                        Collectors.summingInt(product -> product.quantity)
                ));

        // Сортировка: по убыванию количества, затем по имени в обратном алфавитном порядке
        LinkedHashMap<String, Integer> sorted = productTotals.entrySet().stream()
                .sorted(
                        //  используем Comparator.comparing
//                        Comparator.<Map.Entry<String, Integer>, Integer>comparing(Map.Entry::getValue, Comparator.reverseOrder())
                        //  используем Entry.comparingByValue
                      Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                                .thenComparing(Map.Entry::getKey, Comparator.reverseOrder())
                )
                .collect(Collectors.toMap(
                        Entry::getKey,
                        Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        // Вывод результата
        sorted.forEach((name, total) ->
                System.out.println(name + ": " + total)
        );
    }
}
