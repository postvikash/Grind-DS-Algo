package org.example;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string ""
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        char[] charMap = new char[26];
        int smallestLength = strs[0].length();
        for (int j = 1; j < strs.length; j++) {
            if(strs[j].length() < smallestLength)
                smallestLength = strs[j].length();
        }
        int i;
        for (i = 0; i < smallestLength; i++) {
            for (int j = 0; j < strs.length; j++) {
                charMap[strs[j].charAt(i)-97]++;
            }
            if (charMap[strs[0].charAt(i)-97] == strs.length) {
                charMap[strs[0].charAt(i)-97] = 0;
            } else
                break;
        }
        return strs[0].substring(0,i);
    }

    public static void main(String [] args) {
        String[] str = {"leetCode", "leetBore", "leetCore", "leet"};
        System.out.println(longestCommonPrefix(str));
    }
}
