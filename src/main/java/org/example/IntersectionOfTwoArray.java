package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet = new HashSet<>();
        List<Integer> intList = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < nums1.length; i++) {
            numSet.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++) {
            if (numSet.contains(nums2[i]))
                intList.add(nums2[i]);
        }
        int[] arr = new int[intList.size()];
        for(int x: intList)
            arr[count++] = x;
        return arr;
    }
}
