package com.script.control;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Key {
    public static final int ctrl = 17;
    public static final int alt = 18;
    public static final int end = 35;
    public static final int esc = 27;
    public static final int a = 65;
    public static final int b = 66;
    public static final int c = 67;
    public static final int d = 68;
    public static final int e = 69;
    public static final int f = 70;
    public static final int g = 71;
    public static final int h = 72;
    public static final int i = 73;
    public static final int j = 74;
    public static final int k = 75;
    public static final int l = 76;
    public static final int m = 77;
    public static final int n = 78;
    public static final int o = 79;
    public static final int p = 80;
    public static final int q = 81;
    public static final int r = 82;
    public static final int s = 83;
    public static final int t = 84;
    public static final int u = 85;
    public static final int v = 86;
    public static final int w = 87;
    public static final int x = 88;
    public static final int y = 89;
    public static final int z = 90;

    public static final int sn0 = 96;
    public static final int sn1 = 97;
    public static final int sn2 = 98;
    public static final int sn3 = 99;
    public static final int sn4 = 100;
    public static final int sn5 = 101;
    public static final int sn6 = 102;
    public static final int sn7 = 103;
    public static final int sn8 = 104;
    public static final int sn9 = 105;
    public static final int sn_j = 107;
    public static final int sn_ = 109;


    public static final int n0 = 48;
    public static final int tab = 9;
    public static final int shift = 16;
    public static final int left = 37;
    public static final int up = 38;
    public static final int right = 39;
    public static final int down = 40;
    public static final int n1 = 49;
    public static final int n2 = 50;
    public static final int n3 = 51;
    public static final int n4 = 52;
    public static final int n5 = 53;
    public static final int n6 = 54;
    public static final int n7 = 55;
    public static final int n8 = 56;
    public static final int n9 = 57;
    public static final int n__ = 189;
    public static final int n_j = 187;
    public static final int n_ = 192;

    public static final int space = 32;
    public static final int f1 = 112;
    public static final int f2 = 113;
    public static final int f3 = 114;
    public static final int f4 = 115;
    public static final int f5 = 116;
    public static final int f6 = 117;
    public static final int f7 = 118;
    public static final int f8 = 119;
    public static final int f9 = 120;
    public static final int f10 = 121;
    public static final int f11 = 122;
    public static final int f12 = 123;
    public static final int enter = 13;
    public static Map<String, Integer> ks = new HashMap<>();
    public static List<Integer> a_z = new ArrayList<>();

    static {
        Field[] declaredFields = Key.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Class<?> type = declaredField.getType();
            if (type == int.class || type == Integer.class)
                try {
                    ks.put(declaredField.getName(), (Integer) declaredField.get(null));
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }
        }
        int i = 65;
        int count = 27;
        for (int s = 0; s < count; s++) {
            a_z.add(i+s);
        }
    }
}
