package cn.mayday.algorithms.zhuanti.topN;

public class TopN {

    /**
     * 父节点
     *
     * @param n
     * @return
     */
    private int parent(int n) {
        return (n - 1) / 2;
    }

    /**
     * 左孩子
     *
     * @param n
     * @return
     */
    private int left(int n) {
        return 2 * n + 1;
    }

    /**
     * 右孩子
     *
     * @param n
     * @return
     */
    private int right(int n) {
        return 2 * n + 2;
    }

    /**
     * 构建小顶堆
     *
     * @param count 小顶堆个数
     * @param data  原数组
     */
    private void buildHeap(int count, int[] data) {
        for (int i = 1; i < count; i++) {
            int t = i;
            // 调整堆, 直到t等于0或者子节点比父节点大的话就跳出for循环
            while (t != 0 && data[parent(t)] > data[t]) {
                // 替换，如果当前数组元素比他父亲节点的要小
                int temp = data[t];
                data[t] = data[parent(t)];
                data[parent(t)] = temp;
                //
                t = parent(t);
            }
        }
    }

    /**
     * 调整data[i]
     *
     * @param i    待比较元素在数组下标
     * @param n    topN
     * @param data 原数组
     */
    private void adjust(int i, int n, int[] data) {
        // 如果data[i]比最小堆还要小，直接返回
        if (data[i] <= data[0]) {
            return;
        }
        // 置换堆顶
        int temp = data[i];
        data[i] = data[0];
        data[0] = temp;

        // 调整堆顶--需要再次将最大的元素放置到data[0]处
        int t = 0;
        // 如果左孩子坐标小于topN，且左孩子的数值比父节点还要小
        // 或者
        // 如果右孩子坐标小于topN，且右孩子的数值比父节点还有小
        while ((left(t) < n && data[left(t)] < data[t])
                || (right(t) < n && data[right(t)] < data[t])) {

            // 如果是情况2
            if (right(t) < n && data[right(t)] < data[left(t)]) {
                // 右孩子更小，置换右孩子
                temp = data[t];
                data[t] = data[right(t)];
                data[right(t)] = temp;
                t = right(t);
            } else { // 否则情况1
                // 否则置换左孩子
                temp = data[t];
                data[t] = data[left(t)];
                data[left(t)] = temp;
                t = left(t);
            }
        }
    }

    /**
     * 寻找topN，该方法改变data，将topN排到最前面
     *
     * @param n
     * @param data
     */
    private void findTopN(int n, int[] data) {
        // 先构建n个数的小顶堆
        buildHeap(n, data);
        // n往后的数进行调整
        for (int i = n; i < data.length; i++) {
            adjust(i, n, data);
        }
    }

    public static void main(String[] args) {
        int data[] = {2, 3, 4, 5, 6, 7, 7, 8, 9, 111};
        int count = 3;
        new TopN().findTopN(count, data);

        for (int i = 0; i < count; i++) {
            System.out.println(data[i]);
        }
    }
}
