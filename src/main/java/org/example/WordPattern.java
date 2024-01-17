package org.example;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String [] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
        System.out.println(pattern);
        return true;
    }

    public static void main() {
        System.out.println(wordPattern("abba", "cat dog dog cat"));
    }
}
