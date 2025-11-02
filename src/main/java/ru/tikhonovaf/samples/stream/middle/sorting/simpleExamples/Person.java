package main.java.ru.tikhonovaf.samples.stream.middle.sorting.simpleExamples;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Person {
    String name;
    int age;

    @Override
    public String toString() {
        return name + " — " + age + " лет";
    }
}
