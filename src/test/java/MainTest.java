import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        String str = "catsandog";
        List<String> wordDict = List.of("cats", "dog", "an");
        System.out.println(sol.wordBreak(str, wordDict));
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}