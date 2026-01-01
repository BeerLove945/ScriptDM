package com.script.com;

import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;
import com.sun.jna.platform.win32.COM.util.annotation.ComObject;
import com.sun.jna.platform.win32.Variant;

@ComObject(progId = "dm.dmsoft")
public interface ComDM {
    @ComMethod
    long SetSimMode(int mode);

    @ComMethod
    long ForceUnBindWindow(long hwnd);

    @ComMethod
    long SetPath(String path);

    @ComMethod
    String GetPath();

    @ComMethod
    long Reg(String reg_code, String ver_info);

    @ComMethod
    long RegEx(String reg_code, String ver_info, String ip);

    @ComMethod
    long RegNoMac(String reg_code, String ver_info);

    @ComMethod
    long RegExNoMac(String reg_code, String ver_info, String ip);

    @ComMethod
    String Ver();

    @ComMethod
    long GetLastError();

    @ComMethod
    long GetDmCount();

    @ComMethod
    long GetID();

    @ComMethod
    String GetBasePath();

    @ComMethod
    long SetShowErrorMsg(long show);

    @ComMethod
    long SetDisplayInput(String mode);

    @ComMethod
    long SetEnumWindowDelay(int delay);

    @ComMethod
    long SetDisplayDelay(int t);

    @ComMethod
    long SetDisplayRefreshDelay(int t);

    @ComMethod
    String GetFps();

    @ComMethod
    long HackSpeed(int rate);

    @ComMethod
    long SetAero(long en);

    @ComMethod
    long SetDisplayAcceler(int level);

    @ComMethod
    long SetScreen(int width, int height, int depth);

    @ComMethod
    long DmGuard(long en, String type);

    @ComMethod
    long DmGuardParams(String cmd, String sub_cmd, String param);

    @ComMethod
    long DmGuardExtract(String type, String path);

    @ComMethod
    long DmGuardLoadCustom(String type, String path);

    @ComMethod
    long UnLoadDriver();

    @ComMethod
    long DownCpu(String type, int rate);

    @ComMethod
    long InitCri();

    @ComMethod
    long EnterCri();

    @ComMethod
    long LeaveCri();

    @ComMethod
    long ReleaseRef();

    @ComMethod
    long SetExitThread(int mode);

    // 窗口操作相关函数
    @ComMethod
    long FindWindow(String class_name, String title_name);

    @ComMethod
    long FindWindowByProcess(String process_name, String class_name, String title_name);

    @ComMethod
    long FindWindowByProcessId(long process_id, String class_name, String title_name);

    @ComMethod
    long FindWindowEx(long parent, String class_name, String title_name);

    @ComMethod
    long FindWindowSuper(String spec1, int flag1, int type1, String spec2, int flag2, int type2);

    @ComMethod
    String EnumWindow(long parent, String title, String class_name, int filter);

    @ComMethod
    String EnumWindowByProcess(String process_name, String title, String class_name, int filter);

    @ComMethod
    String EnumWindowByProcessId(long pid, String title, String class_name, int filter);

    @ComMethod
    String EnumWindowSuper(String spec1, int flag1, int type1, String spec2, int flag2, int type2, int sort);

    @ComMethod
    String EnumProcess(String name);

    @ComMethod
    long GetForegroundWindow();

    @ComMethod
    long GetForegroundFocus();

    @ComMethod
    long GetMousePointWindow();

    @ComMethod
    long GetPointWindow(int x, int y);

    @ComMethod
    long GetSpecialWindow(int flag);

    @ComMethod
    long GetWindow(long hwnd, int flag);

    @ComMethod
    String GetWindowTitle(long hwnd);

    @ComMethod
    String GetWindowClass(long hwnd);

    @ComMethod
    long GetWindowProcessId(long hwnd);

    @ComMethod
    String GetWindowProcessPath(long hwnd);

    @ComMethod
    long GetWindowThreadId(long hwnd);

    @ComMethod
    long GetWindowRect(long hwnd, Variant.VARIANT x1, Variant.VARIANT y1, Variant.VARIANT x2, Variant.VARIANT y2);

    @ComMethod
    long GetClientRect(long hwnd, Variant.VARIANT x1, Variant.VARIANT y1, Variant.VARIANT x2, Variant.VARIANT y2);

    @ComMethod
    long GetClientSize(long hwnd, Variant.VARIANT width, Variant.VARIANT height);

    @ComMethod
    long GetWindowState(long hwnd, int flag);

    @ComMethod
    long SetWindowState(long hwnd, long flag);

    @ComMethod
    long MoveWindow(long hwnd, int x, int y);

    @ComMethod
    long SetWindowText(long hwnd, String text);

    @ComMethod
    long SetWindowSize(long hwnd, int width, int height);

    @ComMethod
    long SetClientSize(long hwnd, int width, int height);

    @ComMethod
    long SetWindowTransparent(long hwnd, long v);

    @ComMethod
    long ClientToScreen(long hwnd, Variant.VARIANT x, Variant.VARIANT y);

    @ComMethod
    long ScreenToClient(long hwnd, Variant.VARIANT x, Variant.VARIANT y);

    // 绑定相关函数
    @ComMethod
    long BindWindow(long hwnd, String display, String mouse, String keypad, long mode);

    @ComMethod
    long BindWindowEx(long hwnd, String display, String mouse, String keypad, String public_desc, long mode);

    @ComMethod
    long UnBindWindow();

    @ComMethod
    String GetBindWindow();

    @ComMethod
    long IsBind(long hwnd);

    @ComMethod
    long SwitchBindWindow(long hwnd);

    @ComMethod
    long EnableBind(long en);

    @ComMethod
    long EnableFakeActive(long en);

    @ComMethod
    long EnableIme(long en);

    @ComMethod
    long LockDisplay(long lock);

    @ComMethod
    long LockInput(long lock);

    @ComMethod
    long LockMouseRect(int x1, int y1, int x2, int y2);

    @ComMethod
    long EnableKeypadMsg(long en);

    @ComMethod
    long EnableKeypadPatch(long en);

    @ComMethod
    long EnableKeypadSync(long en, int time_out);

    @ComMethod
    long EnableMouseMsg(long en);

    @ComMethod
    long EnableMouseSync(long en, int time_out);

    @ComMethod
    long EnableRealKeypad(long en);

    @ComMethod
    long EnableRealMouse(long en, int mousedelay, int mousestep);

    @ComMethod
    long EnableSpeedDx(long en);

    @ComMethod
    long SetInputDm(Object input_dm, int rx, int ry);

    // 鼠标键盘相关函数
    @ComMethod
    long GetCursorPos(Variant.VARIANT x, Variant.VARIANT y);

    @ComMethod
    String GetCursorShape();

    @ComMethod
    String GetCursorShapeEx(int type);

    @ComMethod
    String GetCursorSpot();

    @ComMethod
    long MoveTo(int x, int y);

    @ComMethod
    String MoveToEx(int x, int y, int w, int h);

    @ComMethod
    void MoveR(int dx, int dy);

    @ComMethod
    long LeftClick();

    @ComMethod
    long LeftDoubleClick();

    @ComMethod
    long LeftDown();

    @ComMethod
    long LeftUp();

    @ComMethod
    long RightClick();

    @ComMethod
    long RightDown();

    @ComMethod
    long RightUp();

    @ComMethod
    long MiddleClick();

    @ComMethod
    long MiddleDown();

    @ComMethod
    long MiddleUp();

    @ComMethod
    long WheelDown();

    @ComMethod
    long WheelUp();

    @ComMethod
    long GetKeyState(int vk);

    @ComMethod
    long KeyDown(int vk_code);

    @ComMethod
    long KeyPress(int vk_code);

    @ComMethod
    long KeyUp(int vk_code);

    @ComMethod
    long KeyDownChar(String key_str);

    @ComMethod
    long KeyPressChar(String key_str);

    @ComMethod
    long KeyPressStr(String key_str, int delay);

    @ComMethod
    long KeyUpChar(String key_str);

    @ComMethod
    long WaitKey(int key_code, int time_out);

    @ComMethod
    long SetKeypadDelay(String type, int delay);

    @ComMethod
    long SetMouseDelay(String type, int delay);

    @ComMethod
    long GetMouseSpeed();

    @ComMethod
    long SetMouseSpeed(int speed);

    @ComMethod
    long EnableMouseAccuracy(long en);

    @ComMethod
    long SetSendStringDelay(int delay);

    @ComMethod
    long SendString(long hwnd, String str);

    @ComMethod
    long SendString2(long hwnd, String str);

    @ComMethod
    long SendPaste(long hwnd);

    @ComMethod
    long SendStringIme(String str);

    @ComMethod
    long SendStringIme2(long hwnd, String str, int mode);

    // 图色相关函数
    @ComMethod
    String GetColor(int x, int y);

    @ComMethod
    String GetColorBGR(int x, int y);

    @ComMethod
    String GetColorHSV(int x, int y);

    @ComMethod
    String GetAveRGB(int x1, int y1, int x2, int y2);

    @ComMethod
    String GetAveHSV(int x1, int y1, int x2, int y2);

    @ComMethod
    long CmpColor(int x, int y, String color, double sim);

    @ComMethod
    long GetColorNum(int x1, int y1, int x2, int y2, String color, double sim);

    @ComMethod
    long FindPic(int x1, int y1, int x2, int y2, String pic_name, String delta_color, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String FindPicEx(int x1, int y1, int x2, int y2, String pic_name, String delta_color, double sim, int dir);

    @ComMethod
    String FindPicE(int x1, int y1, int x2, int y2, String pic_name, String delta_color, double sim, int dir);

    @ComMethod
    String FindPicExS(int x1, int y1, int x2, int y2, String pic_name, String delta_color, double sim, int dir);

    @ComMethod
    long FindPicS(int x1, int y1, int x2, int y2, String pic_name, String delta_color, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    long FindPicMem(int x1, int y1, int x2, int y2, String pic_info, String delta_color, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String FindPicMemE(int x1, int y1, int x2, int y2, String pic_info, String delta_color, double sim, int dir);

    @ComMethod
    String FindPicMemEx(int x1, int y1, int x2, int y2, String pic_info, String delta_color, double sim, int dir);

    @ComMethod
    long FindPicSim(int x1, int y1, int x2, int y2, String pic_name, String delta_color, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String FindPicSimEx(int x1, int y1, int x2, int y2, String pic_name, String delta_color, double sim, int dir);

    @ComMethod
    String FindPicSimE(int x1, int y1, int x2, int y2, String pic_name, String delta_color, double sim, int dir);

    @ComMethod
    long FindPicSimMem(int x1, int y1, int x2, int y2, String pic_info, String delta_color, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String FindPicSimMemEx(int x1, int y1, int x2, int y2, String pic_info, String delta_color, double sim, int dir);

    @ComMethod
    String FindPicSimMemE(int x1, int y1, int x2, int y2, String pic_info, String delta_color, double sim, int dir);

    @ComMethod
    long EnableFindPicMultithread(long en);

    @ComMethod
    long SetFindPicMultithreadCount(int count);

    @ComMethod
    long SetFindPicMultithreadLimit(int limit);

    @ComMethod
    long EnablePicCache(long en);

    @ComMethod
    long FindColor(int x1, int y1, int x2, int y2, String color, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String FindColorEx(int x1, int y1, int x2, int y2, String color, double sim, int dir);

    @ComMethod
    String FindColorE(int x1, int y1, int x2, int y2, String color, double sim, int dir);

    @ComMethod
    long FindColorBlock(int x1, int y1, int x2, int y2, String color, double sim, int count, int width, int height, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String FindColorBlockEx(int x1, int y1, int x2, int y2, String color, double sim, int count, int width, int height);

    @ComMethod
    long FindMulColor(int x1, int y1, int x2, int y2, String color, double sim);

    @ComMethod
    long FindMultiColor(int x1, int y1, int x2, int y2, String first_color, String offset_color, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String FindMultiColorEx(int x1, int y1, int x2, int y2, String first_color, String offset_color, double sim, int dir);

    @ComMethod
    String FindMultiColorE(int x1, int y1, int x2, int y2, String first_color, String offset_color, double sim, int dir);

    @ComMethod
    long FindShape(int x1, int y1, int x2, int y2, String offset_color, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String FindShapeE(int x1, int y1, int x2, int y2, String offset_color, double sim, int dir);

    @ComMethod
    String FindShapeEx(int x1, int y1, int x2, int y2, String offset_color, double sim, int dir);

    @ComMethod
    long Capture(int x1, int y1, int x2, int y2, String file);

    @ComMethod
    long CaptureGif(int x1, int y1, int x2, int y2, String file, int delay, int time);

    @ComMethod
    long CaptureJpg(int x1, int y1, int x2, int y2, String file, int quality);

    @ComMethod
    long CapturePng(int x1, int y1, int x2, int y2, String file);

    @ComMethod
    long CapturePre(String file);

    @ComMethod
    String GetPicSize(String pic_name);

    @ComMethod
    long LoadPic(String pic_name);

    @ComMethod
    long FreePic(String pic_name);

    @ComMethod
    String MatchPicName(String pic_name);

    @ComMethod
    String RGB2BGR(String rgb_color);

    @ComMethod
    String BGR2RGB(String bgr_color);

    @ComMethod
    long SetPicPwd(String pwd);

    @ComMethod
    long LoadPicByte(long addr, int size, String name);

    @ComMethod
    long SetExcludeRegion(String type, String info);

    @ComMethod
    long IsDisplayDead(int x1, int y1, int x2, int y2, int t);

    @ComMethod
    long EnableDisplayDebug(long enable_debug);

    @ComMethod
    long EnableGetColorByCapture(long en);

    @ComMethod
    long SpeedNormalGraphic(long en);

    // 文字识别相关函数
    @ComMethod
    long AddDict(int index, String dict_info);

    @ComMethod
    long ClearDict(int index);

    @ComMethod
    long SetDict(int index, String dict_name);

    @ComMethod
    long SetDictMem(int index, long addr, int size);

    @ComMethod
    long SetDictPwd(String pwd);

    @ComMethod
    long UseDict(int index);

    @ComMethod
    long EnableShareDict(long en);

    @ComMethod
    long GetNowDict();

    @ComMethod
    long GetDictCount(int index);

    @ComMethod
    String GetDict(int index, int font_index);

    @ComMethod
    String GetDictInfo(String str, String font_name, int font_size, int flag);

    @ComMethod
    long SetExactOcr(long exact_ocr);

    @ComMethod
    long SetMinColGap(int col_gap);

    @ComMethod
    long SetMinRowGap(int row_gap);

    @ComMethod
    long SetRowGapNoDict(int row_gap);

    @ComMethod
    long SetColGapNoDict(int col_gap);

    @ComMethod
    long SetWordGap(int word_gap);

    @ComMethod
    long SetWordGapNoDict(int word_gap);

    @ComMethod
    long SetWordLineHeight(int line_height);

    @ComMethod
    long SetWordLineHeightNoDict(int line_height);

    @ComMethod
    String Ocr(int x1, int y1, int x2, int y2, String color, double sim);

    @ComMethod
    String OcrEx(int x1, int y1, int x2, int y2, String color, double sim);

    @ComMethod
    String OcrExOne(int x1, int y1, int x2, int y2, String color, double sim);

    @ComMethod
    String OcrInFile(int x1, int y1, int x2, int y2, String pic_name, String color, double sim);

    @ComMethod
    long FindStr(int x1, int y1, int x2, int y2, String str, String color, double sim, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String FindStrEx(int x1, int y1, int x2, int y2, String str, String color, double sim);

    @ComMethod
    String FindStrE(int x1, int y1, int x2, int y2, String str, String color, double sim);

    @ComMethod
    long FindStrS(int x1, int y1, int x2, int y2, String str, String color, double sim, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String FindStrExS(int x1, int y1, int x2, int y2, String str, String color, double sim);

    @ComMethod
    long FindStrFast(int x1, int y1, int x2, int y2, String str, String color, double sim, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String FindStrFastEx(int x1, int y1, int x2, int y2, String str, String color, double sim);

    @ComMethod
    String FindStrFastE(int x1, int y1, int x2, int y2, String str, String color, double sim);

    @ComMethod
    long FindStrFastS(int x1, int y1, int x2, int y2, String str, String color, double sim, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String FindStrFastExS(int x1, int y1, int x2, int y2, String str, String color, double sim);

    @ComMethod
    long FindStrWithFont(int x1, int y1, int x2, int y2, String str, String color, double sim, String font_name, int font_size, int flag, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String FindStrWithFontEx(int x1, int y1, int x2, int y2, String str, String color, double sim, String font_name, int font_size, int flag);

    @ComMethod
    String FindStrWithFontE(int x1, int y1, int x2, int y2, String str, String color, double sim, String font_name, int font_size, int flag);

    @ComMethod
    String GetWords(int x1, int y1, int x2, int y2, String color, double sim);

    @ComMethod
    String GetWordsNoDict(int x1, int y1, int x2, int y2, String color);

    @ComMethod
    String FetchWord(int x1, int y1, int x2, int y2, String color, String word);

    @ComMethod
    long GetResultCount(String str);

    @ComMethod
    long GetResultPos(String str, int index, Variant.VARIANT x, Variant.VARIANT y);

    @ComMethod
    long GetWordResultCount(String str);

    @ComMethod
    long GetWordResultPos(String str, int index, Variant.VARIANT x, Variant.VARIANT y);

    @ComMethod
    String GetWordResultStr(String str, int index);

    @ComMethod
    long SaveDict(int index, String file);

    // 系统相关函数
    @ComMethod
    String GetClipboard();

    @ComMethod
    long SetClipboard(String data);

    @ComMethod
    String GetDir(int type);

    @ComMethod
    String GetDiskSerial(int index);

    @ComMethod
    String GetDiskModel(int index);

    @ComMethod
    String GetDiskReversion(int index);

    @ComMethod
    String GetDisplayInfo();

    @ComMethod
    String GetMachineCode();

    @ComMethod
    String GetMachineCodeNoMac();

    @ComMethod
    String GetNetTime();

    @ComMethod
    String GetNetTimeByIp(String ip);

    @ComMethod
    String GetNetTimeSafe();

    @ComMethod
    long GetOsType();

    @ComMethod
    long GetOsBuildNumber();

    @ComMethod
    long GetScreenDepth();

    @ComMethod
    long GetScreenHeight();

    @ComMethod
    long GetScreenWidth();

    @ComMethod
    String GetTime();

    @ComMethod
    long Is64Bit();

    @ComMethod
    String GetCpuType();

    @ComMethod
    String GetCpuUsage();

    @ComMethod
    String GetMemoryUsage();

    @ComMethod
    String GetSystemInfo(int type, int method);

    @ComMethod
    long GetDPI();

    @ComMethod
    String GetLocale();

    @ComMethod
    long SetLocale();

    @ComMethod
    String GetMac();

    @ComMethod
    long Int64ToInt32(long v);

    @ComMethod
    String Hex32(long v);

    @ComMethod
    String Hex64(long v);

    @ComMethod
    String Md5(String str);

    @ComMethod
    long Delay(int mis);

    @ComMethod
    long Delays(int min_s, int max_s);

    @ComMethod
    long Beep(int fre, int delay);

    @ComMethod
    long Play(String file);

    @ComMethod
    long RunApp(String path, int mode);

    @ComMethod
    String ExecuteCmd(String cmd, String current_dir, int time_out);

    @ComMethod
    long ExitOs(int type);

    @ComMethod
    long CheckFontSmooth();

    @ComMethod
    long DisableFontSmooth();

    @ComMethod
    long EnableFontSmooth();

    @ComMethod
    long CheckUAC();

    @ComMethod
    long SetUAC(int uac);

    @ComMethod
    long DisablePowerSave();

    @ComMethod
    long DisableScreenSave();

    @ComMethod
    long DisableCloseDisplayAndSleep();

    @ComMethod
    long ShowTaskBarIcon(long hwnd, long is_show);

    @ComMethod
    long IsSurrpotVt();

    @ComMethod
    long ActiveInputMethod(long hwnd, String id);

    @ComMethod
    long CheckInputMethod(long hwnd, String id);

    @ComMethod
    String FindInputMethod(String id);

    @ComMethod
    long Stop(int id);

    // 内存相关函数
    @ComMethod
    long OpenProcess(long pid);

    @ComMethod
    String GetProcessInfo(long pid);

    @ComMethod
    long FreeProcessMemory(long hwnd);

    @ComMethod
    String GetCommandLine(long hwnd);

    @ComMethod
    long GetModuleBaseAddr(long hwnd, String module_name);

    @ComMethod
    long GetModuleSize(long hwnd, String module_name);

    @ComMethod
    String ReadData(long hwnd, long addr, int len);

    @ComMethod
    String ReadDataAddr(long hwnd, long addr, int len);

    @ComMethod
    long ReadInt(long hwnd, long addr, int type);

    @ComMethod
    long ReadIntAddr(long hwnd, long addr, int type);

    @ComMethod
    double ReadFloat(long hwnd, long addr);

    @ComMethod
    double ReadFloatAddr(long hwnd, long addr);

    @ComMethod
    double ReadDouble(long hwnd, long addr);

    @ComMethod
    double ReadDoubleAddr(long hwnd, long addr);

    @ComMethod
    String ReadString(long hwnd, long addr, int type, int len);

    @ComMethod
    String ReadStringAddr(long hwnd, long addr, int type, int len);

    @ComMethod
    long WriteData(long hwnd, long addr, String data);

    @ComMethod
    long WriteDataAddr(long hwnd, long addr, String data);

    @ComMethod
    long WriteInt(long hwnd, long addr, int type, long v);

    @ComMethod
    long WriteIntAddr(long hwnd, long addr, int type, long v);

    @ComMethod
    long WriteFloat(long hwnd, long addr, double v);

    @ComMethod
    long WriteFloatAddr(long hwnd, long addr, double v);

    @ComMethod
    long WriteDouble(long hwnd, long addr, double v);

    @ComMethod
    long WriteDoubleAddr(long hwnd, long addr, double v);

    @ComMethod
    long WriteString(long hwnd, long addr, int type, String v);

    @ComMethod
    long WriteStringAddr(long hwnd, long addr, int type, String v);

    @ComMethod
    long VirtualAllocEx(long hwnd, long addr, int size, int type);

    @ComMethod
    long VirtualFreeEx(long hwnd, long addr);

    @ComMethod
    long VirtualProtectEx(long hwnd, long addr, int size, int type, Variant.VARIANT old_protect);

    @ComMethod
    long VirtualQueryEx(long hwnd, long addr, Variant.VARIANT pmbi);

    @ComMethod
    long GetRemoteApiAddress(long hwnd, long base_addr, String fun_name);

    @ComMethod
    String IntToData(long int_value, int type);

    @ComMethod
    String FloatToData(double float_value);

    @ComMethod
    String DoubleToData(double double_value);

    @ComMethod
    String StringToData(String string_value, int type);

    @ComMethod
    String FindData(long hwnd, String addr_range, String data);

    @ComMethod
    String FindInt(long hwnd, String addr_range, long int_value_min, long int_value_max, int type);

    @ComMethod
    String FindFloat(long hwnd, String addr_range, double float_value_min, double float_value_max);

    @ComMethod
    String FindDouble(long hwnd, String addr_range, double double_value_min, double double_value_max);

    @ComMethod
    String FindString(long hwnd, String addr_range, String string_value, int type);

    @ComMethod
    String FindDataEx(long hwnd, String addr_range, String data, int step, int multi_thread, int mode);

    @ComMethod
    String FindIntEx(long hwnd, String addr_range, long int_value_min, long int_value_max, int type, int step, int multi_thread, int mode);

    @ComMethod
    String FindFloatEx(long hwnd, String addr_range, double float_value_min, double float_value_max, int step, int multi_thread, int mode);

    @ComMethod
    String FindDoubleEx(long hwnd, String addr_range, double double_value_min, double double_value_max, int step, int multi_thread, int mode);

    @ComMethod
    String FindStringEx(long hwnd, String addr_range, String string_value, int type, int step, int multi_thread, int mode);

    @ComMethod
    long SetMemoryFindResultToFile(String file);

    @ComMethod
    long SetMemoryHwndAsProcessId(long en);

    @ComMethod
    long TerminateProcess(long pid);

    @ComMethod
    String ReadDataToBin(long hwnd, long addr, int len);

    @ComMethod
    long WriteDataFromBin(long hwnd, long addr, String data, int len);

    @ComMethod
    String ReadDataAddrToBin(long hwnd, long addr, int len);

    @ComMethod
    long WriteDataAddrFromBin(long hwnd, long addr, String data, int len);

    @ComMethod
    long SetParam64ToPointer();

    // 文件处理相关函数
    @ComMethod
    long IsFileExist(String file);

    @ComMethod
    long IsFolderExist(String folder);

    @ComMethod
    long GetFileLength(String file);

    @ComMethod
    String ReadFile(String file);

    @ComMethod
    long WriteFile(String file, String content);

    @ComMethod
    long DeleteFile(String file);

    @ComMethod
    long MoveFile(String src_file, String dst_file);

    @ComMethod
    long CopyFile(String src_file, String dst_file, long over);

    @ComMethod
    long CreateFolder(String folder_name);

    @ComMethod
    long DeleteFolder(String folder_name);

    @ComMethod
    String EnumIniSection(String file);

    @ComMethod
    String EnumIniKey(String section, String file);

    @ComMethod
    String ReadIni(String section, String key, String file);

    @ComMethod
    long WriteIni(String section, String key, String v, String file);

    @ComMethod
    long DeleteIni(String section, String key, String file);

    @ComMethod
    String EnumIniSectionPwd(String file, String pwd);

    @ComMethod
    String EnumIniKeyPwd(String section, String file, String pwd);

    @ComMethod
    String ReadIniPwd(String section, String key, String file, String pwd);

    @ComMethod
    long WriteIniPwd(String section, String key, String v, String file, String pwd);

    @ComMethod
    long DeleteIniPwd(String section, String key, String file, String pwd);

    @ComMethod
    long DecodeFile(String file, String pwd);

    @ComMethod
    long EncodeFile(String file, String pwd);

    @ComMethod
    long DownloadFile(String url, String save_file, int timeout);

    @ComMethod
    String SelectDirectory();

    @ComMethod
    String SelectFile();

    @ComMethod
    String GetRealPath(String path);

    @ComMethod
    String ReadFileData(String file, int start_pos, int end_pos);

    // 人工智能相关函数
    @ComMethod
    long LoadAi(String file);

    @ComMethod
    long LoadAiMemory(long addr, int size);

    @ComMethod
    long AiFindPic(int x1, int y1, int x2, int y2, String pic_name, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String AiFindPicEx(int x1, int y1, int x2, int y2, String pic_name, double sim, int dir);

    @ComMethod
    long AiFindPicMem(int x1, int y1, int x2, int y2, String pic_info, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    @ComMethod
    String AiFindPicMemEx(int x1, int y1, int x2, int y2, String pic_info, double sim, int dir);

    @ComMethod
    long AiEnableFindPicWindow(long enable);

    @ComMethod
    String AiYoloDetectObjects(int x1, int y1, int x2, int y2, double prob, double iou);

    @ComMethod
    long AiYoloDetectObjectsToDataBmp(int x1, int y1, int x2, int y2, double prob, double iou, Variant.VARIANT data, Variant.VARIANT size, int mode);

    @ComMethod
    long AiYoloDetectObjectsToFile(int x1, int y1, int x2, int y2, double prob, double iou, String file, int mode);

    @ComMethod
    long AiYoloFreeModel(int index);

    @ComMethod
    String AiYoloObjectsToString(String objects);

    @ComMethod
    long AiYoloSetModel(int index, String file, String pwd);

    @ComMethod
    long AiYoloSetModelMemory(int index, long addr, int size, String pwd);

    @ComMethod
    long AiYoloSetVersion(String ver);

    @ComMethod
    String AiYoloSortsObjects(String objects, int height);

    @ComMethod
    long AiYoloUseModel(int index);

    // 其他函数
    @ComMethod
    long ShowScrMsg(int x1, int y1, int x2, int y2, String msg, String color);

    @ComMethod
    long MoveDD(int dx, int dy);

    @ComMethod
    long SetExportDict(int index, String dict_name);

    // 自定义函数
    @ComMethod
    long CreateFoobarCustom(long hwnd, int x, int y, String pic, String trans_color, double sim);

    @ComMethod
    long CreateFoobarEllipse(long hwnd, int x, int y, int w, int h);

    @ComMethod
    long CreateFoobarRect(long hwnd, int x, int y, int w, int h);

    @ComMethod
    long CreateFoobarRoundRect(long hwnd, int x, int y, int w, int h, int rw, int rh);

    @ComMethod
    long FoobarClearText(long hwnd);

    @ComMethod
    long FoobarClose(long hwnd);

    @ComMethod
    long FoobarDrawLine(long hwnd, int x1, int y1, int x2, int y2, String color, int style, int width);

    @ComMethod
    long FoobarDrawPic(long hwnd, int x, int y, String pic, String trans_color);

    @ComMethod
    long FoobarDrawText(long hwnd, int x, int y, int w, int h, String text, String color, int align);

    @ComMethod
    long FoobarFillRect(long hwnd, int x1, int y1, int x2, int y2, String color);

    @ComMethod
    long FoobarLock(long hwnd);

    @ComMethod
    long FoobarPrintText(long hwnd, String text, String color);

    @ComMethod
    long FoobarSetFont(long hwnd, String font_name, int size, int flag);

    @ComMethod
    long FoobarSetSave(long hwnd, String file, long en, String header);

    @ComMethod
    long FoobarStartGif(long hwnd, int x, int y, String pic_name, int repeat_limit, int delay);

    @ComMethod
    long FoobarStopGif(long hwnd, int x, int y, String pic_name);

    @ComMethod
    long FoobarTextLineGap(long hwnd, int gap);

    @ComMethod
    long FoobarTextPrintDir(long hwnd, int dir);

    @ComMethod
    long FoobarTextRect(long hwnd, int x, int y, int w, int h);

    @ComMethod
    long FoobarUnlock(long hwnd);

    @ComMethod
    long FoobarUpdate(long hwnd);

    @ComMethod
    long FoobarSetTrans(long hwnd, String trans, String color, double sim);
}
