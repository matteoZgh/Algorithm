import sort.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,6,5,9,8,0,4};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
