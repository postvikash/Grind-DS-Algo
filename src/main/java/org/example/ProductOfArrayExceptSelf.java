package org.example;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
            if(checkForAllZero(nums))
                return nums;
            int product = 1;
            int zeroFlag = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeroFlag++;
                } else {
                    product = product * nums[i];
                }
            }

            int[] answer = new int[nums.length];
            if (zeroFlag > 1)
                return answer;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == 0) {
                    answer[i] = product;
                    continue;
                }
                if(zeroFlag == 1 && nums[i] != 0)
                    answer[i] = 0;
                else
                    answer[i] = product/nums[i];
            }
            return answer;
    }

    public static boolean checkForAllZero(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if(nums[i] != 0)
                return false;
        return true;
    }
}
