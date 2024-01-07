package org.example;

public class LastWordLength {

    public static int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
        if (!s.equals(" ") && s.length() == 1)
            return 1;
        int gimmickFlag = 1;
        int wc_count = 0;
        int i;
        for (i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) == ' ' && gimmickFlag == 1) {
                wc_count++;
            }
            else if (s.charAt(i) == ' ' && gimmickFlag == 0)
                break;
            else
                gimmickFlag = 0;
        }
        return s.length() - i - 1 - wc_count;
    }

    public static void main(String [] args) {
        System.out.println(lengthOfLastWord("   Alberto is lazy bum  "));
    }
}
