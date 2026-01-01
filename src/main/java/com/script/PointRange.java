package com.script;

import java.util.Objects;

/**
 * location range
 */
public class PointRange {
    public int fx,fy,tx,ty;
    public PointRange() {}
    public PointRange(int fx, int fy, int tx, int ty) {
        this.fx = fx;
        this.fy = fy;
        this.tx = tx;
        this.ty = ty;
    }
    public static PointRange full = new PointRange(0,0,1900,900);

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PointRange)) return false;
        PointRange range = (PointRange) o;
        return fx == range.fx && fy == range.fy && tx == range.tx && ty == range.ty;
    }
public Point toPoint(){
        return new Point(fx,fy);
}
    @Override
    public int hashCode() {
        return Objects.hash(fx, fy, tx, ty);
    }

    @Override
    public String toString() {
        return "{" +
                "fx=" + fx +
                ", fy=" + fy +
                ", tx=" + tx +
                ", ty=" + ty +
                '}';
    }
}
