package org.example;

import java.util.Arrays;

public class GreaterNumberWithSameDigit {

    public static void main(String[] args) {
        int a = 230241;
        int ans = nextGreaterElement(a);
        System.out.println("Result : " + ans);
    }

    public static int nextGreaterElement(int n) {
        if (n == 0)
            return -1;
        int sizeOfNumber = 1;
        int divider = 10;
        while(true) {
            if (n%divider != n) {
                sizeOfNumber++;
                divider = divider*10;
                continue;
            }
            break;
        }
        int[] digits = new int[sizeOfNumber];
        int temp = n;
        int idx = sizeOfNumber-1;
        while(temp > 0) {
            digits[idx] = temp%10;
            temp = temp/10;
            idx--;
        }
        for(int x : digits)
            System.out.print(x+ ", ");

        // find first occurence where digit[i] < digit[i+1]
        int magicIndex = -1;
        for(int i = sizeOfNumber-2; i >=0; i--) {
            if(digits[i] < digits[i+1]) {
                magicIndex = i;
                break;
            }
        }
        if (magicIndex == -1)
            return magicIndex;
        // find the smallest digit greater than digit at magicIndex
        int smallestDiff = Integer.MAX_VALUE;
        int charmingIndex = -1;
        for(int i = magicIndex+1; i < sizeOfNumber; i++) {
            int currDiff = digits[i] - digits[magicIndex];
            if (currDiff >0 && currDiff <  smallestDiff) {
                smallestDiff = currDiff;
                charmingIndex = i;
            }
        }
        //swap magicIndex with magicIndex+1;
        temp = digits[magicIndex];
        digits[magicIndex] = digits[charmingIndex];
        digits[charmingIndex] = temp;
        System.out.println();
        for(int x : digits)
            System.out.print(x+ ", ");
        int[] tempArray = new int[sizeOfNumber-magicIndex-1];
        for(int i = 0; i < sizeOfNumber-magicIndex-1; i++) {
            tempArray[i] = digits[i+magicIndex+1];
        }
        System.out.println();
        for(int x : tempArray)
            System.out.print(x+ ", ");
        Arrays.sort(tempArray);
        for(int i = 0; i < sizeOfNumber-magicIndex-1; i++) {
            digits[i+magicIndex+1] = tempArray[i];
        }
        System.out.println();
        for(int x : digits)
            System.out.print(x+ ", ");
        StringBuffer sbf = new StringBuffer();
        for(int x : digits)
            sbf.append(x);
        System.out.println(sbf.toString());
        int answer = Integer.parseInt(sbf.toString());
        return answer;
    }
}
