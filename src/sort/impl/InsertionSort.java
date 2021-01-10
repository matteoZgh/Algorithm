package sort.impl;

import sort.Sort;

public class InsertionSort implements Sort {

    @Override
    public void sort(int[] nums) {
        insertion(nums);
    }

    private static void insertion(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i], j = i;
            for (; j > 0 && tmp < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = tmp;
        }
    }

}
