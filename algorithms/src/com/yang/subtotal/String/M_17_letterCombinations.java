package com.yang.subtotal.String;

import java.util.ArrayList;
import java.util.List;

public class M_17_letterCombinations {

    private String [] map = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return res;
        }
        combin(digits,0,new StringBuilder());
        return res;
    }

    private void combin(String digits, int index, StringBuilder sb) {
        if(index == digits.length()){
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(index);
        String letter = map[c - '0'];
        for (int i = 0; i < letter.length(); i++) {
            combin(digits,index+1,sb.append(letter.charAt(i)));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
