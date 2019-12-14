package cn.mayday.algorithms.day20190606;


/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LeetCode14 {


    public static void main(String[] args) {
        String strs[] = {"flower", "flow", "flight"};
        String result = new LeetCode14().longestCommonPrefix(strs);
        System.out.println("++++++ Result = +++++" + result);
    }

    /**
     * 时间复杂度
     * 获取长度为n，避免数组越界
     * for循环数组长度 for循环数组长度， n*n
     * <p>
     * 总的时间复杂度为n*n + n
     *
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

        // 比较数组中每一个元素是否相等
        for (int i = 0; i < minLength; i++) {
            // 比较对象都和数组中第一个字符串比较
            char firstStrChar = strs[0].charAt(i);
            // 标志位，判断所有字符串指定位置元素是否和第一个字符串元素相等
            boolean isSame = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != firstStrChar) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                builder.append(firstStrChar);
            } else {
                // 如果由一个元素不相等，跳出循环，没有必要继续下去
                break;
            }
        }
        return builder.toString();
    }
}
