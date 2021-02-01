package other;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        return findK(nums, 0, nums.length - 1, k);
    }

    private int findK(int[] nums, int left, int right, int k) {
        int point = partition(nums, left, right);

        if (point == k - 1) {
            return nums[point];
        } else if (point > k - 1) {
            return findK(nums, left, point - 1, k);
        } else if (point < k - 1) {
            return findK(nums, point + 1, right, k);
        }

        return -1;
    }

    private int partition(int[] nums, int left, int right) {
        int l = left, r = right - 1;

        while (l <= r) {
            while (l <= r && nums[l] >= nums[right]) l++;
            while (l <= r && nums[r] < nums[right]) r--;
            if (l < r)
                swap(nums, l, r);
        }

        swap(nums, l, right);

        return l;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
