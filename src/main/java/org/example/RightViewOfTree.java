package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RightViewOfTree {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> levelAndNode = new HashMap<>();
        customPostOrder(root, 0, levelAndNode);
        List<Integer> rightViewList = new ArrayList<>(levelAndNode.size());
        for (Map.Entry<Integer, Integer> entry : levelAndNode.entrySet()) {
            rightViewList.add(entry.getKey(), entry.getValue());
        }
        return rightViewList;
    }

    public void customPostOrder(TreeNode root, int level, Map<Integer, Integer> levelAndNode) {
        if (root == null)
            return;
        if (!levelAndNode.containsKey(level)) {
            levelAndNode.put(level, root.val);
        }
        customPostOrder(root.right, level+1, levelAndNode);
        customPostOrder(root.left, level+1, levelAndNode);
    }
}
