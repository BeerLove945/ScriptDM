package com.script;

import java.util.Objects;

/**
 * location x,y
 */
public class Point {
    public int x, y;
    public int index;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y;
    }
}
