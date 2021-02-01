package sort;

import datastructure.queue.Heap;

public class HeapSort {

    public void sort(int[] nums) {
        Integer[] tmp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        Heap<Integer> heap = new Heap<>(tmp);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = heap.poll();
        }
    }

}
