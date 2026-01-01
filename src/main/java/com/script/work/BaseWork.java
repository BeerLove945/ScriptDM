package com.script.work;

import com.script.com.*;
import com.script.control.Control;

import java.util.Map;

public abstract class BaseWork extends ThreadLocal<Map<Class<?>,Object>>{

    protected ComDM getMouse(){
        return Control.system();
    }

    protected ComDM getKeyBoard(){
       return Control.system();
    }
    protected ComDM getOcr(){
        return Control.system();
    }
    protected ComDM getWindow(){
       return Control.system();
    }
    protected ComDM getSystem(){
        return Control.system();
    }

}
