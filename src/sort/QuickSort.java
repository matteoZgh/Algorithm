package sort;

public class QuickSort {

    public void sort(int[] nums) {
        quick(nums, 0, nums.length);
    }

    private void quick(int[] nums, int left, int right) {
        if (right - left <= 1)
            return;
        int mid = quick0(nums, left, right);
        quick(nums, left, mid);
        quick(nums, mid + 1, right);
    }

    private int quick0(int[] nums, int left, int right) {
        int point = right - 1, l = left, r = right - 2;
        while(l <= r) {
            while(l <= r && nums[l] <= nums[point]) l++;
            while(l <= r && nums[r] > nums[point]) r--;
            if (l < r)
                swap(nums, l ,r);
        }
        swap(nums, l, point);
        return l;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
