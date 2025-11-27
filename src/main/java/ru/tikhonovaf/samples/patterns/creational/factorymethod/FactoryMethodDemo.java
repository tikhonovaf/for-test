package ru.tikhonovaf.samples.patterns.creational.factorymethod;

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

abstract class ShapeFactory {
    abstract Shape createShape();
}

class CircleFactory extends ShapeFactory {
    Shape createShape() {
        return new Circle();
    }
}

class RectangleFactory extends ShapeFactory {
    Shape createShape() {
        return new Rectangle();
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        ShapeFactory rectangleFactory = new RectangleFactory();

        Shape circle = circleFactory.createShape();
        Shape rectangle = rectangleFactory.createShape();

        circle.draw();
        rectangle.draw();
    }
}
