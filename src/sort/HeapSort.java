package sort;

import java.util.Arrays;

public class HeapSort {
    
    /**
     * 调整开始结点到最大结点使其满足大堆
     * startNode 从1开始不是0
     * list[0]用作缓存位置
     */
    static void heapAdjust(int[] list, int startNode, int maxNode) {
        list[0] = list[startNode]; // 将父结点缓存起来，用于后面的交换
        // 如果父结点需要交换，那么依次调整与他交换的子节点
        // 最大只交换到maxNode结点
        // 根据完全2叉树原理，如果一个结点是N，那么他的左右子结点是2*N,2*N+1
        for (int i = startNode * 2; i <= maxNode; i *= 2) {
            // 从2个子节点中选出最大的结点，记录下标
            // 这里没有等号，因为，有可能不存在右子结点
            if (i < maxNode && list[i] < list[i + 1]) {
                i++;
            }
            // 如果当前结点比大子结点都大，这次不需要交换
            // 那么说明已经满足大推，直接退出
            if (list[0] > list[i]) {
                break;
            }
            // 父结点与最大的子结点进行交换
            list[startNode] = list[i];
            startNode = i;
        }
        list[startNode] = list[0];
        System.out.println(Arrays.toString(list));
    }
    
    static void heapSort(int[] list) {
        // 第一次初始化大堆 
        for (int i = (list.length - 1) / 2; i > 0; i--) {
            heapAdjust(list, i, list.length - 1);
        }
        // 将大堆的根结点与最后的节子结点交换
        // 交换后重新调整大堆
        for (int i = list.length - 1; i > 1; i--) {
            int t = list[i];
            list[i] = list[1];
            list[1] = t;
            heapAdjust(list, 1, i - 1); // 最后一个不需要再次调整
        }
    }
    
    public static void main(String[] args) {
        int[] list = {-1, 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 }; // 原序列的0位置只存临时数据
        heapSort(list);
        System.out.println(Arrays.toString(list));
    }

}
