package sort.impl;

import sort.Sort;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] nums) {
        merge(nums, 0, nums.length);
    }

    private static void merge(int[] nums, int left, int right) {
        if (right - left <= 1)
            return;
        int mid = left + right >> 1;
        merge(nums, left, mid);
        merge(nums, mid, right);
        merge0(nums, left, mid, right);
    }

    private static void merge0(int[] nums, int left, int mid, int right) { ;
        int i = left, j = mid, k = 0;
        int[] tmp = new int[right - left];

        while (i < mid || j < right) {
            if (i < mid && (j == right || nums[i] <= nums[j])) {
                tmp[k++] = nums[i++];
            }
            if (j < right && (i == mid || nums[j] <= nums[i])) {
                tmp[k++] = nums[j++];
            }
        }

        System.arraycopy(tmp, 0, nums, left, right - left);
    }

}
