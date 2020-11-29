import org.testng.annotations.Test;

import java.util.*;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
    }
}

class Solution {
    public int reverseBits(int n) {
        int x = 0;
        for (int i = 31; n != 0; i--, n = n >>> 1) {
            x += (n & 1) << i;
        }
        return x;
    }
}


