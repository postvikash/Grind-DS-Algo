package org.example;

public class GcdOfTwoStrings {

    public static void main(String[] args) {
        String str1 = "ABABAB";
        String str2 = "AB";
        System.out.println(gcdOfStrings(str1, str2));
    }
    public static String gcdOfStrings(String str1, String str2) {
        if ((str1+str2).equals(str2+str1)) {
            int gcdLength = gcdOfTwoNumber(str1.length(), str2.length());
            return str1.substring(0, gcdLength);
        } else
            return "";

    }
    public static int gcdOfTwoNumber(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        if (a == b)
            return a;
        int biggerNum = a > b ? a : b;
        int smallerNum = (biggerNum == a) ? b : a;
        while (smallerNum != 0) {
            int rem = biggerNum % smallerNum;
            biggerNum = smallerNum;
            smallerNum = rem;
        }
        return biggerNum;
    }
}
