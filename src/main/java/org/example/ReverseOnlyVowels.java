package org.example;

import java.util.HashSet;
import java.util.Set;

public class ReverseOnlyVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        int strLen = s.length();
        int startIndex = 0;
        int endIndex = strLen - 1;
        Set<Character> charSet = new HashSet<>();
        char[] chars = s.toCharArray();
        charSet.add('a');
        charSet.add('e');
        charSet.add('i');
        charSet.add('o');
        charSet.add('u');
        charSet.add('A');
        charSet.add('E');
        charSet.add('I');
        charSet.add('O');
        charSet.add('U');
        while(startIndex < endIndex) {
            char x = '\0';
            char y = '\0';
            do {
                x = s.charAt(startIndex++);
            } while(startIndex < endIndex && !charSet.contains(x));
            do {
                y = s.charAt(endIndex--);
            } while(endIndex > startIndex && !charSet.contains(y));
            if (charSet.contains(y) && charSet.contains(x)) {
                System.out.println(x + ", " + y);
                if(x != y) {
                    chars[startIndex-1] = y;
                    chars[endIndex+1] = x;
                }
                x = '\0';
                y = '\0';
            }
        }
        return new String(chars);
    }
}
