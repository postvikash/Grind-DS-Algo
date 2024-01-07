package org.example;
public class SubstringStartIndex {
    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle))
            return 0;
        if (needle.length() > haystack.length())
            return -1;
        int i, found = 0;
        for (i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i+needle.length()).equals(needle)) {
                found = 1;
                break;
            }
        }
        if (found == 0)
            return -1;
        else
            return i;
    }

    public static void main(String [] args) {
        System.out.println(strStr("leetcode", "code"));
    }
}