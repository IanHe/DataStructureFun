import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Difficulty: Easy
 * Name: Valid Parentheses
 * Link: https://leetcode-cn.com/problems/valid-parentheses or https://leetcode.com/problems/valid-parentheses/
 */
public class Stack_ValidParenthes_Easy {
    private static final Map<Character, Character> parentheses = new HashMap<>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
    }};

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}")); //true
        System.out.println(isValid("([)]")); //false
        System.out.println(isValid("")); //true
    }

    /**
     * 1. Approach: Stack
     * 2. Time Complexity: O(N), Space Complexity: O(N)
     */
    public static boolean isValid(String s) {
        if (s == null || s.length() == 1) return false;
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                if (parentheses.get(c) == null) return false;
                stack.push(parentheses.get(c));
            }
        }
        return stack.empty();
    }

    /**
     * improved version
     */
    public static boolean isValid_1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
