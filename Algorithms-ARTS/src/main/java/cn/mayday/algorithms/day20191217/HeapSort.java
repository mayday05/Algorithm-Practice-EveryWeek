package cn.mayday.algorithms.day20191217;

import java.util.Arrays;

/**
 * @author Mayday05
 * @date 2019/12/17 14:05
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {4, 2, 56, 7, 89, 34, 8};
        long t0 = System.currentTimeMillis();
        new HeapSort().heapSort(array);
        long t1 = System.currentTimeMillis();
        System.out.println((t1 - t0) + "ms");

        System.out.println("Sort result :" + Arrays.toString(array));
    }

    /**
     * 堆排序算法
     * 以从小到大排序为例
     * （1）首先对数组中所有的元素建立一个最大堆（需要从小到大排序就构建成最大堆，反之最小堆），
     * （2）然后依次推出栈顶的元素（最大的），重新建堆，直到堆中的元素为空。
     * <p>
     * 建立初始堆
     * 首末元素互换, 即得到最大元素放入数组最末尾.
     * 调整堆. 第二步的操作明显会将堆破坏, 所以需要调整堆.
     * 跳回第二步.
     *
     * @param array
     */
    public void heapSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        buildMaxHeap(array);
        System.out.println("Init result :" + Arrays.toString(array));

        for (int parentIndex = array.length - 1; parentIndex > 0; parentIndex--) {
            // 交换第一个元素和最后一个元素，其实就是将最大的元素放置到数组最后一位
            swap(array, parentIndex);
            // 调整堆，此处为下沉调整
            siftDown(array, parentIndex, array.length);
        }
    }

    /**
     * 建立最大二叉堆
     *
     * @param array
     */
    private void buildMaxHeap(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        // 步骤1：把无序数组构造成最大堆
        int half = array.length - 1 / 2; // 除以2的原因是，如果大于array.length/2的话，没有子接口无需下沉
        for (int currentIndex = half; currentIndex >= 0; currentIndex--) {
            siftDown(array, 0, currentIndex);
        }
    }

    /**
     * 第一个元素开始下沉
     */
    private void siftDown(int[] array, int parentIndex, int currentIndex) {
        int size = array.length;
        // 记录下沉前元素数值
        int tempForDelete = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;

        while (childIndex < currentIndex) {
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

    private void swap(int[] array, int parentIndex) {
        int temp = array[parentIndex];
        array[parentIndex] = array[0];
        array[0] = temp;
    }
}
