package com.sunyk.base.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListArrays {
    public static void main(String[] args) {
        String[] string ={"1","2","3"};
        List<String> list = Arrays.asList(string);
        System.out.println(list.toString());
        System.out.println(list.get(0));
    }
}
