package org.example;

import java.util.*;

public class TripletSumZero {

    public static void main(String [] args) {
        int [] nums = {-2,0,1,1,2};
        List<List<Integer>> answer = threeSum(nums);
        System.out.println(answer);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int size = nums.length;
        Set<List<Integer>> triplets = new HashSet<>();
        if (size < 3)
            return new ArrayList<>();
        Arrays.sort(nums);
        int firstNonNegativeIndex = -1;
        for(int i = 0; i < size; i++)
            if (nums[i] >= 0) {
                firstNonNegativeIndex = i;
                break;
            }
        if (firstNonNegativeIndex == -1)
            return new ArrayList<>();
        for(int i = 0; i < firstNonNegativeIndex; i++) {
            List<int[]> pairs = twoSum(nums, Math.abs(nums[i]), i+1);
            for(int[] pair : pairs)
                triplets.add(Arrays.asList(nums[i], pair[0], pair[1]));
        }
        if(firstNonNegativeIndex+2 < size && nums[firstNonNegativeIndex] == 0
                && nums[firstNonNegativeIndex+1] == 0 && nums[firstNonNegativeIndex+2] == 0 )
            triplets.add(Arrays.asList(0, 0, 0));
        return new ArrayList<>(triplets);
    }

    public static List<int[]> twoSum(int[] numbers, int target, int start) {
        int end = numbers.length-1;
        List<int[]> pairs = new ArrayList<>();
        while(start < end) {
            if(numbers[end]+numbers[start] == target) {
                pairs.add(new int[]{numbers[end], numbers[start]});
                start++;
                end--;
                continue;
            }
            if (numbers[end]+numbers[start] < target)
                start++;
            else
                end--;
        }
        return pairs;
    }
}
