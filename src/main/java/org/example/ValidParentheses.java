package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        int [] arr = {1,2,3,4,5,6,7};
        arr = rotate(arr, 3);
        System.out.println(arr);
    }
    public static boolean isValid(String s) {
        if (s.length() <= 1)
            return false;
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char element = s.charAt(i);
            if (element == ']' || element == ')' || element == '}') {
                char topOfStack = charStack.empty() ? '0' :  charStack.pop();
                if (topOfStack == '(' && element != ')')
                    return false;
                if (topOfStack == '[' && element != ']')
                    return false;
                if (topOfStack == '{' && element != '}')
                    return false;
            } else {
                charStack.push(element);
            }
        }
        return charStack.empty();
    }

    public static int[] rotate(int[] nums, int k) {
        // If ka == nums.length, the rotation would result into same array
        k = k % nums.length;
        List<Integer> nums_rotated_superset = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());
        nums_rotated_superset.addAll(nums_rotated_superset);
        System.out.println(nums_rotated_superset);
        int midIndex = nums.length;
        List<Integer> answer = nums_rotated_superset.subList(midIndex-k, nums_rotated_superset.size()-k);
        return answer.stream().mapToInt(i->i).toArray();
    }
}
