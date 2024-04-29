package org.example;

import java.util.ArrayList;
import java.util.List;

public class ConcatNumRootToLeafAndSum {
    public int sumNumbers(TreeNode root) {
        List<Integer> concatNumLeafToRootList = new ArrayList<>();
        int sum = 0;
        concatNumRootToLeaf(root, 0, concatNumLeafToRootList);
        for (int i = 0; i < concatNumLeafToRootList.size(); i++) {
            sum = sum + concatNumLeafToRootList.get(i);
        }
        return sum;
    }

    public void concatNumRootToLeaf(TreeNode root, int concatNumber, List concatNumLeafToRootList) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            concatNumber = concatNumber*10 + root.val;
            concatNumLeafToRootList.add(concatNumber);
            return;
        }
        concatNumber = concatNumber*10 + root.val;
        concatNumRootToLeaf(root.left, concatNumber, concatNumLeafToRootList);
        concatNumRootToLeaf(root.right, concatNumber, concatNumLeafToRootList);

    }
}
