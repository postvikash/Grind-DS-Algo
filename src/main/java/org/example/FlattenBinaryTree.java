package org.example;

public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode tempRight = root.right;
        TreeNode templeft = root.left;
        root.left = null;
        flatten(templeft);
        flatten(templeft);
        root.right = templeft;
        TreeNode curr = templeft;
        while(curr.right != null)
            curr = curr.right;
        curr.right = tempRight;
    }
}
