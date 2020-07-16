/**
 * Difficulty: Easy
 * Name: Climbing Stairs
 * Link: https://leetcode-cn.com/problems/climbing-stairs/ or https://leetcode.com/problems/climbing-stairs/
 * 1. This is an application of Fibonacci
 * 2. Because you can only climb one or two step each time, so you can only reach the final n step from n-1 or n-2 step.
 * 3. F(n) = F(n-1) + F(n-2)
 */
public class Arrays_ClimbingStairs_Easy {
    public static void main(String[] args) {
        System.out.println(climbStairs_3(5));
    }

    /**
     * 1. Non-Recursion
     * 2. Time Complexity: O(n)
     * 3. Space Complexity: O(1)
     */
    public static int climbStairs_1(int n) {
        if (n <= 0) throw new IllegalArgumentException("steps cannot be less than or equal to 0");
        if (n == 1) return 1;
        if (n == 2) return 2;
        int fPrev = 1, fN = 2;
        for (int i = 3; i <= n; i++) {
            int temp = fN + fPrev;
            fPrev = fN;
            fN = temp;
        }
        return fN;
    }

    /**
     * 1. Recursion - bad way, easy to exceed the time limit
     * 2. Time Complexity: O(n^2)
     * 3. Space Complexity: O(1)
     */
    public static int climbStairs_2(int n) {
        if (n <= 1)
            return 1;
        if (n < 3)
            return n;
        return climbStairs_2(n - 1) + climbStairs_2(n - 2);
    }

    /**
     * 1. Tail Recursion - improved
     * 2. Time Complexity: O(n)
     * 3. Space Complexity: O(1)
     */
    public static int climbStairs_3(int n) {
        return tailRecursive(n, 1, 1);
    }

    private static int tailRecursive(int n, int a, int b) {
        if (n <= 1)
            return b;
        return tailRecursive(n - 1, b, a + b);
    }

}
