import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(sol.myAtoi("  -91283472ab12"));
    }
}

class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;
        char[] arr = s.toCharArray();
        int startIndex = 0;
        while (startIndex < arr.length && arr[startIndex] == ' ') startIndex++;
        if (startIndex >= arr.length) return 0;
        boolean sign = arr[startIndex] != '-';
        if (arr[startIndex] == '+' || arr[startIndex] == '-') startIndex++;
        int num = 0;
        int maxValueDivideTen = Integer.MAX_VALUE / 10;
        for (int i = startIndex; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                int digit = arr[i] - '0';
                if(num > maxValueDivideTen)
                    return sign? Integer.MAX_VALUE : Integer.MIN_VALUE;
                if (sign && num == maxValueDivideTen && digit >= 7)
                    return Integer.MAX_VALUE;
                if (!sign && num == maxValueDivideTen && digit >= 8)
                    return Integer.MIN_VALUE;
                num = num * 10 + digit;
            } else {
                // digit end, should return the number
                return sign ? num : -num;
            }
        }
        return sign ? num : -num;
    }


    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

