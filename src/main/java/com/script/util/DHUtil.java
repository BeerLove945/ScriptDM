package com.script.util;

import com.script.Point;
import com.script.PointRange;
import com.script.control.Key;
import com.script.work.AbstractWork;

public class DHUtil extends AbstractWork {
    public final static DHUtil D = new DHUtil();

    @Override
    public void work() {

    }

    public void bu77(Point gamePoint) {

    }

    public Point openBox(Point gamePoint) {
        return gamePoint;
    }

    private PointRange convert(Point point, PointRange range) {
        return new PointRange(point.x + range.fx, point.y + range.fy, point.x + range.tx, point.y + range.ty);
    }
}
