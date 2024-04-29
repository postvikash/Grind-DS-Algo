package org.example;

public class HighestAltitude {
    public int highestAltitude(int[] gain) {
        int maxAlt = 0;
        int currAlt = 0;
        for(int i = 0; i< gain.length; i++) {
            currAlt = gain[i];
            if (currAlt > maxAlt)
                maxAlt = currAlt;
        }
        return maxAlt;
    }

    public int pivotIndex(int[] nums) {
        int sumOnLeft = 0;
        int totalSum = 0;
        for(int x : nums) {
            totalSum = totalSum + x;
        }
        for (int i = 0; i < nums.length; i++) {
            int sumOnRight = totalSum - nums[i] - sumOnLeft;
            if (sumOnRight == sumOnLeft)
                return i;
            sumOnLeft = sumOnLeft+nums[i];
        }
        return -1;
    }
}
