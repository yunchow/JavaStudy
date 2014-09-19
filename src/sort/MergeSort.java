package sort;

import java.util.Arrays;

public class MergeSort {
    /**
     * �鲢���� ���:�����������������ϣ������ϲ���һ���µ������
     * ���Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ������������ ʱ�临�Ӷ�ΪO(nlogn) �ȶ�����ʽ
     * 
     * @param nums ����������
     * @return �����������
     */
    public static int[] sort(int[] nums, int low, int high, String comment) {
        int mid = (low + high) / 2;
        // System.out.println(String.format("Left: low=%s, high=%d, mid=%d",
        // low, high, mid));
        if (low < high) {
            // ���
            sort(nums, low, mid, "left");
            // �ұ�
            sort(nums, mid + 1, high, "right");
            // ���ҹ鲢
            merge(nums, low, mid, high, comment);
        }
        return nums;
    }

    public static void merge(int[] nums, int low, int mid, int high, String comment) {
        System.out.println(String.format("%s: low=%s, high=%d, mid=%d", comment, low, high, mid));
        System.out.println(Arrays.toString(nums));
        int[] temp = new int[high - low + 1];
        int i = low;// ��ָ��
        int j = mid + 1;// ��ָ��
        int k = 0;

        // �ѽ�С�������Ƶ���������
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // �����ʣ�������������
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // ���ұ߱�ʣ�������������
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // ���������е�������nums����
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
        System.out.println(Arrays.toString(nums));
        System.out.println();
    }

    // �鲢�����ʵ��
    public static void main(String[] args) {

        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };

        MergeSort.sort(nums, 0, nums.length - 1, "Main");
        System.out.println(Arrays.toString(nums));
    }
}