package com.script.work.auto;

import com.script.com.ComDM;
import com.script.control.Control;
import com.script.control.Key;
import com.script.util.SystemConfig;
import com.script.work.AbstractWork;

import java.util.ArrayList;
import java.util.List;

public class ZidongWork extends AbstractWork {
    String display = "", mouseMode = "", keyboardMode = "",
            desc = "";
    int bindMode = 0;
    public List<ComDM> autoKeyboard = new ArrayList<>();

    @Override
    public void work() {
        window = Control.system();
        String s = window.EnumProcess("xymain.bin");
        long l = 0;
        if (s.contains(",")) {
            String[] split = s.split(",");
            for (String string : split) {
                long hwnd = Long.parseLong(string);
                hwnd = findWindow(window,hwnd);
                String title = window.GetWindowTitle(hwnd);
                System.out.println("find process ："+title);
                ComDM comForground = Control.nSystem();
                comForground.SetPath(SystemConfig.dictPath);
                comForground.SetDict(0,"auto.txt");
                comForground.UseDict(0);
                comForground.ForceUnBindWindow(hwnd);
                l = comForground.BindWindowEx(hwnd, display, mouseMode, keyboardMode, desc,bindMode);
                System.out.println("bind success ： " + l);
                autoKeyboard.add(comForground);
            }
        }

        while (true){
            delay10_1(1000);
            for (ComDM comForground : autoKeyboard) {
                forceAuto(comForground);
            }
        }
    }

    private long findWindow(ComDM window,long pid) {
        return window.FindWindowByProcessId(pid, "", "大话西游");
    }

    private void forceAuto(ComDM comForground) {
        comForground.UseDict(0);
        delay();
        String s = comForground.GetWords(0,0,500,760, "ffffff-000000", 1.0);
        if (s == null || s.isEmpty() || !s.contains("自动剩余")) {
            System.out.println("Find nothing Auto " + s);
            delay();
            forceF5(comForground);
        }
    }

    private void forceF5(ComDM comForground) {
            press(comForground, Key.f5);
    }
}
