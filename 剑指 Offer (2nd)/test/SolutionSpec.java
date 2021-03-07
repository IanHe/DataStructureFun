import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;


public class SolutionSpec {

    @Test
    public void testSolution() {
        Sol sol = new Sol();
        System.out.println(sol.translateNum(12258));
        Assert.assertEquals(sol.translateNum(12258), 5);
    }
}


class Sol {

    /*
        dp[0] = 1
        dp[1] = 1
        dp[i] = 10 < f(i-1, i) < 26 ? dp[i-1] + dp[i-2] : dp[i-1]
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int pre = 1, cur = 1;
        for (int i = 2; i <= str.length(); i++) {
            String sub = str.substring(i - 2, i);
            int c = (sub.compareTo("10") >= 0 && sub.compareTo("25") <= 0) ? pre + cur : cur;
            pre = cur;
            cur = c;
        }
        return cur;
    }


//896
}
