package com.yang.jianzhi;

import java.util.*;

public class M_38_Permutation {

    List<String> list = new ArrayList<>();
    public String[] permutation(String str) {
        if (str.length() == 0) {
            return new String[]{};
        }
        char[] ch = str.toCharArray();
        change(ch, 0);
        Collections.sort(list);
        return list.toArray(new String[list.size()]);
    }

    private void change(char[] ch, int i) {
        if (i == ch.length - 1) {
            list.add(new String(ch));
        } else {
            for (int j = i; j < ch.length; j++) {
                int k;
                for (k = j-1; k >= i ; k--) {    // 剔除重复
                    if (ch[k] == ch[j])   break;
                }

                if (k != i-1) continue;
                swap(ch, i, j);
                change(ch,  i + 1);
                swap(ch, i, j); //这一步实际上是回溯操作
            }
        }
    }


    private void swap(char[] ch, int i, int j) {
        if (i != j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }
}
