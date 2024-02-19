package org.example;

import java.util.Stack;

class LowestCommonAncestor {
    public Stack<TreeNode> stack1 = new Stack<>();
    public Stack<TreeNode> stack2 = new Stack<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        storeInOrderPathOfNode(root, p, stack1);
        storeInOrderPathOfNode(root, q, stack2);
        return compareStacksAndFetchLCA();
    }

    public TreeNode compareStacksAndFetchLCA() {
        while(stack1.size() != stack2.size()) {
            if (stack1.size() > stack2.size())
                stack1.pop();
            else
                stack2.pop();
        }
        while(stack1.size() > 1) {
            if(stack1.peek() != stack2.peek()) {
                stack1.pop();
                stack2.pop();
                continue;
            }
            return stack1.pop();
        }
        return stack1.pop();
    }

    public void storeInOrderPathOfNode(TreeNode root, TreeNode p, Stack stack) {
        if(root == null)
            return;
        storeInOrderPathOfNode(root.left, p, stack);
        if(root == p) {
            stack.push(p);
            return;
        }
        if(stack.size() > 0) {
            stack.push(root);
            return;
        }
        storeInOrderPathOfNode(root.right, p, stack);
    }
}
