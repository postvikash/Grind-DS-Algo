package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class PlusOne {
    public static final Map<Coordinates, Integer> coordinateValueMap = new HashMap<>();

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

    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1)
            return 1;
        Coordinates coordinates1 = new Coordinates(m, n-1);
        Coordinates coordinates2 = new Coordinates(m-1, n);
        if (coordinateValueMap.entrySet().stream().filter(entry -> entry.getKey().equals(coordinates1)).count() > 0) {
            coordinateValueMap.put(coordinates1, uniquePaths(m, n-1));
        }
        if (coordinateValueMap.entrySet().stream().filter(entry -> entry.equals(coordinates2)).count() > 0) {
            coordinateValueMap.put(coordinates2, uniquePaths(m, n-1));
        }
        return coordinateValueMap.get(coordinates1).intValue() +  coordinateValueMap.get(coordinates2).intValue();

    }
}

class Coordinates {
    int x;
    int y;
    Coordinates() {
        x = 0;
        y = 0;
    }

    Coordinates(int a, int b) {
        x = a;
        y = b;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        Coordinates toBeCompared = (Coordinates) obj;
        return (toBeCompared.getX() == this.x && toBeCompared.getY() == this.y);
    }
}