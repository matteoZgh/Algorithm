package other;

import java.util.Random;

public class Shuffle {
    public void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = nums.length; i > 1; i--) {
            swap(nums, i - 1, random.nextInt(i));
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
