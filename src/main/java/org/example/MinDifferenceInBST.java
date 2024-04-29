package org.example;

import java.util.ArrayList;
import java.util.List;

public class MinDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> nodeValues = new ArrayList<>();
        customInOrderStore( root,  nodeValues);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nodeValues.size()-1; i++) {
            if (nodeValues.get(i+1) - nodeValues.get(i) < ans)
                ans = nodeValues.get(i+1) - nodeValues.get(i);
        }
        return ans;
    }

    public void customInOrderStore(TreeNode root, List nodeValues) {
        if (root == null)
            return;
        customInOrderStore(root.left, nodeValues);
        nodeValues.add(root.val);
        customInOrderStore(root.right, nodeValues);
    }
}
