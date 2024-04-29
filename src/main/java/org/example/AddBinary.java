package org.example;

/*

Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

*/


import java.util.Stack;

public class AddBinary {

    public static void main(String[] args) {
        String a = "101111";
        String b = "10";
        String ans = addBinary(a,b);
        System.out.println("Result : " + ans);
    }

    public static String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int i = len1-1, j = len2-1, carry = 0;
        Stack<Integer> bitsStack = new Stack<>();
        int tempSum = 0;
        while(i >= 0 && j >= 0) {
            int x = a.charAt(i) - 48;
            int y = b.charAt(j) - 48;
            i--;j--;
            tempSum = x+y+carry;
            if (tempSum > 1)
                carry = 1;
            else
                carry = 0;
            bitsStack.push(tempSum%2);
        }
        while(i >= 0) {
            int x = a.charAt(i) - 48;
            i--;
            tempSum = x+carry;
            if (tempSum > 1)
                carry = 1;
            else
                carry = 0;
            bitsStack.push(tempSum%2);
        }
        while(j >= 0) {
            int y = b.charAt(j) - 48;
            j--;
            tempSum = y+carry;
            if (tempSum > 1)
                carry = 1;
            else
                carry = 0;
            bitsStack.push(tempSum%2);
        }
        if (carry == 1)
            bitsStack.push(1);
        StringBuffer sbf = new StringBuffer();
        while(!bitsStack.empty())
            sbf.append(bitsStack.pop());
        return sbf.toString();
    }
}
