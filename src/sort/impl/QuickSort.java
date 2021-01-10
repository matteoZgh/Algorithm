package sort.impl;

import sort.Sort;
import utils.AlgorithmUtil;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] nums) {
        quick(nums, 0, nums.length);
    }

    private static void quick(int[] nums, int left, int right) {
        if (right - left <= 1)
            return;
        int mid = quick0(nums, left, right);
        quick(nums, left, mid);
        quick(nums, mid + 1, right);
    }

    private static int quick0(int[] nums, int left, int right) {
        int point = right - 1, l = left, r = right - 2;
        while(l <= r) {
            while(l <= r && nums[l] <= nums[point]) l++;
            while(l <= r && nums[r] > nums[point]) r--;
            if (l < r)
                AlgorithmUtil.swap(nums, l ,r);
        }
        AlgorithmUtil.swap(nums, l, point);
        return l;
    }

}
