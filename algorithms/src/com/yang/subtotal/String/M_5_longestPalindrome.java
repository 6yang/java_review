package com.yang.subtotal.String;

public class M_5_longestPalindrome {

    //使用动态规划，空间换时间
    public String longestPalindrome(String s) {
        if(s == null || s.length()<2) return s;
        int len = s.length();
        int maxLen = 1;
        int maxStart = 0;
        int maxEnd = 0;
        boolean[][] dp = new boolean[len][len];
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if(s.charAt(l)==s.charAt(r)&&(r-l<=2||dp[l+1][r-1])){
                    dp[l][r] = true;
                    if(r-l+1>maxLen){
                        maxStart = l;
                        maxEnd = r;
                        maxLen =  r-l+1;
                    }
                }
            }
        }
        return s.substring(maxStart,maxEnd+1);
    }

    //中心扩散法
    public String longestPalindrome_2(String s) {
        if(s == null || s.length() == 0) return "";
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int maxStart = 0;
        int len = 1;
        for (int i = 0; i < strLen; i++) {
            left = i-1;
            right = i+1;
            while(left>=0 && s.charAt(left) == s.charAt(i)){
                left--;
                len++;
            }
            while(right<strLen&&s.charAt(right) == s.charAt(i)){
                right++;
                len++;
            }
            while(left>=0&&right<strLen&&s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                len +=2;
            }
            if(len >maxLen){
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart+1,maxStart+maxLen+1);
    }

    //方法 1 暴力解法
    //找出所有子串 然后再判断最唱的回文字符串
    //时间复杂度O(n3) 空间复杂度O(1)会超时
    public String longestPalindrome_1(String s) {
        String ans = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String test = s.substring(i,j);
                if(isPalindrome(test)&&test.length()>max){
                    ans = test;
                    max = Math.max(max,ans.length());
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s){
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("sdasd".substring(0, 4));
    }
}
