package com.script.control;

import cn.hutool.core.lang.Console;
import com.script.com.*;
import com.script.DmRegHandler;
import com.script.config.PluginConfig;
import com.script.util.Delay;
import com.script.util.SystemConfig;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.COM.util.ObjectFactory;
import com.sun.jna.platform.win32.Ole32;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Control {

    static ObjectFactory objectFactory;
    private static Scanner scanner;
    private static ComDM ComDM;
    static List<ComDM> ComDMs = new ArrayList<>();
    public static Thread mainThread = Thread.currentThread();
    public static volatile boolean waiting;
    public static volatile boolean exit;
    public static void install() {
        int exec = DmRegHandler.exec();
        if (exec != 1) {
            Console.log("register failed！");
            throw new RuntimeException("register failed");
        }
        Ole32.INSTANCE.CoInitializeEx(Pointer.NULL, Ole32.COINIT_MULTITHREADED + Ole32.COINIT_SPEED_OVER_MEMORY);
        objectFactory = new ObjectFactory();
        ComDM dm = system();
        dm.ReleaseRef();
        try {
            long reg = dm.Reg(PluginConfig.code_dm, PluginConfig.code_info_dm);
            System.out.println("register code --》" + reg);

        } catch (Exception e) {
            System.out.println(dm.GetLastError());
        }

        Console.log(dm.Ver());
        Console.log("PATH:{}", SystemConfig.path);
        Console.log("Path:{}", dm.GetPath());
        dm.InitCri();
        dm.SpeedNormalGraphic(1);
        dm.SetPath(SystemConfig.picPath);
        dm.LoadAi(SystemConfig.aiPath);
        dm.SetSimMode(1);
        dm.SetFindPicMultithreadCount(2);
        System.out.println(KeyEvent.getKeyText(Key.n_));
        new Thread(() -> {
            ComDM keyBord = nSystem();
            long l = keyBord.WaitKey(Key.n_, 0);
            System.out.println(l);
            if (l != 0) {
                exit = true;
            }
        }).start();
        new Thread(() -> {
            ComDM keyBord = nSystem();
            while (true) {
                long l = keyBord.WaitKey(Key.sn5, 0);
                if (l != 0)
                        waiting = true;
            }
        }).start();
        new Thread(() -> {
            ComDM keyBord = nSystem();
            while (true) {
                long l = keyBord.WaitKey(Key.sn6, 0);
                if (l != 0)
                        waiting = false;
            }
        }).start();
        System.out.println("2 second after to go");
        int i = 0;
        while (i++ < 2) {
            Delay.delay(1000);
        }
    }

    /**
     * this way maybe something wrong hear,
     * because when I call it,I must to restart the window,I don't know now.
     */
    public static void release() {
        for (ComDM forground : ComDMs) {
            forground.UnBindWindow();
        }
        objectFactory.disposeAll();
        System.exit(0);
    }

    public static ComDM system() {
        if (ComDM == null) {
            ComDM = objectFactory.createObject(ComDM.class);
            ComDMs.add(ComDM);
        }
        return ComDM;
    }

    public static ComDM nSystem() {
        ComDM object = objectFactory.createObject(ComDM.class);
        ComDMs.add(object);
        return object;
    }

    /**
     * used for some way,need to input word to control this script sys.
     * write code by your idea
     * @return
     */
    public static Scanner scanner() {
        if (scanner == null) scanner = new Scanner(System.in);
        return scanner;
    }
}
