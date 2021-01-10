package utils;

import sort.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 工具常量
 * 工具函数
 */
public class AlgorithmUtil {

    public static int[] getDisorderNums(int len, int bound) {
        int[] result = new int[len];
        Random random = new Random();
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(bound);
        }
        return result;
    }

    public static int[] getOrderNums(int len) {
        int[] result = new int[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    /**
     * 交换函数
     * @param nums 数组
     * @param a 位置1
     * @param b 位置2
     */
    public static void swapOld(int[] nums, int a, int b) {
        if (a == b)
            return;
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void swapNew(int[] nums, int a, int b) {
        /**
         * tmp的每一位记录nums[a]与nums[b]的每一位是否相同
         * 1代表相同 0代表不同
         * 例：nums[a] = 1011  nums[b] = 0101
         *    tmp = nums[a] ^ nums[b] = 0001
         *    1011 = 0001 ^ 0101
         *    0101 = 0001 ^ 1011
         */
        if (a == b)
            return;
        int tmp = nums[a] ^ nums[b];
        nums[b] = tmp ^ nums[b]; //nums[b] = nums[a]
        nums[a] = tmp ^ nums[b];
    }

    public static void swap(int[] nums, int a, int b) {
        if (a == b)
            return;
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    public static void check(int[] nums, Sort sort) {
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);

        long startTime = System.currentTimeMillis();
        sort.sort(nums);
        long endTime = System.currentTimeMillis();

        Arrays.sort(tmp);

        boolean res = true;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != tmp[i])
                res = false;
        }

        System.out.println(res + " " + (endTime - startTime) + "ms");
    }

    public static void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

}
