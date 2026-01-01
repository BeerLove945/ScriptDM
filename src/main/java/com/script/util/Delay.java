package com.script.util;


import com.script.control.Control;

public final class Delay {
    public static void delay(long delay) {
        try {
            if (delay > 1) {
                Thread.sleep(delay);
            }
            while (Thread.currentThread() == Control.mainThread && Control.waiting){
                delay(1000);
            }
            if (Thread.currentThread() == Control.mainThread && Control.exit){
                Control.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void delay(int min, int step) {
        if (min <= 0)
            return;
        int round = RandomConfig.round(min, step);
        delay(round);
    }

    public static void delay10_1(int delay) {
        delay(delay, delay / 10);
    }

    public static void delay20_1(int delay) {
        delay(delay, delay / 20);
    }

    public static void normal() {
        delay10_1(RandomConfig.round(SystemConfig.delay-50,150));
    }
}
