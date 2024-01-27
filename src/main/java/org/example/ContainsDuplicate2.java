package org.example;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numberIndicesMap = new HashMap();
        for (int i = 0; i< nums.length; i++) {
            if (numberIndicesMap.get(nums[i]) == null)
                numberIndicesMap.put(nums[i], i);
            else {
                int lastIndex = numberIndicesMap.get(nums[i]);
                if (i - lastIndex <= k)
                    return true;
                else
                    numberIndicesMap.put(nums[i], i);
            }
        }
        return false;
    }
}
