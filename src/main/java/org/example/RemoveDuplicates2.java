package org.example;

/* *
  * Given an integer array nums sorted in non-decreasing order,
  * remove some duplicates in-place such that each unique element appears at most twice.
  * The relative order of the elements should be kept the same.
  * Since it is impossible to change the length of the array in some languages,
  * you must instead have the result be placed in the first part of the array nums.
  * More formally, if there are k elements after removing the duplicates,
  * then the first k elements of nums should hold the final result.
  * It does not matter what you leave beyond the first k elements.
  *
  *
  *
  * @Return int k after placing the final result in the first k slots of nums.
  * Do not allocate extra space for another array.
  * You must do this by modifying the input array in-place with O(1) extra memory.
 * */

import java.util.Arrays;

public class RemoveDuplicates2 {
    public static void main(String [] args) {
        int [] nums = {0,0,1,1,1,1,2,3,3,};
        int k = removeDuplicates(nums);
        System.out.println("Old Array Length : " + nums.length);
        System.out.println("New Array Length : " + k);
        for (int j=0;j<k;j++) {
            System.out.println(nums[j]);
        }
    }
    public static int removeDuplicates(int[] nums) {
        int counter = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                counter++;
            }
            if (nums[i] != nums[i-1]) {
                counter = 1;
            }
            if (counter > 2) {
                int temp = nums[i];
                while(i<nums.length && nums[i] == temp) {
                    nums[i] = Integer.MAX_VALUE;
                    i++;
                }
                counter = 1;
            }
        }
        Arrays.sort(nums);
        counter = 0;
        for (int i = nums.length -1; i >= 0; i--) {
            if (nums[i] == Integer.MAX_VALUE )
                counter++;
        }
        return nums.length - counter;
    }
}
