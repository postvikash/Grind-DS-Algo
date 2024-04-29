package org.example;

import java.util.Stack;

public class StringCompression {

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        int resultantLen = compress(chars);
        for (int i = 0; i < resultantLen; i++) {
            System.out.print(chars[i]);
        }
    }

    public static int compress(char[] chars) {
        int length = chars.length;
        int i = 0, j = 0;
        while (i < length) {
            int count = 1;
            while ( i < length-1 && chars[i] == chars[i+1]) {
                i++;
                count++;
            }
            chars[j] = chars[i];
            if (count > 1) {
                Stack<Integer> intStack = new Stack<>();
                while (count > 1) {
                    int temp = (count%10);
                    intStack.push(temp);
                    count = count / 10;
                }
                while (!intStack.empty()) {
                    int temp = intStack.pop();
                    chars[j+1] = (char)(temp+48);
                    j++;
                }
            }
            i++;
            j++;
        }
        return j;
    }
}
