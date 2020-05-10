package com.yang.subtotal.bst;

import java.io.*;
import java.util.*;

public class countChar {
    //读取一个TXT文档 分别统计出其中英文字母、空格、数字和其它字符的个数
    public static void countChar() throws IOException {
        String path = "C:\\Users\\6yang\\Desktop\\1.txt";
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String s = "";
        String line;
        int letter = 0,number = 0,blank = 0,other = 0;
        while ((line = br.readLine()) != null) {
            // 一次读入一行数据
            for (char c : line.toCharArray()) {
                if(('a'<=c&&'z'>=c)||('A'<=c&&'Z'>=c)){
                    letter++;
                }else if('0'<=c&&c<='9'){
                    number++;
                }else if(c == ' '){
                    blank++;
                }else{
                    other++;
                }
            }
        }
        br.close();
        System.out.println("txt文档中英文的字数："+letter);
        System.out.println("txt文档中数字的字数："+number);
        System.out.println("txt文档中空格的字数："+blank);
        System.out.println("txt文档中其他字符的字数："+other);
    }

    //列出出现频率最高的中文是哪个字
    //s是已经统计出所有的中文字符组成的字符串
    public char topCharFrequent(String s){
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((n1,n2)->map.get(n2)-map.get(n1));
        for (Character c : map.keySet()) {
            heap.add(c);
        }
        return heap.poll(); // 堆顶元素就是出现次数最多的
    }

    //nums是没有去重的数字字符串
    public int countThree(String nums){
        Set<Integer> numSet = new HashSet<>();
        for (char c : nums.toCharArray()) { //去重
            numSet.add(c-'0');
        }
        return numSet.size()*numSet.size()*numSet.size(); // 可以组成的3位数个数

    }

    public static void main(String[] args) throws IOException {

    }
}
