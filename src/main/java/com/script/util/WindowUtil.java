package com.script.util;

import com.script.Point;
import com.script.PointRange;
import com.script.com.ComDM;
import com.script.control.Control;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.ptr.IntByReference;

public class WindowUtil {
    public static void moveWindow(long wid,Point p){
        //move the window to p location
        System.out.println("move the window location");
        PointRange windowPoint = getWindowPoint(wid);
        if (windowPoint.fx != p.x || windowPoint.fy != p.y)
            Control.system().MoveWindow(wid, p.x, p.y);
        long processId = Control.system().GetWindowProcessId(wid);
    }

    /**
     * get the foreground window as an obj.
     * @return the code for this window,you can understand this for a tag?
     */
    public static long getWindow(){
        ComDM window = Control.system();
        return window.GetForegroundWindow();
    }

    /**
     * get the window where it's location in screen
     * @param jb
     * @return the window location,from x to x,from y to y
     */
    public static PointRange getWindowPoint(Long jb) {

        ComDM window = Control.system();
        Variant.VARIANT fx = new Variant.VARIANT(new IntByReference());
        Variant.VARIANT fy = new Variant.VARIANT(new IntByReference());
        Variant.VARIANT tx = new Variant.VARIANT(new IntByReference());
        Variant.VARIANT ty = new Variant.VARIANT(new IntByReference());
        window.GetWindowRect(jb, fx, fy, tx, ty);
        return new PointRange(fx.intValue(),fy.intValue(),tx.intValue(),ty.intValue());
    }
}
