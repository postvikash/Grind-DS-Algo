package org.example;

import java.util.Arrays;

public class MinimumJobDifficulty {

    static int[][] dp = new int[301][11];
    public static void main(String[] args) {
        int[] input = {186,398,479,206,885,423,805,112,925,656,16,932,740,292,671,360};
        System.out.println(minDifficulty(input, 4));
    }
    public static int minDifficulty(int[] jobDifficulty, int d) {
        int numOfJobs = jobDifficulty.length;
        if (numOfJobs < d)
            return -1;
        if (numOfJobs == d)
            return sumOfArrayElements(jobDifficulty);
        else {
            for(int i = 0; i < 301; i++)
                for(int j = 0; j < 10; j++)
                    dp[i][j] = -1;
            return solve(0, d, jobDifficulty);
        }
    }

    public static int solve(int idx, int days, int[] jd) {
        if(dp[idx][days] != -1)
            return dp[idx][days];
        if (days == 1)
            return maxInArrayStartingFromIdx(idx, jd);

        int finalResult = Integer.MAX_VALUE;
        int maxD = Integer.MIN_VALUE;
        for (int i = idx; i <= jd.length - days; i++) {
            maxD = Math.max(maxD, jd[i]);
            int result = maxD + solve(i + 1, days - 1, jd);
            finalResult = Math.min(finalResult, result);
            dp[idx][days] = finalResult;
        }
        return finalResult;
    }

    public static int sumOfArrayElements(int[] jobDifficulty) {
        int sum = 0;
        for(int x : jobDifficulty)
            sum+=x;
        return sum;
    }

    public static int maxInArrayStartingFromIdx(int idx, int[] jd) {
        int max = -1;
        for(int i = idx; i < jd.length; i++) {
            max = Math.max(max, jd[i]);
        }
        return max;
    }
}
