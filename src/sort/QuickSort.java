package sort;

import java.util.Arrays;

public class QuickSort {

    static int c = 0;

    static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean change = false;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int t = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = t;
                    change = true;
                }
                c++;
            }
            if (!change) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        nums = new int[] { 0, 1, 2, 8, 4, 5, 6, 7, 3, 9 };
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(c);
    }

}
