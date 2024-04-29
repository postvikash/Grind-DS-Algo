package org.example;

public class ReverseBits {

    public static void main(String[] args) {
        int a = -3;
        int ans = reverseBits(a);
        System.out.print("Result is : " + ans);
    }
    public static int reverseBits(int n) {
        if ( n == 0 )
            return 0;
        boolean isSigned = (n < 0);
        int[] bitArray = new int[32];
        int itrIdx = 31;
        do {
            int tempBit = n & 1;
            bitArray[itrIdx] = tempBit;
            itrIdx--;
            n = n >> 1;
        } while(itrIdx >= 0);
        for (int i = 31; i >= 0; i--) {
            System.out.print(bitArray[i]);
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = ans + bitArray[i]*((int)Math.pow(2, i));
        }
        return isSigned? -(ans+1): ans;
    }
}
