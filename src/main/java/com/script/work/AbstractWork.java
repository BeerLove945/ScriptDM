package com.script.work;

import com.script.Point;
import com.script.com.*;
import com.script.control.Control;
import com.script.util.Delay;
import com.script.util.RandomConfig;
import com.script.util.SystemConfig;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.ptr.IntByReference;

import java.util.Arrays;
import java.util.logging.Logger;

public abstract class AbstractWork {
    protected Logger logger = Logger.getLogger(this.getClass().getName());
    protected ComDM ocr;
    protected ComDM mouse;
    protected ComDM keyBoard;
    protected ComDM window;
    protected ComDM system;
    protected ComDM dict;
    public static int[] mouseConfig = new int[6];
    {
        this.ocr = Control.system();
        this.ocr.SetPath(SystemConfig.picPath);
        this.mouse = Control.system();
        this.keyBoard = Control.system();
        this.window = Control.system();
        this.system = Control.system();
        this.dict = Control.system();
//        this.dict.SetPath(SystemConfig.dictPath);
    }

    /**
     * launch the normal work
     */
    public abstract void work();

    /**
     * get the mouse position in window or screen.
     * choice by if you bind the window by dm obj
     *
     * @return
     */
    protected final Point getPosition() {
        Variant.VARIANT x = new Variant.VARIANT(new IntByReference());
        Variant.VARIANT y = new Variant.VARIANT(new IntByReference());
        long l = mouse.GetCursorPos(x, y);
        return new Point(x.intValue(), y.intValue());
    }

    /**
     * move to
     *
     * @param xx
     * @param yy
     */
    public final void moveTo(int xx, int yy) {
//        mouse.MoveTo(xx,yy);
//        mouse.EnableRealMouse(RandomConfig.round(mouseConfig[0],mouseConfig[1]),RandomConfig.round(mouseConfig[2],mouseConfig[3]), RandomConfig.round(mouseConfig[4],mouseConfig[5]));
//        mouse.MoveTo(xx,yy);
        DmMouseSimulator.simulator.realMove(xx, yy);
    }

    /**
     * move to by the param dm obj
     * @param com
     * @param xx
     * @param yy
     */
    public final void moveTo(ComDM com,int xx, int yy) {
//        com.MoveTo(xx,yy);
//        com.EnableRealMouse(RandomConfig.round(mouseConfig[0],mouseConfig[1]),RandomConfig.round(mouseConfig[2],mouseConfig[3]), RandomConfig.round(mouseConfig[4],mouseConfig[5]));
//        com.MoveTo(xx,yy);
        //this file coded by GPT,please implement it your self,or yor AI
        DmMouseSimulator.simulator.realMove(com,xx, yy);
    }

    /**
     * wait for
     *
     * @param delay
     */
    protected final void delay10_1(long delay) {
        Delay.delay10_1((int) delay);
    }

    /**
     * wait for
     *
     * @param delay
     */
    protected final void delay10_1(long delay, long max) {
        delay10_1(RandomConfig.round((int) delay, (int) (max - delay)));
    }

    protected final void delay() {
        delay10_1(SystemConfig.delay);
    }

    /**
     * press key
     *
     * @param keyCode
     */
    public final void press(int keyCode) {
        press(keyBoard,keyCode);
    }
    public final void press(ComDM com,int keyCode) {
        com.KeyDown(keyCode);
        Delay.delay10_1(RandomConfig.round(50, 80));
        com.KeyUp(keyCode);
    }

    protected final void pressDown(int keyCode) {
        pressDown(keyBoard,keyCode);
    }
    protected final void pressDown(ComDM com,int keyCode) {
        com.KeyDown(keyCode);
    }

    public final void pressUp(int keyCode) {
        pressUp(keyBoard,keyCode);
    }
    public final void pressUp(ComDM com,int keyCode) {
        com.KeyUp(keyCode);
    }

    /**
     * press multi key
     *
     * @param keyCode
     */
    protected final void press(int... keyCode) {
        press(keyBoard,keyCode);
    }
    protected final void press(ComDM com,int... keyCode) {
        if (keyCode.length == 1) {
            press(com,keyCode[0]);
            return;
        }
        if (keyCode.length == 2) {
            pressDown(com,keyCode[0]);
            delay10_1(200);
            press(com,keyCode[1]);
            delay10_1(200);
            pressUp(com,keyCode[0]);
            return;
        }
        for (int i = 0; i < keyCode.length; i++) {
            com.KeyDown(keyCode[i]);
            Delay.normal();
        }
        for (int length = keyCode.length; length > 0; length--) {
            Delay.normal();
            com.KeyUp(keyCode[length - 1]);
        }
    }

    /**
     */
    protected final void leftClick(ComDM com) {
        com.LeftDown();
        Delay.normal();
        com.LeftUp();
    }
    protected final void leftClick() {
        leftClick(mouse);
    }

    /**
     *
     * @param x
     * @param y
     */
    public final void leftClick(int x, int y) {
        moveTo(x, y);
        Delay.normal();
        leftClick();
    }

    public final void leftClick(ComDM com,int x, int y) {
        moveTo(com,x, y);
        Delay.normal();
        leftClick(com);
    }

    /**
     *
     */
    protected final void rightClick() {
        mouse.RightDown();
        Delay.normal();
        mouse.RightUp();
    }

    /**
     *
     * @param x
     * @param y
     */
    protected final void rightClick(int x, int y) {
        moveTo(x, y);
        Delay.normal();
        rightClick();
    }

    /**
     *
     * @param fx
     * @param fy
     * @param tx
     * @param ty
     * @param pic
     * @return
     */
    public final Point findPic(int fx, int fy, int tx, int ty, String pic) {
        return findPic(ocr, fx, fy, tx, ty, pic);
    }

    Point[] ps = new Point[1000];

    public final Point[] findPicEX(int fx, int fy, int tx, int ty, String pic) {
        return findPicEX(ocr, fx, fy, tx, ty, pic);

    }

    public final Point[] findPicEX(ComDM com, int fx, int fy, int tx, int ty, String pic) {
        SystemConfig.lastPic = pic;
        int ffy = fy;
        if (ffy <= 0)
            ffy = 0;
        if (fx <= 0)
            fx = 0;
//        long l = ocr.AiFindPic(fx, ffy, tx, ty, pic, 0.9, 0, x, y);
        delay10_1(10);
        Arrays.fill(ps, null);
        String picF = com.FindPicEx(fx, ffy, tx, ty, pic, SystemConfig.delta_color, SystemConfig.findSim, 0);
//        if (picF != null && !picF.isEmpty())
//            System.out.println(picF);
        if (picF == null || picF.trim().isEmpty() || !picF.contains(","))
            return null;
        if (picF.contains("|")) {
            String[] split = picF.split("\\|");
            for (int i = 0; i < split.length; i++) {
                ps[i] = new Point(Integer.parseInt(split[i].split(",")[1]), Integer.parseInt(split[i].split(",")[2]));
                ps[i].index = Integer.parseInt(split[i].split(",")[0]);
                if (ps[i].x <= 0 || ps[i].y <= 0)
                    ps[i] = null;
            }
        } else {
            String[] split = picF.split(",");
            ps[0] = new Point(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[0]));
            if (ps[0].x <= 0 || ps[0].y <= 0)
                return  null;
        }
        return ps;
    }

    protected final Point findPic(ComDM com, int fx, int fy, int tx, int ty, String pic) {
        Variant.VARIANT x = new Variant.VARIANT(new IntByReference());
        Variant.VARIANT y = new Variant.VARIANT(new IntByReference());
        SystemConfig.lastPic = pic;
        int ffy = fy;
        if (ffy <= 0)
            ffy = 0;
//        long l = ocr.AiFindPic(fx, ffy, tx, ty, pic, 0.9, 0, x, y);
        delay10_1(10);
        long l = com.FindPic(fx, ffy, tx, ty, pic, SystemConfig.delta_color, SystemConfig.findSim, 0, x, y);
        if (l < 0 || x.getValue() == null || y.getValue() == null || x.intValue() <= 0 || y.intValue() <= 0) {
            return null;
        }
        if (point == null)
            point = new Point(x.intValue(), y.intValue(), (int) l);
        else {
            point.x = x.intValue();
            point.y = y.intValue();
            point.index = (int) l;
        }
        return point;
    }

    Point point = null;
}
