package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeVerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<int[]>> distNodeMap = new TreeMap<>();
        customPreOrder(root, 0, 0, distNodeMap);
        List<List<Integer>> ans = new ArrayList<>();
        for(Map.Entry<Integer, List<int[]>> entry : distNodeMap.entrySet()) {
            List<int[]> temp = entry.getValue();
            Collections.sort(temp, Comparator.comparingInt(i -> i[1]));
            ans.add(entry.getValue().stream().map(e->e[0]).collect(Collectors.toList()));
        }
        System.out.println(ans);
        return ans;

    }

    public void customPreOrder(TreeNode root, int hzDist, int level, Map<Integer, List<int[]>> distNodeMap) {
        if (root == null)
            return;
        if(distNodeMap.containsKey(hzDist))
            distNodeMap.get(hzDist).add(new int[]{root.val, level});
        else {
            List<int[]> nodeValList = new ArrayList<>();
            nodeValList.add(new int[]{root.val, level});
            distNodeMap.put(hzDist, nodeValList);
        }
        customPreOrder(root.left, hzDist-1, level+1, distNodeMap);
        customPreOrder(root.right, hzDist+1, level+1, distNodeMap);
    }
}