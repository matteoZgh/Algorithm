package sort;

public class ShellSort {

    public void sort(int[] nums) {
        shellByKnuth(nums);
    }

    private void shell(int[] nums) {
        for (int gap = nums.length >> 1; gap > 0; gap >>= 1) {
            shell0(nums, gap);
        }
    }

    private void shellByKnuth(int[] nums) {
        int gap = 1;

        while (gap < nums.length / 3) {
            gap = gap * 3 + 1;
        }

        for (; gap > 0; gap = (gap - 1) / 3) {
            shell0(nums, gap);
        }
    }

    private void shell0(int[] nums, int gap) {
        for (int i = gap; i < nums.length; i++) {
            int tmp = nums[i], j = i;
            for (; j > gap - 1 && tmp < nums[j - gap]; j -= gap) {
                nums[j] = nums[j - gap];
            }
            nums[j] = tmp;
        }
    }

}
