package org.example;

public class MinimumSizeSubArraySum {
    public static void main(String [] args) {
        int [] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        int [] nums1 = {1,4,4};
        int [] nums2 = {2,3,1,2,4,3};
        int [] nums3 = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(213, nums));
        System.out.println(minSubArrayLen(4, nums1));
        System.out.println(minSubArrayLen(7, nums2));
        System.out.println(minSubArrayLen(11, nums3));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int sumOfElements = 0;
        for(int x : nums) {
            sumOfElements+= x;
        }
        if (sumOfElements < target)
            return 0;
        if (sumOfElements == target)
            return nums.length;
        int leftPtr = 0;
        int rightPtr = nums.length - 1;
        while (leftPtr < rightPtr) {
            if (nums[leftPtr] > nums[rightPtr]) {
                sumOfElements = sumOfElements - nums[rightPtr];
                if (sumOfElements < target) {
                    return (rightPtr-leftPtr+1);
                }
                rightPtr--;
            }
            else if (nums[rightPtr] > nums[leftPtr]) {
                sumOfElements = sumOfElements - nums[leftPtr];
                if (sumOfElements < target) {
                    return (rightPtr-leftPtr+1);
                }
                leftPtr++;
            } else {
                //Update leftPtr or rightPtr based on adjacent elements
                    if (nums[leftPtr+1] > nums[rightPtr-1]) {
                        sumOfElements = sumOfElements - nums[rightPtr];
                        if (sumOfElements >= target)
                            rightPtr = rightPtr - 1;
                    }
                    else {
                        sumOfElements = sumOfElements - nums[leftPtr];
                        if (sumOfElements >= target)
                            leftPtr = leftPtr + 1;
                    }
                    if (sumOfElements <= target)
                        return rightPtr-leftPtr+1;
            }
        }
        return rightPtr-leftPtr+1;
    }
}
