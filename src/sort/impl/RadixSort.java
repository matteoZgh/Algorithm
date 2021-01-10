package sort.impl;

import sort.Sort;
import utils.AlgorithmUtil;

import java.util.Arrays;

public class RadixSort implements Sort {

    @Override
    public void sort(int[] nums) {
        radix(nums);
    }

    private static void radix(int[] nums) {
        int[] count = new int[11];
        int[] result = new int[nums.length];

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }

        int times = 0;
        while (max > 0) {
            max /= 10;
            times++;
        }

        int tmp = 1;
        for (int i = 0; i < times; i++) {
            for (int num : nums) {
                int n = num / tmp % 10;
                count[n + 1]++;
            }

            for (int j = 1; j < count.length; j++) {
                count[j] += count[j - 1];
            }

            for (int j = nums.length - 1; j >= 0; j--) {
                int n = nums[j] / tmp % 10;
                result[--count[n + 1]]= nums[j];
            }

            tmp *= 10;
            Arrays.fill(count, 0);
            System.arraycopy(result, 0, nums, 0, result.length);
        }
    }

}
