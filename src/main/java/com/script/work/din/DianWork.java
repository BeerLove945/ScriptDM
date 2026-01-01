package com.script.work.din;

import com.script.Point;
import com.script.PointRange;
import com.script.com.ComDM;
import com.script.control.Control;
import com.script.control.Key;
import com.script.util.WindowUtil;
import com.script.work.AbstractWork;

public class DianWork extends AbstractWork {
    Point gamePoint;
    @Override
    public void work() {
        ComDM window = Control.system();
        long l = window.GetForegroundWindow();
        gamePoint = WindowUtil.getWindowPoint(l).toPoint();
        System.out.println("find window success,start");
        while (true){
            leftClick();
            delay10_1(3000);
            waitEnd();
            delay10_1(200);
            press(Key.esc);
            delay10_1(100);
        }
    }
    private PointRange convert(Point point, PointRange range){
        return new PointRange(point.x+range.fx, point.y+range.fy, point.x+range.tx, point.y+range.ty);
    }
    private void waitForHunt() {
        Point p = findPic( 0,0,1024,300, "");
        while (p == null) {
            p = findPic( 0,0,1024,300, "");
            delay10_1(200);
        }
    }
    private void waitEnd() {
        Point p = findPic( 0,0,1024,300, "");
        while (p != null) {
            p = findPic( 0,0,1024,300, "");
            delay10_1(200);
        }
    }
}
