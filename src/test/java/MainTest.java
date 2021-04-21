import org.testng.annotations.Test;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        System.out.println(sol.isMatch("aa", "a"));
    }
}

class Solution {

    public boolean isMatch(String s, String p) {
        char[] sArr = s.toCharArray(), pArr = p.toCharArray();
        int m = sArr.length, n = pArr.length;
        int iStar = -1, jStar = -1;
        int i = 0, j = 0;
        while (i < m) {
            if (j < n && (sArr[i] == pArr[j] || pArr[j] == '?')) {
                ++i;
                ++j;
            } else if (j < n && pArr[j] == '*') {
                iStar = i;
                jStar = j++;
            } else if (iStar >= 0) {
                i = ++iStar;
                j = jStar + 1;
            } else {
                return false;
            }
        }
        while (j < n && pArr[j] == '*') ++j;
        return j == n;
    }
}





