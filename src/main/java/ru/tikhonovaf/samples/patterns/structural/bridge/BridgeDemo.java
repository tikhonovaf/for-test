package ru.tikhonovaf.samples.patterns.structural.bridge;

interface Renderer {
    void renderCircle(float radius);
}

class VectorRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing vector circle radius " + radius);
    }
}

class RasterRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing raster circle radius " + radius);
    }
}

abstract class Shape {
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    abstract void draw();
}

class Circle extends Shape {
    private float radius;

    public Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    void draw() {
        renderer.renderCircle(radius);
    }
}

public class BridgeDemo {
    public static void main(String[] args) {
        Shape circle1 = new Circle(new VectorRenderer(), 5);
        Shape circle2 = new Circle(new RasterRenderer(), 5);

        circle1.draw();
        circle2.draw();
    }
}
