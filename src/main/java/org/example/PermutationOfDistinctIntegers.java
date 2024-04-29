package org.example;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfDistinctIntegers {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer  = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        findPermutations(nums, isUsed, permutation, answer);
        System.out.println(answer);
        return answer;
    }

    public static void findPermutations(int[] nums, boolean[] isUsed,
                                 List permutation, List<List<Integer>> answer) {
        if (permutation.size() == nums.length) {
            answer.add(new ArrayList<>(permutation));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (isUsed[i] == false) {
                    isUsed[i] = true;
                    permutation.add(nums[i]);
                    findPermutations(nums, isUsed, permutation, answer);
                    isUsed[i] = false;
                    permutation.remove(permutation.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permute(nums);
    }
}
