package cn.mayday.algorithms.day20200113;

/**
 * 字符串的最大公因子
 * <p>
 * 题目总结：
 * 1、考查内容为 辗转相除大法
 * 2. 理解题目中除尽的含义
 * <p>
 * 解题思路中总结:
 * 1、根据题目，如果存在最大公约数，那么str1+str2 = str2+str1
 * 2、根据辗转相除法求得两个字符串长度的最大公约数
 * 3、截取字符串
 *
 * @author Mayday05
 * @date 2020/1/13 14:14
 */
public class Leetcode1071GcdOfStrings {

    public static void main(String[] args) {
        Leetcode1071GcdOfStrings object = new Leetcode1071GcdOfStrings();
        // test1
        System.out.println(object.gcdOfStrings("ABCABC","ABC"));
        // test2
        System.out.println(object.gcdOfStrings("ABABAB","ABAB"));
        // test3
        System.out.println(object.gcdOfStrings("LEET","CODE"));

    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    /**
     * 使用“辗转相除法”计算两个字符串长度的最大公约数
     * <p>
     * 欧几里德算法又称辗转相除法，是指用于计算两个正整数a，b的最大公约数。
     * 应用领域有数学和计算机两个方面。计算公式gcd(a,b) = gcd(b,a mod b)。
     *
     * @param length1
     * @param length2
     * @return
     */
    private int gcd(int length1, int length2) {
        if (length1 == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length1;
        }
        return gcd(length2, length1 % length2);
    }
}
