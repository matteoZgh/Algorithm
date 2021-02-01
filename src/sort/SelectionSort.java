package sort;

public class SelectionSort {

    public void sort(int[] nums) {
        //最小值的位置
        int minIndex;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            // 找到最小值
            for (int j = minIndex + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            //将最小值放到数组首位
            if (minIndex != i)
                swap(nums, minIndex, i);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
