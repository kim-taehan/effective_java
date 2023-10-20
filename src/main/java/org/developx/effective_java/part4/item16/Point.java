package org.developx.effective_java.part4.item16;

import java.awt.*;

public class Point {

    private final double x;
    private final double y;
    private final CustomColor customColor;
    public Point(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.customColor = new CustomColor(color);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color getColor() {
        return this.customColor.color;
    }
    private static class CustomColor{
        public Color color;

        public CustomColor(Color color) {
            this.color = color;
        }
    }
}
