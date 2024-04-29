package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxNumVowelsInSubstringOfSizeK {
    public int maxVowels(String s, int k) {
        Set<Character> charSet = new HashSet<>();
        charSet.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int maxVowelsSoFar = 0;
        for (int i = 0; i < k; i++)
            if (charSet.contains(s.charAt(i)))
                maxVowelsSoFar++;

        int maxVowels = maxVowelsSoFar;
        for(int j = k; j < s.length(); j++) {
            if (charSet.contains(s.charAt(j-k)))
                maxVowelsSoFar--;
            if (charSet.contains(s.charAt(j)))
                maxVowelsSoFar++;
            if (maxVowelsSoFar > maxVowels)
                maxVowels = maxVowelsSoFar;
        }
        return maxVowels;
    }
}
