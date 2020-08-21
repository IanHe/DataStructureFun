public class Solution_10 {

    public static void main(String[] args) {
        Solution_10 solution = new Solution_10();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        return dfs(coins, amount, new int[amount]);
    }

    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // dfs函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int dfs(int[] coins, int amount, int[] memo) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        //retrieve from memo
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = dfs(coins, amount - coins[i], memo);
            if (res >= 0 && res < min) {
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }

}
