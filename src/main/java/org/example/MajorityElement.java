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
        int currentMax = 0;
        int globalMax = -1;
        int majorityIndex = 0;
        Set<Integer> brain = new HashSet<>((nums.length/2)+1);
        for( int i = 0; i < nums.length; i++) {
            if (globalMax >= (nums.length/2)+1)
                return nums[majorityIndex];
            currentMax =0;
            int keyToCompare = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (brain.contains(nums[i])) {
                    System.out.println("hello");
                    break;
                }
                if (keyToCompare == nums[j])
                    currentMax++;
            }
            if (currentMax > globalMax) {
                globalMax = currentMax;
                majorityIndex = i;
            }
            brain.add(nums[i]);
        }
        return nums[majorityIndex];
    }
}
