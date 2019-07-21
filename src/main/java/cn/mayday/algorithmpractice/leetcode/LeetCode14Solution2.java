package cn.mayday.algorithmpractice.leetcode;


public class LeetCode14Solution2 {


    public static void main(String[] args) {
        String strs[] = {"flower", "flow", "flight"};
        String result = new LeetCode14Solution2().longestCommonPrefix(strs);
        System.out.println("++++++ Result = +++++" + result);

        String strs2[] = {"flower", "2flow", "2flight"};
        String result2 = new LeetCode14Solution2().longestCommonPrefix(strs2);
        System.out.println("++++++ Result = +++++" + result2);
    }

    /**
     * @param strs 测试数组
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        // 获取字符串数组中，最小长度
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }
        StringBuilder builder = new StringBuilder();
        getCommonChar(strs, builder, 0, minLength);
        return builder.toString();
    }

    /**
     * @param strs     原字符串数组
     * @param builder  保存相同字符
     * @param count    比较字符串位置
     * @param maxCount 最大比较字符串位置，避免数组越界
     */
    private void getCommonChar(String[] strs, StringBuilder builder, int count, int maxCount) {
        // 如果超过迭代次数，返回
        if (count == maxCount) {
            return;
        }
        // 比较对象都和数组中第一个字符串比较
        char firstStrChar = strs[0].charAt(count);
        // 标志位，判断所有字符串指定位置元素是否和第一个字符串元素相等
        boolean isSame = true;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].charAt(count) != firstStrChar) {
                isSame = false;
                break;
            }
        }
        if (isSame) {
            builder.append(firstStrChar);
            count++;
            getCommonChar(strs, builder, count, maxCount);
        }
    }
}
