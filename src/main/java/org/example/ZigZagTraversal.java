package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<List<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> tempHolder = new ArrayList<>();
        stack1.push(root);
        while(!stack1.empty() || !stack2.empty()) {
            while(!stack1.empty()) {
                TreeNode temp1 = stack1.pop();
                tempHolder.add(temp1.val);
                if(temp1.left != null)
                    stack2.push(temp1.left);
                if(temp1.right != null)
                    stack2.push(temp1.right);
            }
            answer.add(new ArrayList<>(tempHolder));
            tempHolder.clear();
            while(!stack2.empty()) {
                TreeNode temp2 = stack2.pop();
                tempHolder.add(temp2.val);
                if(temp2.right != null)
                    stack1.push(temp2.right);
                if(temp2.left != null)
                    stack1.push(temp2.left);
            }
            answer.add(new ArrayList<>(tempHolder));
            tempHolder.clear();
        }
        return answer;
    }
}
