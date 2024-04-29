package org.example;

public class GuessNumber {

    public static void main(String[] args) {
        int n = 1792997410;
        System.out.println("Result : " + guessNumber(n));
    }
    public static int guessNumber(int n) {
        long high = n;
        long low = 1;
        long num;
        while(low <= high) {
            num = (low+high)/2;
            int apiRes = guess((int)num);
            if (apiRes == -1) {
                high = num-1;
            }
            else if (apiRes == 1) {
                low = num+1;
            }
            else
                return (int)num;
        }
        return 1;
    }

    public static int guess(int x) {
        if (x == 1702766719)
            return 0;
        if (x > 1702766719)
            return -1;
        else
            return 1;
    }
}
