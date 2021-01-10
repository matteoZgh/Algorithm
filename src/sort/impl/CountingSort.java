package sort.impl;

import sort.Sort;

public class CountingSort implements Sort {

    @Override
    public void sort(int[] nums) {
        counting(nums);
    }

    private static void counting(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(num, max);
        }

        int[] count = new int[max + 2];

        for (int num : nums) {
            count[num + 1]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = count.length - 1; i > 0; i--) {
            for (; count[i] > count[i - 1]; count[i]--) {
                nums[count[i] - 1] = i - 1;
            }
        }
    }

}
