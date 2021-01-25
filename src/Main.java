import sort.impl.*;
import utils.AlgorithmUtils;

public class Main {
    public static void main(String[] args) {
        int[] nums = AlgorithmUtils.getDisorderNums(10000, 10000);
        AlgorithmUtils.check(nums, new BubbleSort());
    }

}
