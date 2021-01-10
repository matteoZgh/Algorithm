package sort.impl;

import sort.Sort;
import utils.AlgorithmUtil;

public class BubbleSort implements Sort {

    @Override
    public void sort(int[] nums) {
        bubble(nums);
    }

    private static void bubble(int[] nums) {
        boolean flag;
        for (int i = nums.length - 1; i > 0; i--) {
            flag = false;
            for (int j = 0; j < i ; j++) {
                if (nums[j] > nums[j + 1]) {
                    AlgorithmUtil.swap(nums, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

}
