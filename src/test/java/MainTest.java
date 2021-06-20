import org.testng.annotations.Test;

import java.util.*;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();

    }
}

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        long[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Long, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            long hash = 1;
            for (char c : chars) {
                hash *= primes[c - 'a'];
            }
            List<String> list = map.getOrDefault(hash, new ArrayList<>());
            list.add(str);
            map.put(hash, list);
        }
        return new ArrayList(map.values());
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}