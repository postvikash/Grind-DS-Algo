package org.example;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(9));
    }

    public static boolean isHappy(int n) {
        Set<Integer> integerSet = new HashSet();
        while (n > 1) {
            if (integerSet.add(n) == false)
                return false;
            else
                System.out.println(integerSet);
            n = (int)getSumOfDigitsSquare(n);
        }
        return true;
    }

    public static long getSumOfDigitsSquare(int n) {
        long sum = 0;
        while ( n > 0) {
            int digit = n % 10;
            sum = sum + (int)Math.pow(digit, 2);
            n = n / 10;
        }
        return sum;
    }
}
