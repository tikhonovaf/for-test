package ru.tikhonovaf.samples.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

class TreeType {
    public final String name;
    public final String color;

    public TreeType(String name, String color) {
        this.name = name;
        this.color = color;
    }
}

class TreeTypeFactory {
    private static final Map<String, TreeType> cache = new HashMap<>();

    public static TreeType get(String name, String color) {
        String key = name + color;
        return cache.computeIfAbsent(key, k -> new TreeType(name, color));
    }
}

class Tree {
    private final int x, y;
    final TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        System.out.println("Tree " + type.name + " at " + x + "," + y);
    }
}

public class FlyweightDemo {
    public static void main(String[] args) {
        Tree tree1 = new Tree(1, 2, TreeTypeFactory.get("Oak", "Green"));
        Tree tree2 = new Tree(3, 4, TreeTypeFactory.get("Oak", "Green"));

        System.out.println(tree1.type == tree2.type); // true
    }
}
