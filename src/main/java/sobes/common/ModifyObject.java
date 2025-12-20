package sobes.common;

import java.util.function.Function;

class Person {
    String name;
}

public class ModifyObject {
    static void modify(Person obj) {
        obj.name = "Rahul";
        obj = new Person();
        obj.name = "Amit";
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Sumit";

        modify(p);

        System.out.println(p.name);
    }
}
