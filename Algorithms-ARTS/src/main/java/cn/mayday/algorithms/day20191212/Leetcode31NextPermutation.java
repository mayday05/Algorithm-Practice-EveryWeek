package cn.mayday.algorithms.day20191212;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Leetcode31NextPermutation {

    /**
     * 测试函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Leetcode31NextPermutation permutation = new Leetcode31NextPermutation();
        int[] nums1 = new int[]{1, 2, 3};
        permutation.nextPermutation(nums1);
        System.out.println("result1" + Arrays.toString(nums1)); // 1、3、2

        int[] nums2 = {3, 2, 1};
        permutation.nextPermutation(nums2);
        System.out.println("result２" + Arrays.toString(nums2)); // 1、2、3

        int[] nums3 = {1, 1, 5};
        permutation.nextPermutation(nums3);
        System.out.println("result３" + Arrays.toString(nums3)); // 1、5、1

        int[] nums4 = {1, 3, 2};
        permutation.nextPermutation(nums4);
        System.out.println("result３" + Arrays.toString(nums4)); // 2、1、3
    }

    /**
     * 实现方法
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        /**
         * 1 找到逆序区边界
         * 2 逆序区的前一个数值和逆序区最小值替换位置
         * 3 逆序区重排序
         */
        int length = nums.length;
        int reverseIndex = findReverseIndex(nums);
        // System.out.println("逆序索引：" + reverseIndex);

        if (reverseIndex == 0) {
            // 如果等于0，说明全部逆序，直接输出最小值即可
        } else {
            // 如果不等于0，将逆序区的前一位和逆序区中刚刚大于它的数值交换位置即可
            switchHeadNum(nums, reverseIndex);
        }

        // 冒泡排序--逆序区
        boolean isChanged = true;
        for (int i = reverseIndex; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    isChanged = false;
                }
            }
            if (isChanged) {
                break;
            }
        }
    }

    /**
     * 查询出现逆序时的前一个索引。也就是该索引后数据都是顺序
     *
     * @param nums
     * @return
     */
    private int findReverseIndex(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 交换第一个逆序和第一个比它大的数字位置
     *
     * @param nums
     * @param reverseIndex
     */
    private void switchHeadNum(int nums[], int reverseIndex) {
        int changedNum = nums[reverseIndex - 1];
        // 从逆序最后一个开始找，肯定能找到刚刚大于他的数字
        for (int i = nums.length - 1; i >= reverseIndex; i--) {
            if (nums[i] > changedNum) {
                nums[reverseIndex - 1] = nums[i];
                nums[i] = changedNum;
                break;
            }
        }
    }
}
