package ru.tikhonovaf.samples.patterns.creational.prototype;

class Sheep implements Cloneable {
    private String name;

    public Sheep(String name) { this.name = name; }

    public Sheep clone() {
        try {
            return (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Sheep original = new Sheep("Dolly");
        Sheep copy = original.clone();

        System.out.println(original == copy); // false
        System.out.println(copy.name);
    }
}
