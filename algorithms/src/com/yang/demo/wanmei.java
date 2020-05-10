package com.yang.demo;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class wanmei {
    public String shortestRepeatString(String str){
        String out = str+str;
        String sub = "";
        int len = str.length();
        int index = len;
        for(int i= len-1; i >= 1; i--) {
            sub = str.substring(i,len);
            if(str.startsWith(sub)) index = i;
        }
        if(index != len) out = str + str.substring(len-index,len);
        return out;
    }


    public static void main(String[] args) {
        List<String> items = Stream.of("宝石1", "宝石2", "宝石3", "宝石4", "宝石5", "宝石6", "宝石7", "宝石8")
                .collect(Collectors.toList());
        int i = 0;
// 移除宝石1/2/3
        for (String item : items) {
            if (i == 3) break;
            i ++;
            items.remove("宝石" + i);
        }
        System.out.println(items.size());
    }

}
