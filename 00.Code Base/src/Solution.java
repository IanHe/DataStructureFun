import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        if (s.length() <= 1) return s;
        char[] chs = new char[s.length()];
        int i = 0;
        while (i < s.length()) {
            int start = i;
            while (i < s.length() && s.charAt(i) != ' ') i++; //find word boundary
            int p = start;
            for (; p < i; p++) {
                chs[p] = s.charAt(start + i - 1 - p);
            }
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
                chs[p++] = ' ';
            }
        }
        return String.valueOf(chs);
    }



}
