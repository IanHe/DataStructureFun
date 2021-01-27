import org.testng.annotations.Test;

import java.util.*;

import org.testng.Assert;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();
        System.out.println(1 << 1);
        List<List<Integer>> res = sol.subsets(new int[]{1, 2, 3});
        Assert.assertNotEquals(res, null);
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        res.add(new ArrayList<>()); // add empty set
        dfs_backtrack(nums, res, path, 0);
        return res;
    }

    /*
        [] -> [][1] -> [][1] -> [][1][1, 2] -> [][1][1, 2][1, 2, 3] -> [][1][1, 2][1, 2, 3][1, 3]
        [][1][1, 2][1, 2, 3][1, 3] -> [][1][1, 2][1, 2, 3][1, 3][2] -> [][1][1, 2][1, 2, 3][1, 3][2][2, 3]
        [][1][1, 2][1, 2, 3][1, 3][2][2, 3] -> [][1][1, 2][1, 2, 3][1, 3][2][2, 3][3]
     */
    private void dfs_backtrack(int[] nums, List<List<Integer>> res, List<Integer> path, int startPos) {
        for (int i = startPos; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path)); // add to result set
            dfs_backtrack(nums, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}



