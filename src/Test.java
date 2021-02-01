import sort.QuickSort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3,6,5,9,0,8,4,7};
        QuickSort sort = new QuickSort();
        sort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
