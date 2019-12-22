package cn.mayday.algorithms.day20191222;

import java.util.Arrays;

/**
 * @description: 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * @author: mayday
 * @date: 2019/12/22 9:34
 * @version: 1.0
 *
 * 运行通过
 */
public class Leetcode108sortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        // 异常条件直接返回
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTreeLoop(nums, 0, nums.length - 1);
    }

    /**
     * 递归方法构造二叉树
     *
     * @param nums          原数组
     * @param leftPosition  左子树坐标
     * @param rightPosition 右子树坐标
     * @return 二叉平衡树根节点
     */
    private TreeNode buildTreeLoop(int[] nums, int leftPosition, int rightPosition) {
        // 递归结束条件
        if (leftPosition > rightPosition) {
            return null;
        }
        int middlePosition = leftPosition + (rightPosition - leftPosition) / 2;
        int value = nums[middlePosition];
        TreeNode root = new TreeNode(value);
        root.left = buildTreeLoop(nums, leftPosition, middlePosition - 1);
        root.right = buildTreeLoop(nums, middlePosition + 1, rightPosition);
        return root;
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
