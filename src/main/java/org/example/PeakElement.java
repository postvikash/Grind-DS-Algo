package org.example;

/*

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index.
If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.
In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2,
or index number 5 where the peak element is 6.

 */

public class PeakElement {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,5,6,7,8,5,5,5,5};
        int answer = peakElement(nums);
        System.out.println(answer);
    }

    public static int peakElement(int[] nums) {
        int size = nums.length;
        if (size < 2)
            return 0;
        if (nums[1] < nums[0])
            return 0;
        if (nums[size-2] < nums[size-1])
            return size-1;
        for(int i = 1; i < size-1; i++) {
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
                return i;
        }
        return -1;
    }
}
