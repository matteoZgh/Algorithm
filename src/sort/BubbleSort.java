package sort;

public class BubbleSort {

    public void sort(int[] nums) {
        boolean flag;
        for (int i = nums.length - 1; i > 0; i--) {
            flag = false;
            for (int j = 0; j < i ; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
