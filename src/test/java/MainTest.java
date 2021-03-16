import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.HashMap;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        System.out.println(Integer.pa);
    }
}

class Solution {
    public int numDecodings(String s) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return getAns(s.toCharArray(), 0, memo);
    }

    private int getAns(char[] chs, int start, HashMap<Integer, Integer> memo) {
        if (start == chs.length) {
            return 1;
        }
        if (chs[start] == '0') {
            return 0;
        }
        //判断之前是否计算过
        int m = memo.getOrDefault(start, -1);
        if (m != -1) {
            return m;
        }
        int ans1 = getAns(chs, start + 1, memo);
        int ans2 = 0;
        if (start < chs.length - 1) {
            int ten = (chs[start] - '0') * 10;
            int one = chs[start + 1] - '0';
            if (ten + one <= 26) {
                ans2 = getAns(chs, start + 2, memo);
            }
        }
        //将结果保存
        memo.put(start, ans1 + ans2);
        return ans1 + ans2;
    }

}