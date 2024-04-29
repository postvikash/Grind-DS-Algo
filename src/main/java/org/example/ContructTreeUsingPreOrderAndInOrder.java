package org.example;

import java.util.HashMap;
import java.util.Map;

public class ContructTreeUsingPreOrderAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderIndicesMap = new HashMap<>();
        for(int i = 0; i< inorder.length; i++) {
            inOrderIndicesMap.put(inorder[i], i);
        }
        TreeNode root = splitTree(preorder, inOrderIndicesMap,
                0,0, inorder.length-1);
        return root;
    }

    public TreeNode splitTree(int[] preorder, Map<Integer, Integer> inOrderIndicesMap,
                              int rootIndex, int leftExtreme, int rightExtreme) {
        TreeNode root  = new TreeNode(preorder[rootIndex]);
        int rootIndexInInOrder = inOrderIndicesMap.get(root.val);
        if(rootIndexInInOrder > leftExtreme)
            root.left = splitTree(preorder, inOrderIndicesMap, rootIndex+1, leftExtreme, rootIndexInInOrder-1);
        if(rootIndexInInOrder < rightExtreme)
            root.right = splitTree(preorder, inOrderIndicesMap, rootIndex+rootIndexInInOrder-leftExtreme+1, rootIndexInInOrder+1, rightExtreme);
        return root;
    }
}
