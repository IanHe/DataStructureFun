import java.util.*;

/**
 * Difficulty: Medium
 * Name: Group Anagrams
 * Link: https://leetcode-cn.com/problems/group-anagrams/ or https://leetcode.com/problems/group-anagrams/
 */
public class Hash_GroupAnagram_Medium {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"
        }));

        System.out.println(groupAnagrams_1(new String[]{
                "eat", "tea", "tan", "ate", "nat", "bat"
        }));
    }

    /**
     * 1. Approach: Using Hash
     * 2. Time Complexity: O(M * N)
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        long[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Long, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            long hash = 1;
            for (char c : chars) {
                hash *= primes[c - 'a'];
            }
            List<String> list = map.get(hash);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(hash, list);
        }
        return new ArrayList(map.values());
    }

    /**
     * 1. Approach: Using Sorting
     * 2. Time Complexity: O(M N logN)
     */
    public static List<List<String>> groupAnagrams_1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = map.get(s);
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(s, list);
        }
        return new ArrayList<>(map.values());
    }

}
