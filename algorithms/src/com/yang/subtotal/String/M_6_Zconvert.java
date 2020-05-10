package com.yang.subtotal.String;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.List;

public class M_6_Zconvert {
    //Z字型变化
    public String convert(String s, int numRows) {
        if(numRows<=2) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) list.add(new StringBuilder());
        int flag = -1;
        int i = 0;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if(i== 0 || i == numRows-1) flag = -flag;
            i+=flag;
        }
        for (int j = 1; j < numRows; j++) {
            list.get(0).append(list.get(j));
        }
        return list.get(0).toString();
    }
}
