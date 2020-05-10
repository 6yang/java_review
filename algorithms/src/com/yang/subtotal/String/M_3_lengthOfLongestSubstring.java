package com.yang.subtotal.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class M_3_lengthOfLongestSubstring {
    //无重复字符的最长子串
    //优化hashMap
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int i=0,j=0,max = 0;
        while(j<n){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j))+1,i);
            }
            max = Math.max(max,j-i+1);
            map.put(s.charAt(j),j);
            j++;
        }
        return max;
    }
    //使用set的滑动窗口实现
    public static int lengthOfLongestSubstring_1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0,j=0,res =0;
        while(i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                res = res>(j-i)?res:(j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("pwwkew");
    }
}
