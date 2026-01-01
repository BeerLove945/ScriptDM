package com.script.util;

import com.script.Point;

import java.util.Random;

public final class RandomConfig {
    public static int round(int min, int step) {
        if (step <= 0)
            step = 1;
        return new Random().nextInt(step) + min;
    }

    public static int minMax(int a, int b) {
        return new Random().nextInt(b - a)+a;
    }

    /**
     *
     * @param p
     * @param x
     * @param y
     * @return
     */
    public static Point round(Point p,int x,int y){
        return new Point(round(p.x,x),round(p.y,y),p.index);
    }
}
