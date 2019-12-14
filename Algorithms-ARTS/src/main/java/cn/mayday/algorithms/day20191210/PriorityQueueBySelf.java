package cn.mayday.algorithms.day20191210;

import java.util.Arrays;

/**
 * @date 2019-12-10
 * <p>
 * 优先队列：基于二叉堆实现
 *
 * <p>
 * 常见题型：从10亿个元素中找出最大的10个
 */
public class PriorityQueueBySelf<E extends Comparable<E>> {

    /**
     * 数组存储
     */
    private int[] array;

    /**
     * 长度
     */
    private int size;

    public PriorityQueueBySelf() {
        this.array = new int[32];
    }

    public int size() {
        return this.size;
    }

    private void resize() {
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    /**
     * 入队
     *
     * @param key
     */
    public void enQueue(int key) {
        if (size >= array.length) {
            resize();
        }
        //入队时放在最后一个位置，并最后面一个元素开始上浮
        array[size++] = key;
        siftUp();
    }

    /**
     * 最后一个元素开始上浮
     * <p>
     * 步骤：与其父节点做比较，如果父节点小于当前元素的节点，置换位置
     */
    private void siftUp() {
        int childIndex = size - 1;
        int parentIndex = (size - 1) / 2;

        int tempForAdd = array[childIndex];
        while (childIndex > 0 && array[parentIndex] < tempForAdd) {
            // 更新子节点值为父亲节点值，父亲节点信息暂时不用更新，最后一把确认好位置更新即可
            array[childIndex] = array[parentIndex];

            childIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
        // 找到位置了，就是这里
        array[childIndex] = tempForAdd;
    }

    /**
     * 出列
     *
     * @throws Exception
     */
    private int deQueue() throws Exception {
        if (size <= 0) {
            throw new Exception("the queue is empty");
        }
        // 获取堆顶元素并最后一个元素上调到堆顶后开始调整下浮
        int head = array[0];
        array[0] = array[--size];
        siftDown();
        return head;
    }

    /**
     * 第一个元素开始下沉
     */
    private void siftDown() {
        int tempForDelete = array[0];
        int parentIndex = 0;
        int childIndex = 1;

        while (childIndex < size) {
            // 右孩子大于左孩子节点时，则下沉元素在右孩子节点
            if (childIndex < size - 1 && array[childIndex] < array[childIndex + 1]) {
                childIndex++;
            }
            // 如果待删除元素大于左或者右孩子节点，说明他就是最大节点
            if (tempForDelete >= array[childIndex]) {
                break;
            }
            // 父亲节点信息更新为子节点信息
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex; // 最后一个为父节点坐标
            // 下一个子节点下标
            childIndex = 2 * parentIndex + 1;
        }
        array[parentIndex] = tempForDelete;
    }

    /**
     * 测试main函数
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        PriorityQueueBySelf priorityQueueBySelf = new PriorityQueueBySelf();
        priorityQueueBySelf.enQueue(3);
        priorityQueueBySelf.enQueue(5);
        priorityQueueBySelf.enQueue(10);
        priorityQueueBySelf.enQueue(2);
        priorityQueueBySelf.enQueue(7);
        System.out.println("出队元素1： " + priorityQueueBySelf.deQueue());
        System.out.println("出队元素2： " + priorityQueueBySelf.deQueue());
        System.out.println("出队元素3： " + priorityQueueBySelf.deQueue());
        System.out.println("出队元素4： " + priorityQueueBySelf.deQueue());
        System.out.println("出队元素5： " + priorityQueueBySelf.deQueue());

    }
}
