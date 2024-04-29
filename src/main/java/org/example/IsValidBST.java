package org.example;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    public static boolean isValidBST(TreeNode root) {
        List<Integer> store = new ArrayList<>(2000);
        customInOrderTraversal(root, store);
        customInOrderTraversal(root, store);
        return true;
    }

    public static void customInOrderTraversal(TreeNode root, List store) {
        if (root == null)
            return;
        customInOrderTraversal(root.left, store);
        store.add(root.val);
        customInOrderTraversal(root.right, store);
    }

}
