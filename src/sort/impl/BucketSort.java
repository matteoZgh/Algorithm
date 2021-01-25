package sort.impl;

import sort.Sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort implements Sort {

    @Override
    public void sort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int value : nums) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        int bucketNum = (max - min) / nums.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);

        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }

        for (int value : nums) {
            int num = (value - min) / (nums.length);
            bucketArr.get(num).add(value);
        }

        for (ArrayList<Integer> integers : bucketArr) {
            Collections.sort(integers);
        }

        int index = 0;
        for (ArrayList<Integer> integers : bucketArr) {
            for (Integer integer : integers) {
                nums[index] = integer;
                index++;
            }
        }
    }

}
