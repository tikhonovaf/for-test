package ru.tikhonovaf.samples.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

interface Node {
    void display();
}

class FileNode implements Node {
    private final String name;
    public FileNode(String name) { this.name = name; }
    public void display() { System.out.println("File: " + name); }
}

class FolderNode implements Node {
    private final String name;
    private final List<Node> children = new ArrayList<>();

    public FolderNode(String name) { this.name = name; }

    public void add(Node node) { children.add(node); }

    public void display() {
        System.out.println("Folder: " + name);
        for (Node n : children) n.display();
    }
}

public class CompositeDemo {
    public static void main(String[] args) {
        FolderNode root = new FolderNode("root");
        root.add(new FileNode("file1.txt"));
        root.add(new FileNode("file2.txt"));

        FolderNode sub = new FolderNode("subfolder");
        sub.add(new FileNode("inner.txt"));

        root.add(sub);

        root.display();
    }
}
