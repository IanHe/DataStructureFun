import java.util.ArrayDeque;
import java.util.Deque;

public class Solution18 {
    public static void main(String[] args) {
        Solution18 solution = new Solution18();
        System.out.println(solution.reverseWords("    "));
    }

    /*
        word begin: if(prev == ' ' and cur ! = ' ' or cur != ' ' && cur index = 0) wordBegin = wordEnd = cur Index
        loop when cur != ' ' endIndex++
        word end: cur == ' '
     */
    public String reverseWords(String s) {
        Deque<String> deque = new ArrayDeque<>();
        int wordBegin = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == ' ') continue;
            // word begin
            if (i == 0 && s.charAt(i) != ' ' || s.charAt(i - 1) == ' ' && s.charAt(i) != ' ') {
                wordBegin = i;
            }
            // word end
            if ( (s.charAt(i) == ' ' && s.charAt(i - 1) != ' ')) {
                deque.offerFirst(s.substring(wordBegin, i));
                wordBegin = -1;
            }
            // s end
            if(i == s.length()-1 && wordBegin >= 0) {
                deque.offerFirst(s.substring(wordBegin));
            }

        }

        return String.join(" ", deque);
    }
}
