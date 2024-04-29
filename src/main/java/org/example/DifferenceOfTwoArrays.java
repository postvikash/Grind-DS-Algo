package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DifferenceOfTwoArrays {

    public static void main(String [] args) {
        int [] nums1 = {-3,6,-5,4,5,5};
        int [] nums2 = {6,6,-3,-3,3,5};
        List<List<Integer>> answer = findDifference(nums1, nums2);
        System.out.println(answer);
    }
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> integerSet1 = new HashSet<>();
        Set<Integer> integerSet2 = new HashSet<>();
        List<Integer> nums = new ArrayList<>();
        for(int x : nums1)
            integerSet1.add(x);
        for(int x : nums2)
            integerSet2.add(x);
        for(int x: integerSet1) {
            if(integerSet2.contains(x)) {
                nums.add(x);
            }
        }
        for(int x : nums) {
            integerSet1.remove(x);
            integerSet2.remove(x);
        }
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(integerSet1));
        answer.add(new ArrayList<>(integerSet2));
        return answer;
    }
}
