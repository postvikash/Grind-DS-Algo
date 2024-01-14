package org.example;

public class ValidPalindrome {
    public static void main(String [] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean answer = isPalindrome(str);
        System.out.println(answer);
    }
    public static boolean isPalindrome(String str) {
        char [] arr = new char[str.length()];
        int counter = 0;
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                arr[counter] = (char) ((int) str.charAt(i) + 32);
                counter++;
            }
            else if (str.charAt(i) >= 97 && str.charAt(i) <= 122) {
                arr[counter] = str.charAt(i);
                counter++;
            } else if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                arr[counter] = str.charAt(i);
                counter++;
            }
        }
        for (int i=0;i<counter;i++)
            System.out.println(arr[i]);
        int forwardTraveller = 0, backwardTraveller = counter -1;
        while (forwardTraveller <= backwardTraveller) {
            if (arr[forwardTraveller] != arr[backwardTraveller])
                return false;
            forwardTraveller++;
            backwardTraveller--;
        }
        return true;
    }
}
