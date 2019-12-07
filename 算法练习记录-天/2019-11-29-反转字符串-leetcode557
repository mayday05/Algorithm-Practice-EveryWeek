package cn.mayday.algorithms.day20191129;

import java.util.Stack;

/**
 * @date 20191129
 * leetcode 557 反转字符串中的单词III
 *
 * 每个单词由单个空格分隔，并且字符串中不会有任何额外的空格
 */
public class Leetcode557 {

    public static void main(String[] args) {
        if ("s'teL ekat edoCteeL tsetnoc".equals(new Leetcode557().reverseWords("Let's take LeetCode contest"))) {
            System.out.println("+++++++ test1 success ++++++++++");
        }

    }

    /**
     * 最先想到的方案1：
     * 入栈和出栈
     *
     *
     * 反转字符串中的单词
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s.isEmpty()) {
            return s;
        }
        // 按照空格将上述字符串分隔开来
        String array[] = s.split(" ");
        int length = array.length;
        Stack<String> stack = new Stack<String>();
        // 从最后一个数组入栈
        for (int i = length - 1; i >= 0; i--) {
            String str = array[i];
            for (int j = 0; j < str.length(); j++) {
                stack.push(String.valueOf(str.charAt(j)));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            String charTemp = stack.pop();
            result.append(charTemp);
        }
        return result.toString();
    }
}
