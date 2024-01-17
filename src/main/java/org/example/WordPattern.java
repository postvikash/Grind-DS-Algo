package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String [] words = s.split("\\s+");
        if (pattern.length() != words.length)
            return false;
        Map<Character, String> characterStringMap = new HashMap<>(26);
        Map<String, Character> stringCharacterHashMap = new HashMap<>(26);
        for (int i = 0; i < words.length && i < pattern.length(); i++) {
            if (characterStringMap.get(pattern.charAt(i)) == null)
                characterStringMap.put(pattern.charAt(i), words[i]);
            if (stringCharacterHashMap.get(words[i]) == null) {
                stringCharacterHashMap.put(words[i], pattern.charAt(i));
            }
            if (!characterStringMap.get(pattern.charAt(i)).equals(words[i]))
                return false;
            if(stringCharacterHashMap.get(words[i]) != pattern.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "cat dog dog cat"));
    }
}
