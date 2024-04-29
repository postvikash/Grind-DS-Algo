package org.example;

import java.util.*;

public class BSTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null)
            return answer;
        if (root.right == null && root.left == null) {
            answer.add(Arrays.asList(root.val));
            return answer;
        }
        Map<Integer, List<Integer>> levelAndNodes = new HashMap<>();
        customPreOrderTraversal(root, 0, levelAndNodes);
        for (Map.Entry<Integer, List<Integer>> entry : levelAndNodes.entrySet()) {
            answer.add(entry.getKey(), entry.getValue());
        }
        return answer;
    }
    public void customPreOrderTraversal(TreeNode root, int level, Map<Integer, List<Integer>> levelAndNodes) {
        if (root == null)
            return;
        if (!levelAndNodes.containsKey(level)) {
            List<Integer> nodeList = new ArrayList<>();
            nodeList.add(root.val);
            levelAndNodes.put(level, nodeList);
        } else {
            List<Integer> nodes = levelAndNodes.get(level);
            nodes.add(root.val);
        }
        customPreOrderTraversal(root.left, level+1, levelAndNodes);
        customPreOrderTraversal(root.right, level+1, levelAndNodes);
    }
}
