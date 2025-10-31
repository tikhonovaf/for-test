package main.java.ru.tikhonovaf.samples.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        //📚 1. Из коллекций
        //    Самый распространённый способ — через Collection.stream():
        List<String> list = List.of("Java", "Stream", "API");
        Stream<String> stream = list.stream();

        List<String> result = stream
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .toList();

        //🔢 2. Из массивов
        //    С помощью Arrays.stream():
        int[] numbers = {1, 2, 3};
        IntStream intStream = Arrays.stream(numbers);

        List<Integer> intList = intStream
                .filter(i -> i % 2 == 0)
                .boxed().toList();


        //    Для объектов:
        String[] words = {"hello", "world"};
        Stream<String> wordStream = Arrays.stream(words);


        //🧪 3. Через Stream.of()
        //    Создание потока из фиксированного набора элементов:
        Stream<String> streamStr = Stream.of("Java", "Python", "Kotlin");


        //🔁 4. Через Stream.generate()
        //    Создание бесконечного потока:
        Stream<Double> randoms = Stream.generate(Math::random).limit(5);


        //🔄 5. Через Stream.iterate()
        //    Генерация последовательности:
        Stream<Integer> evenNumbers = Stream.iterate(0, n -> n + 2).limit(10);


        //📄 6. Из файла
        //    С помощью Files.lines():

        try (Stream<String> lines = Files.lines(Paths.get("data.txt"))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    //🧬7.  Из строки (через регулярное выражение)
    //  Разделение строки  на слова:
        Stream<String> patWords = Pattern.compile("\\s+").splitAsStream("Java Stream API");


    // 🧠8. Из Builder для динамического построения:
        Stream.Builder<String> builder = Stream.builder();
        builder.add("Java").
                add("Stream").
                add("Builder");
        Stream<String> builderStream = builder.build();

    }
}