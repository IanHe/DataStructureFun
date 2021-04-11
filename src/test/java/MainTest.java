import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome("0P"));
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(arr[i])) i++;
            while (i < j && !Character.isLetterOrDigit(arr[j])) j--;
            if (arr[i] != arr[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}




