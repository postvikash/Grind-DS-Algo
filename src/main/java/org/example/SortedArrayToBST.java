package org.example;

public class SortedArrayToBST {

    public static void main(String[] args) {
        int[] nums = {1,2,3,5,9,32};
        TreeNode root = sortedArrayToBST(nums);
        nums[0] = -1;
        TreeNode rootCorrupt = sortedArrayToBST(nums);
        preOrder(root);
        System.out.println(SameTree.isSameTree(root, rootCorrupt));
        InvertTree.invertTree(root);
        preOrder(root);
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return transformArrayToBST(nums, 0, nums.length -1);
    }

    public static TreeNode transformArrayToBST(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return null;
        int mid = (startIndex+endIndex)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = transformArrayToBST(nums, startIndex, mid-1);
        root.right = transformArrayToBST(nums, mid+1, endIndex);
        return root;
    }

    public static void preOrder(TreeNode root) {
        if (root == null)
            return;
        preOrder(root.left);
        System.out.println(root.val);
        preOrder(root.right);
    }
}

