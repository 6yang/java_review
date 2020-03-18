package com.yang.codeman.String;

public class E_1160_countCharacters {
    public int countCharacters(String[] words, String chars) {
        if(words.length == 0 ) return 0;
        int res = 0;
        int [] charsCount = countChar(chars);
        for (int i = 0; i < words.length; i++) {
            if(contains(countChar(words[i]),charsCount)){
                res +=words[i].length();
            }
        }
        return res;
    }

    private boolean contains(int[] wordsCount, int[] charsCount) {
        for (int i = 0; i < 26; i++) {
            if(wordsCount[i]>charsCount[i]){
                return false;
            }
        }
        return true;
    }

    private int[] countChar(String words){
        int [] charsCount = new int[26];
        for (char c : words.toCharArray()) {
            charsCount[c-'a']++;
        }
        return charsCount;
    }
}
