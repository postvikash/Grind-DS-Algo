package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SummaryRanges {
    public static void main(String [] args) {
        int [] nums = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums));
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> rangeList = new ArrayList<>(20);
        //Using stack data structure to compute the required ranges in single traversal of the list
        Stack<String> computeStack = new Stack<>();
        //Demarcates one range from another during computation
        String separator = "-";
        //Base condition 1. Return an empty list
        if (nums.length == 0) {
            return rangeList;
        }
        //Base condition 2. Return the only element as is.
        if (nums.length == 1) {
            rangeList.add(String.valueOf(nums[0]));
            return rangeList;
        }
        //Traverse the array from end and push elements to the stack.
        computeStack.add(String.valueOf(nums[nums.length-1]));
        for (int i = nums.length - 2; i >= 0; i--) {
            // If numbers are not contiguous, push separator in the stack
            if (nums[i+1] - nums[i] != 1)
                computeStack.push(separator);

            computeStack.push(String.valueOf(nums[i]));
        }
        StringBuffer sb = new StringBuffer();
        String top_of_stack = null;
        while (!computeStack.empty()) {
            if (computeStack.peek().equals(separator)) {
                if (sb.lastIndexOf(top_of_stack) == -1)
                    sb.append(top_of_stack);
                rangeList.add(sb.toString());
                computeStack.pop();
                sb.setLength(0);
            } else {
                top_of_stack = computeStack.pop();
                if (sb.length() == 0) {
                    sb.append(top_of_stack);
                } else if (sb.length() > 0 && sb.lastIndexOf("->") == -1) {
                    sb.append("->");
                }
            }
        }
        //Handling the last set of range here.
        if (sb.lastIndexOf(top_of_stack) == -1)
            sb.append(top_of_stack);
        rangeList.add(sb.toString());
        return rangeList;
    }
}
