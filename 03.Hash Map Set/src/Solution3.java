import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution3 {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] nums = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                nums[strs[i].charAt(j) - 'a']++;
            }
            String hashed = "";
            for (int num: nums) {
                hashed = hashed + num + '#';
            }

            List<String> list = map.get(hashed);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(strs[i]);
            map.put(hashed, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
