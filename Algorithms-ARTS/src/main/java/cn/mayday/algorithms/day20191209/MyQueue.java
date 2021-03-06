package cn.mayday.algorithms.day20191209;

import java.util.Stack;

/**
 * Leetcode 232
 * 运行通过
 *
 */
public class MyQueue {

    /**
     * 入队列存储位置
     */
    private Stack<Integer> stackA = new Stack<>();
    /**
     * 出栈调整队列存储位置------相当于轮渡等船一样，到点了这批人先排个队。
     *
     * 注意1： 两个栈加起来才是最终队列元素
     */
    private Stack<Integer> stackB = new Stack<>();

    public MyQueue() {

    }

    /**
     * 入队
     *
     * @param x
     */
    public void push(int x) {
        stackA.push(x);
    }

    /**
     * 出队列
     *
     * @return
     */
    public int pop() {
        transform();
        // 出栈即可
        return stackB.pop();
    }

    /**
     * 取队列最后一个元素，但是不删除
     *
     * @return
     */
    public int peek() {
        transform();
        return stackB.peek();
    }

    /**
     * 转换函数
     */
    public void transform() {
        /**
         * B不为空时，说明上次过来排队的人还没有排完，继续按顺序排队消费即可
         */
        if (!stackB.isEmpty()) {
            return;
        }
        /**
         * 如果A本身就没人排队，也不需要转换
         */
        if (stackA.isEmpty()) {
            return;
        }
        // 将A中的所有信息都保存到B中，这样B中的最前面的信息就是A的先入队信息
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean empty() {
        /**
         * 注意必须两个栈都为空时才为空。
         */
        if (stackA.isEmpty() && stackB.isEmpty()) {
            return true;
        }
        return false;
    }
}
