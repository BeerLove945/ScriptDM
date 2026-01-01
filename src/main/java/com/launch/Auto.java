package com.launch;

import com.script.control.Control;
import com.script.util.SystemConfig;
import com.script.work.auto.ZidongWork;

public class Auto {
    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("-" + SystemConfig.lastPic);
            if (e != null)
                e.printStackTrace();
        });
        //install the dm plugin and initialized
        Control.install();
        //do your work
        new ZidongWork().work();
        System.exit(0);
    }
}
