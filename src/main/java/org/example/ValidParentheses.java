package org.example;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
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
}
