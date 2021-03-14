import jdk.dynalink.linker.ConversionComparator;
import org.testng.annotations.Test;

import java.util.*;


public class SolutionSpec {
    @Test
    public void testSolution() {
        Sol sol = new Sol();

        System.out.println(sol.coinChange(new int[]{1, 5, 6}, 10));
    }
}


class Sol {

    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void dfs(int[] coins, int index, int amount, int count) {
        if (index < 0) return;

        for (int c = amount / coins[index]; c >= 0; c--) {
            int leftAmount = amount - c * coins[index];
            int newCount = count + c;
            if (leftAmount == 0) {
                ans = Math.min(ans, newCount);
                break;//剪枝1
            }
            if (newCount + 1 >= ans) break; //剪枝2
            dfs(coins, index - 1, leftAmount, newCount);
        }
    }
//896
}
