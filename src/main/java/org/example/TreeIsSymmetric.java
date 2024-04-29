package org.example;

import java.util.ArrayList;
import java.util.List;

public class TreeIsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        customInOrderStore(root, inOrderList);
        invertTree(root);
        List<Integer> inOrderListOfMirror = new ArrayList<>();
        customInOrderStore(root.right, inOrderListOfMirror);
        for (int i = 0; i < inOrderList.size(); i++) {
            if (inOrderList.get(i) != inOrderListOfMirror.get(i))
                return false;
        }
        return true;
    }

    public void customInOrderStore(TreeNode root, List inOrderList) {
        if (root == null)
            return;
        customInOrderStore(root.left, inOrderList);
        System.out.println(inOrderList);
        inOrderList.add(root.val);
        customInOrderStore(root.right, inOrderList);
    }

    public void invertTree(TreeNode root) {
        if (root == null)
            return;
        invertTree(root.left);
        invertTree(root.right);
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }
}
