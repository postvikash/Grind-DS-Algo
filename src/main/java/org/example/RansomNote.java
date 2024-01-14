package org.example;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings ransomNote and magazine,
return true if ransomNote can be constructed by using
the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Eg.
Input: ransomNote = "aa", magazine = "aab"
Output: true
 */
public class RansomNote {
    public static void main(String [] args) {
        String magazine = "hhjdgjbhahaagihhhhhajjibjffhijehda";
        String ransomNote = "dehifb";
        boolean answer = canConstruct(ransomNote, magazine);
        System.out.println(answer);
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i< magazine.length();i++) {
            if (hashMap.get(magazine.charAt(i)) == null)
                hashMap.put(magazine.charAt(i), 1);
            else {
                hashMap.put(magazine.charAt(i), hashMap.get(magazine.charAt(i)) + 1);
            }
        }
        System.out.println(hashMap);
        for (int i = 0; i< ransomNote.length();i++) {
            if (hashMap.get(ransomNote.charAt(i)) == null || hashMap.get(ransomNote.charAt(i)) <= 0) {
                return false;
            }
            else {
                hashMap.put(ransomNote.charAt(i), hashMap.get(ransomNote.charAt(i)) - 1);
            }
        }
        return true;
    }
}
