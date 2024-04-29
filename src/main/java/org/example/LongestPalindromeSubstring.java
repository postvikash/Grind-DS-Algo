package org.example;

import java.util.stream.Stream;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        String input = "ababd";
        System.out.println(longestPalindrome(input));
    }

    public static String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        int startIndex = -1;
        int maxLength = Integer.MIN_VALUE;
        int size = array.length;
        boolean[][] dp = new boolean[size][size];
        if (size < 2)
            return s;
        for(int i = 0; i < size; i++) {
            for(int j = size-1; j >= i; j--) {
                if(dp[i][j] || checkPalindrome(array, i, j, dp) == true) {
                    if (j-i+1 > maxLength) {
                        maxLength = j-i+1;
                        startIndex = i;
                    }
                }
            }
        }
        String ans = new String(array, startIndex, maxLength);
        return ans;
    }

    public static boolean checkPalindrome(char[] array, int i, int j, boolean[][] dp) {
        if (i <= j) {
            if(array[i] == array[j])
                return dp[i][j] = checkPalindrome(array, i+1, j-1, dp);
            else
                return false;
        }
        return true;
    }
}
