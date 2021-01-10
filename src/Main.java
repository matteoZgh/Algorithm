import sort.impl.*;
import utils.AlgorithmUtil;

public class Main {
    public static void main(String[] args) {
        int[] nums = AlgorithmUtil.getDisorderNums(90000, 10000);
        AlgorithmUtil.check(nums, new HeapSort());
    }
}
