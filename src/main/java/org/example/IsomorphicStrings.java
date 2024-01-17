package org.example;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving
the order of characters. No two characters may map to the same character,
but a character may map to itself.
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "bee"));
    }

    public static boolean isIsomorphic(String s, String t) {
        int [] frequencyMapForStringOne = new int[256];
        int [] frequencyMapForStringTwo = new int[256];
        for (int i = 0; i < s.length(); i++) {
            frequencyMapForStringOne[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            frequencyMapForStringTwo[t.charAt(i)]++;
        }
        Arrays.sort(frequencyMapForStringOne);
        Arrays.sort(frequencyMapForStringTwo);
        for (int i = 0; i < 256; i++) {
            if (frequencyMapForStringOne[i] != frequencyMapForStringTwo[i])
                return false;
        }
        return true;
    }
}
