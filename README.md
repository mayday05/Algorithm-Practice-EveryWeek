# Algorithm-Practice-EveryWeek
Algorithm-Practice-EveryWeek-算法更新每周


## 2019-07-06 
　更新TopN算法 参考文章见算法总结

## 2019-07-21 ARTS算法练习更新

- Leetcode 14 最长公共前缀

## 2019-11-18 ARTS leedcode 20  有效的括号
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

