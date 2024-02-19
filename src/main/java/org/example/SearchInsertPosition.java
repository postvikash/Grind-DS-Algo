package org.example;

public class SearchInsertPosition {

    public static void main(String [] args) {
        int [] nums = {1,3,5,6};
        int k = searchInsert(nums, 7);
        System.out.println("Index of target is : " + k);
    }
    public static int searchInsert(int[] nums, int target) {
        int index = binarySearch(nums, 0, nums.length-1, target);
        return index;
    }

    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) {
            int expectedIndex = Math.abs((low+high)/2);
            if (nums[expectedIndex] < target)
                return expectedIndex+1;
            if (nums[expectedIndex] > target && expectedIndex == 0)
                return expectedIndex;
            else
                return expectedIndex - 1;

        }
        int mid = (low+high)/2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] > target)
            return binarySearch(nums, low, mid-1, target);
        else
            return binarySearch(nums, mid+1, high, target);
    }
}
