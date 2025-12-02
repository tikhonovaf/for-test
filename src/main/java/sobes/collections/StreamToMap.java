package sobes.collections;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamToMap {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("one", "two", "three", "four", "five");

        Map<Integer, String > size2Str = list.stream()
                .collect(Collectors.toMap(String::length, Function.identity(),
                        (a, b) -> b));
        System.out.println(size2Str.size());

    }
}
