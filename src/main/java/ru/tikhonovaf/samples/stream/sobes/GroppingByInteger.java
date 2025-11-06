package ru.tikhonovaf.samples.stream.sobes;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroppingByInteger {
    public static void main(String[] args) throws Exception {

        var res =
                Arrays.asList(1, 1, 2, 2, 4, 2, 2,  7, 1, 8, 7, 2)
                        .stream()
//                        .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByValue()) // Optional<Map.Entry<Integer, Foo>>
                        .orElseThrow()
                        .getKey();
//        System.out.println(res.getKey() + "  " + res.getValue());
        System.out.println(res);
    }
}
