import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;

import static org.testng.Assert.*;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();
        assertEquals(sol.racecar(6), 5);
    }
}

class Solution {

    public int racecar(int target) {
        //处理边界
        if (target <= 0) return 0;

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= target; i++) {
            //先向前走 forward 步
            for (int forward = 1; (1 << forward) - 1 < 2 * i; forward++) {
                //向前走了forwardDistance: (2 ^ forward) - 1
                int forwardDistance = (1 << forward) - 1;
                //对应第一种情况，走了forward步直接到达i
                if (forwardDistance == i) {
                    dp[i] = forward;
                } else if (forwardDistance > i) { //对应第二种情况，越过了i
                    // +1 是因为回头需要一个R指令
                    dp[i] = Math.min(dp[i], forward + 1 + dp[forwardDistance - i]);
                } else { //对应第三种情况，没有越过i
                    //先回头走backward步
                    for (int backward = 0; backward < forward; backward++) {
                        int backwardDistance = (1 << backward) - 1;
                        //第一个+1是还没到达i，先回头，使用一个R
                        //第二个+1是回头走了backwardDistance，再使用R回头走向i
                        dp[i] = Math.min(dp[i], forward + 1 + backward + 1 + dp[i - forwardDistance + backwardDistance]);
                    }
                }
            }
        }
        return dp[target];
    }
}



