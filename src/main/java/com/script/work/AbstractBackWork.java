package com.script.work;

import com.script.com.*;
import com.script.control.Key;
import com.script.util.Delay;
import com.script.util.RandomConfig;

import java.util.logging.Logger;

public abstract class AbstractBackWork extends BaseWork {
    protected Logger logger = Logger.getLogger(this.getClass().getName());


    protected void move(ComDM com) {
        press(com,Key.right);
        delay10_1(30, 50);
        pressDown(com,Key.right);
    }

    /**
     * do the nomal work in this way
     */
    public abstract void work();

    /**
     * move the mouse to location
     *
     * @param xx
     * @param yy
     */
    protected final void moveToX(ComDM com, int xx, int yy) {
        com.MoveTo(xx, yy);
    }


    /**
     * move the mouse to location,by the dm obj.
     *
     * @param xx
     * @param yy
     */
    protected final void moveTo(ComDM com, int xx, int yy) {
        com.MoveTo(xx,yy);
    }

    /**
     * wait some time
     * example input 100,to sleep 100 - 110 millisecond
     * @param delay
     */
    protected final void delay10_1(long delay) {
        Delay.delay10_1((int) delay);
    }

    /**
     * wait some time
     * time is rounded by max param.
     * @param delay
     */
    protected final void delay10_1(long delay, long max) {
        delay10_1(RandomConfig.round((int) delay, (int) (max - delay)));
    }


    /**
     * press the key on keyboard by the dm obj.
     *
     * @param keyCode
     */
    public final void press(ComDM com, int keyCode) {
        com.KeyDown(keyCode);
        Delay.delay10_1(RandomConfig.round(50, 80));
        com.KeyUp(keyCode);
    }

    /**
     * press down the key by the param dm obj
     * @param com
     * @param keyCode
     */
    protected final void pressDown(ComDM com, int keyCode) {
        com.KeyDown(keyCode);
    }
    /**
     * press up the key by the param dm obj
     * @param com
     * @param keyCode
     */
    public final void pressUp(ComDM com, int keyCode) {
        com.KeyUp(keyCode);
    }

    /**
     * custom to press multi key
     *
     * @param keyCode
     */
    protected final void press(ComDM com, int... keyCode) {
        if (keyCode.length == 1) {
            press(com,keyCode[0]);
            return;
        }
        if (keyCode.length == 2){
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
     * left click by the param dm obj
     */
    protected final void leftClick(ComDM com) {
        com.LeftDown();
        Delay.normal();
        com.LeftUp();
    }

    /**
     * left click by the param dm obj,when after the position moved
     *
     * @param x
     * @param y
     */
    protected final void leftClick(ComDM com, int x, int y) {
        moveTo(com,x, y);
        Delay.normal();
        leftClick(com);
    }

    /**
     * right click by the param dm obj
     */
    protected final void rightClick(ComDM com) {
        com.RightDown();
        Delay.normal();
        com.RightUp();
    }

    /**
     * right click by the param dm obj,when after the position moved
     *
     * @param x
     * @param y
     */
    protected final void rightClick(ComDM com, int x, int y) {
        moveTo(com,x, y);
        Delay.normal();
        rightClick(com);
    }

}
