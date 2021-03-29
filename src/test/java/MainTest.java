import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        int[] nums = {-3, 0, 1, 2};
        System.out.println();
        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {

                System.out.println("hello");
            }
        };
        new Thread(r).start();
    }
}

class Solution {


    public String minWindow(String s, String t) {
        char[] sArr = s.toCharArray(), tArr = t.toCharArray();
        if (tArr.length == 0 || sArr.length < tArr.length) return "";

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(tArr[i], 0);
            dictT.put(tArr[i], count + 1);
        }

        int required = dictT.size();

        // Left and Right pointer
        int left = 0, right = 0;
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (right < sArr.length) {
            char c = sArr[right];
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = sArr[left];
                // Save the smallest window until now.
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c) < dictT.get(c)) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                left++;
            }

            // Keep expanding the window once we are done contracting.
            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}