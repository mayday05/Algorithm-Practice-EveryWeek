package cn.mayday.algorithms.day20191118;

import javafx.beans.binding.BooleanBinding;

import java.util.Stack;

/**
 * @author m12815
 * 有效的括号 Leedcode-20
 * 2019-11-18
 */
public class Leetcode20 {

    public static void main(String[] args) {
        Leetcode20 leedcode = new Leetcode20();
        if (leedcode.isValid("()")) {
            System.out.println(" +++ Success ++++");
        } else {
            System.out.println(" +++ Failed ++++");
        }

        if (leedcode.isValid("()[]{}")) {
            System.out.println(" +++ Success ++++");
        } else {
            System.out.println(" +++ Failed ++++");
        }

        if (!leedcode.isValid("(]")) {
            System.out.println(" +++ Success ++++");
        } else {
            System.out.println(" +++ Failed ++++");
        }

        if (leedcode.isValid("{[]}")) {
            System.out.println(" +++ Success ++++");
        } else {
            System.out.println(" +++ Failed ++++");
        }

        if (leedcode.isValid("(])")) {
            System.out.println(" +++ Success ++++");
        } else {
            System.out.println(" +++ Failed ++++");
        }
    }

    /**
     * 方案1： 入栈和出栈
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] array = s.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(' || array[i] == '{' || array[i] == '[') {
                // 入栈
                stack.push(array[i]);
                continue;
            }

            if (stack.empty()) {
                return false;
            } else if (checkSymbolValid((char) stack.peek(), array[i])) {
                // 出栈
                stack.pop();
            } else {
                return false;
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkSymbolValid(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        return false;
    }
}
