package sort;

import java.util.Arrays;

public class HeapSort {
    
    /**
     * ������ʼ��㵽�����ʹ��������
     * startNode ��1��ʼ����0
     * list[0]��������λ��
     */
    static void heapAdjust(int[] list, int startNode, int maxNode) {
        list[0] = list[startNode]; // ������㻺�����������ں���Ľ���
        // ����������Ҫ��������ô���ε��������������ӽڵ�
        // ���ֻ������maxNode���
        // ������ȫ2����ԭ�����һ�������N����ô���������ӽ����2*N,2*N+1
        for (int i = startNode * 2; i <= maxNode; i *= 2) {
            // ��2���ӽڵ���ѡ�����Ľ�㣬��¼�±�
            // ����û�еȺţ���Ϊ���п��ܲ��������ӽ��
            if (i < maxNode && list[i] < list[i + 1]) {
                i++;
            }
            // �����ǰ���ȴ��ӽ�㶼����β���Ҫ����
            // ��ô˵���Ѿ�������ƣ�ֱ���˳�
            if (list[0] > list[i]) {
                break;
            }
            // ������������ӽ����н���
            list[startNode] = list[i];
            startNode = i;
        }
        list[startNode] = list[0];
        System.out.println(Arrays.toString(list));
    }
    
    static void heapSort(int[] list) {
        // ��һ�γ�ʼ����� 
        for (int i = (list.length - 1) / 2; i > 0; i--) {
            heapAdjust(list, i, list.length - 1);
        }
        // ����ѵĸ���������Ľ��ӽ�㽻��
        // ���������µ������
        for (int i = list.length - 1; i > 1; i--) {
            int t = list[i];
            list[i] = list[1];
            list[1] = t;
            heapAdjust(list, 1, i - 1); // ���һ������Ҫ�ٴε���
        }
    }
    
    public static void main(String[] args) {
        int[] list = {-1, 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 }; // ԭ���е�0λ��ֻ����ʱ����
        heapSort(list);
        System.out.println(Arrays.toString(list));
    }

}
