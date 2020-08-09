import java.util.ArrayList;
import java.util.List;

public class Solution_06 {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new Solution_06().subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }


    /*
        nums = [1, 2, 3]
        initialize List<List<Integer>> to be: [[]]
        get 1 out of nums => [[], [1]]
        get 2 out of nums => [[], [1], [2], [1, 2]]
        get 3 out of nums => [[], [1], [2], [1, 2], [3], [1,3], [2,3], [1, 2, 3]]
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<Integer>());

        for(int num: nums){
            List<List<Integer>> newSubsets = new ArrayList<>();

            for(List<Integer> cur : output){
                // make a copy of cur adding the num, [] => [[], [1]] => [[], [1], [2], [1, 2]]
               newSubsets.add(new ArrayList<>(cur){{add(num);}});
            }

            // add new subsets into output
            output.addAll(newSubsets);
        }

        return output;
    }
}
