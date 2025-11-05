package ru.tikhonovaf.samples.stream.terminal.collectors.simplegrouping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(of = "name")
class Student {
    private String name;
    private String group;

    public Student(String name, String group) {
        this.name = name;
        this.group = group;
    }
}