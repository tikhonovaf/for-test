package ru.tikhonovaf.samples.stream.common;

import lombok.Data;

import java.util.*;

public class StreamSeq {

    public static void main(String[] args) {

        //  Демонстрация последовавтельности выполнения операций в stream
        List<Room> rooms = new ArrayList<>();
        List<Person> personList1 = new ArrayList<>();
        personList1.add(new Person("Иван", 12));
        personList1.add(new Person("Петр", 14));
        personList1.add(new Person("Сергей", 15));
        rooms.add(new Room(2, personList1));

        List<Person> personList2 = new ArrayList<>();
        personList1.add(new Person("Михаил", 22));
        personList1.add(new Person("Игорь", 24));
        personList1.add(new Person("Артем", 25));
        rooms.add(new Room(2, personList2));

        Integer minAge = 14;
        var roomNum = rooms.stream()
                .filter(r -> r.getPersons().stream()
                        .anyMatch(person -> person.getAge() < minAge)
                )
                .map(Room::getNumber)
                .findFirst();

        System.out.println("map: " + roomNum);

        Set<String> set1 = new HashSet();

        final List<String> list = List.of("dog", "cat", "hamster");
        list.stream()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.length() <= 3;
                })
                .sorted()
                .map(s1 -> {
                    System.out.println("map: " + s1);
                    return s1.toUpperCase();
                })
//                .skip(1)
                .forEach(x -> {
                    System.out.println("forEach: " + x);
                });
    }

    @Data
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    @Data
    static class Room {
        private int number;
        private List<Person> persons;

        public Room(int number, List<Person> persons) {
            this.persons = persons;
            this.number = number;
        }
    }
}
