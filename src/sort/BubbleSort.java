package sort;

import java.util.Arrays;

public class BubbleSort {

    static int count = 1;

    static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot)
                high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        count++;
        return low;
    }

    static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotLoc = partition(nums, low, high);
            System.out.println(Arrays.toString(nums));
            quickSort(nums, low, pivotLoc - 1);
            quickSort(nums, pivotLoc + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
        quickSort(nums, 0, nums.length - 1);
        System.out.println(count);
    }

}
