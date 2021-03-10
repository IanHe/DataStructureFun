import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;


public class SolutionSpec {
    @Test
    public void testSolution() {
        Sol sol = new Sol();
        int[] res = new int[]{1, 1, 1, 2, 2, 2, 3, 3};
        System.out.println(sol.reverseWords("Let's take LeetCode contest"));
    }
}


class Sol {

    public String reverseWords(String s) {
        if (s.length() == 1) return s;
        char[] chs = s.toCharArray();
        int i = 0, j = 0;
        while (j < chs.length) {
            while (j < chs.length && chs[j] == ' ') j++;
            i = j;
            while (j < chs.length && chs[j] != ' ') j++;
            int left = i, right = j - 1;
            while (left < right) {
                char tmp = chs[left];
                chs[left++] = chs[right];
                chs[right--] = tmp;
            }
        }
        return String.valueOf(chs);
    }
//896
}
