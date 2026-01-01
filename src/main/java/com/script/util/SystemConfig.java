package com.script.util;

import cn.hutool.core.io.FileUtil;

public final class SystemConfig {
    public static String path ;
    public static String picPath ;
    public static String aiPath = FileUtil.getAbsolutePath("dm/ai")+"/ai.module";
    public static String dictPath = FileUtil.getAbsolutePath("dm/dict");
    /**
     * the sim for global find pic or dict,or some Graphic
     */
    public static final double findSim = 0.9;
    /**
     * the sim color for global find pic and color or dict
     */
    public static final String delta_color = "111111";

    static {
       dictPath = path + "/dict";
       picPath = path + "/global";
       aiPath = path + "/dm/ai";
    }
    /**
     * every step,need the time to load and run native.
     * in dm plugin,we need the time to delay,after every called the plugin method
     */
    public static int delay = 100;

    public static String lastPic;
}
