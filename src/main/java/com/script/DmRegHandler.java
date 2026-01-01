package com.script;

import com.sun.jna.Library;
import com.sun.jna.Native;

public final class DmRegHandler {
    /**
     * jna to register dm.dll
     */
    private interface DmReg extends Library {
        DmReg INSTANCE = Native.load("DmReg.dll", DmReg.class);
        /**
         * SetDllPathA  0 sta 1 mta
         */
        int SetDllPathA(String format, int args);
        /**
         * SetDllPathW  0 sta 1 mta
         */
        void SetDllPathW(String format, int args);
    }
    /**
     * simple box to launch
     */
    public static int exec() {
        return new DmRegHandler().handler();
    }

    /**
     * if u need it,delete the /
     * @return
     */
    public int handler() {
        //get the dm.dll file absolute path。
//        String absolutePath = FileUtil.getAbsolutePath("dm.dll");
//        Console.log("plugin path:{}", absolutePath);
//        int result = DmReg.INSTANCE.SetDllPathA(absolutePath, 0);
//        Console.log("response ：{}", result == 1 ? "success" : "failed");
        return 1;
    }

}
