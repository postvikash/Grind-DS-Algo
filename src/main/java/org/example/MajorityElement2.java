package org.example;

import java.util.Arrays;

public class MajorityElement2 {

    public static void main(String [] args) {
        int [] nums = {1,2,3,4,5,5,6,7,8,5,5,5,5};
        int answer = getMajorityElement(nums);
        System.out.println(answer);
    }


    public static int getMajorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        else {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
}
