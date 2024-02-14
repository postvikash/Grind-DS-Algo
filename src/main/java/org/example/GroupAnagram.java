package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupAnagram {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> list = groupAnagrams(strs);
        System.out.println(list.size());
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listOfStringList = new ArrayList<>();
        Set<Integer> processedIndexSet = new HashSet<>();
        for (int i = 0; i < strs.length -1; i++) {
            List<String> stringList = new ArrayList<>();
            stringList.add(strs[i]);
            for (int j = i+1; j < strs.length; j++) {
                if (!processedIndexSet.contains(j) && isAnagram(strs[i], strs[j])) {
                    stringList.add(strs[j]);
                    processedIndexSet.add(j);
                }
            }
            listOfStringList.add(stringList);
        }
        return listOfStringList;
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;
        int[] frequencyArray = new int[256];
        for (int i = 0; i < s.length(); i++)
            frequencyArray[s.charAt(i)]++;
        for (int i = 0; i < t.length(); i++)
            frequencyArray[t.charAt(i)]--;
        for (int i = 0; i < 256; i++)
            if (frequencyArray[i] != 0)
                return false;
        return true;
    }
}
