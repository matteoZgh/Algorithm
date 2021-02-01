import checker.SortChecker;
import sort.QuickSort;
import algorithm.Algorithm;

public class Main {
    public static void main(String[] args) {
        int[] nums = Algorithm.getDisorderNums(100, 100);
        Algorithm.run(QuickSort.class, new SortChecker(), nums);
    }

}
