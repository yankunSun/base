package com.sunyk.base.learn;

public class StringLoad {
    public static void main(String[] args) {
        String str1 = new StringBuilder("zijie").append("offer").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());

    }

}
