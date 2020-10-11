##Not Quite Different between: Divide&Conquer, Backtrack, DFS and DP
![Image of difference](imgs/difference.jpg)<br></br>
![Image of dfs_template](imgs/dfs_template.jpg)<br></br>
![Image of dfs_tree](imgs/dfs_tree.jpg)<br></br>
![Image of divide&conque_template](imgs/divide&conque_template.jpg)<br></br>
##Dynamic Programming
![Image of think_in_dp](imgs/think_in_dp.jpg)
![Image of dynamic_programming](imgs/dynamic_programming.jpg)
![Image of dynamic_programming_key](imgs/dynamic_programming_key.jpg)
###How to resolve - DP
```
First: find the repeatability(divice)
Second: define state array - one dimension or two dimensions
Third: write down: DP Equation
```
###Example 1 - Fibonacci
###Solution 1: Simple recursion will calculate lots of repeated value, TC: O(2^N)
![Image of dynamic_programming_fibonacci](imgs/dynamic_programming_fibonacci.jpg)
###Solution 2 - Add Memorization/Tail Recursion will eliminate repeated value, TC: O(N)
![Image of dynamic_programming_fibonacci_memorization](imgs/dynamic_programming_fibonacci_memorization.jpg)
###Solution 3 - Bottom Up(iteration): f(0), f(1), f(0) + f(1) => f(2),..., f(n-2) + f(n-1) = f(n) 
###recursion is Top Down(D): f(n) = f(n-1) + f(n-2), f(n-1) = f(n-2) + f(n-3) ...
![Image of dynamic_programming_fibonacci_bottomUp](imgs/dynamic_programming_fibonacci_bottomUp.jpg)
<br></br>
<br></br>
###Example 2 - Count the paths
![Image of count_the_paths](imgs/count_the_paths.jpg)
###Solution 1: Divide + Memorization
![Image of count_the_paths_solution](imgs/count_the_paths_solution.jpg)
###Solution 2: Dynamic Programming - program from the end to the top
![Image of count_the_paths_dp](imgs/count_the_paths_dp.jpg)
### the paths to get to O(x, y) = O(x+1, y) + O(x, y+1), when meet the stone or hit the boundary O(x, y) = 0
### DP Function: if o(x,y) = 'empty': o(x,y) = o(x+1,y) + o(x,y+1); else: o(x,y) = 0;
![Image of count_the_paths_dp_final](imgs/count_the_paths_dp_final.jpg)
### DP Summary
![Image of dp_summary](imgs/dp_summary.jpg)
![Image of dp_solution](imgs/dp_solution.jpg)
<br></br>
<br></br>
### Leetcode:
####62. Unique Paths - medium - https://leetcode.com/problems/unique-paths/
####1143. Longest Common Subsequence - medium - http://leetcode.com/problems/longest-common-subsequence/
####120. Triangle - medium - https://leetcode.com/problems/triangle/
####53. Maximum Subarray - easy - https://leetcode.com/problems/maximum-subarray/
####152. Maximum Product Subarray - medium - https://leetcode.com/problems/maximum-product-subarray/
####322. Coin Change - medium - https://leetcode.com/problems/coin-change/
####198. House Robber - easy - https://leetcode.com/problems/house-robber/
####213. House Robber II - medium - https://leetcode.com/problems/house-robber-ii/
####121. Best Time to Buy and Sell Stock - easy - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
####122. Best Time to Buy and Sell Stock II - easy - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
####123. Best Time to Buy and Sell Stock III - hard - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/