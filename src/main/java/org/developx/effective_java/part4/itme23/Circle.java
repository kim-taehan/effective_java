package org.developx.effective_java.part4.itme23;

public class Circle implements Figure {

    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius;
    }
}
