package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        int[] nodeCountAtLevels = new int[10000];
        int [] sumAtSameLevel = new int[10000];
        inOrderTraversalWithLevelTracking(root, 0, nodeCountAtLevels, sumAtSameLevel);
        int idx = 0;
        ArrayList<Double> averageSumAtLevels = new ArrayList<>();
        while (nodeCountAtLevels[idx]!=0) {
            averageSumAtLevels.set(idx, (double)sumAtSameLevel[idx]/nodeCountAtLevels[idx]);
            idx++;
        }
        return averageSumAtLevels;
    }

    public void inOrderTraversalWithLevelTracking(TreeNode root, int level,
                                                  int[] nodeCountAtLevels,
                                                  int[] sumAtSameLevel) {
        if (root == null)
            return;
        inOrderTraversalWithLevelTracking(root.left, level+1, nodeCountAtLevels, sumAtSameLevel);
        nodeCountAtLevels[level] = nodeCountAtLevels[level]+1;
        sumAtSameLevel[level] = sumAtSameLevel[level] + root.val;
        inOrderTraversalWithLevelTracking(root.left, level+1, nodeCountAtLevels, sumAtSameLevel);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer  = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        findPermutations(nums, isUsed, permutation, answer);
        return answer;
    }

    public void findPermutations(int[] nums, boolean[] isUsed,
                                 List permutation, List<List<Integer>> answer) {
        if (permutation.size() == nums.length) {
            answer.add(permutation);
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
}
