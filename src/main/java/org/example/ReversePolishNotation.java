package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> expressionStack = new Stack<>();
        Set<String> opSet = new HashSet<>();
        opSet.add("*");opSet.add("/");opSet.add("-");opSet.add("+");
        for(int i = 0; i < tokens.length; i++) {
            String temp = tokens[i];
            if (opSet.contains(temp)) {
                int operand1 = Integer.valueOf(expressionStack.pop());
                int operand2 = Integer.valueOf(expressionStack.pop());
                int tempResult;
                switch (temp) {
                    case "+" :
                        tempResult = operand1+operand2;
                        break;
                    case "-" :
                        tempResult = operand1-operand2;
                        break;
                    case "*" :
                        tempResult = operand2*operand1;
                        break;
                    default :
                        tempResult = operand2/operand1;
                }
                expressionStack.push(String.valueOf(tempResult));
            } else
                expressionStack.push(tokens[i]);
        }
        return Integer.valueOf(expressionStack.pop());
    }
}
