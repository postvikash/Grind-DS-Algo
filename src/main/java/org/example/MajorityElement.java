package org.example;

import java.util.HashSet;
import java.util.Set;

public class MajorityElement {
    public static void main(String [] args) {
        int [] nums = {1,2,3,4,5,5,6,7,8,5,5,5,5};
        int answer = getMajorityElement(nums);
        System.out.println(answer);
    }

    public static int getMajorityElement(int [] nums) {
        // Variable to track the frequency of majority element
        int currentMaxFrequency, globalMaxFrequency = -1;
        int majorityElementIndex = 0;
        Set<Integer> brain = new HashSet<>();
        for( int i = 0; i < nums.length; i++) {
            // if globalMaxFrequency exceeds half the length of array, it implies we have
            // already found the index of majority element.
            if (globalMaxFrequency >= (nums.length/2)+1)
                return nums[majorityElementIndex];
            currentMaxFrequency = 0;
            int keyToCompare = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (brain.contains(nums[i]))
                    break;
                if (keyToCompare == nums[j])
                    currentMaxFrequency++;
            }
            if (currentMaxFrequency > globalMaxFrequency) {
                globalMaxFrequency = currentMaxFrequency;
                majorityElementIndex = i;
            }
            brain.add(nums[i]);
        }
        return nums[majorityElementIndex];
    }
}
