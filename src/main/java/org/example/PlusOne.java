package org.example;

import java.util.HashSet;
import java.util.Set;
public class PlusOne {
    public int[] plusOne(int[] digits) {
        Set<Integer> set = new HashSet();
        for (int k = 0; k < digits.length; k++) {
            set.add(digits[k]);
        }
        if (set.size() == 1 && digits[0] == 9) {
            int [] answer = new int[digits.length+1];
            answer[0] = 1;
            return answer;
        }
        int tempSum, carry = 0;
        for (int i = digits.length-1; i >= 0; i--) {
            if (i == digits.length-1)
                tempSum = digits[i]+carry+1;
            else
                tempSum = digits[i]+carry;
            carry = (tempSum == 10)? 1 : 0;
            if (carry == 1)
                digits[i] = 0;
            else {
                digits[i] = tempSum;
                return digits;
            }
        }
        return digits;
    }
}
