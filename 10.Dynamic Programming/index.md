##Dynamic Programming
![Image of dynamic_programming](imgs/dynamic_programming.jpg)
![Image of dynamic_programming_key](imgs/dynamic_programming_key.jpg)
###Example 1 - Fibonacci
###Solution 1: Simple recursion will calculate lots of repeated value, time complexity: O(2^N)
![Image of dynamic_programming_fibonacci](imgs/dynamic_programming_fibonacci.jpg)
###Solution 2 - Add memorization for each value will eliminate repeated value, time complexity: O(N)
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
![Image of count_the_paths_dp_final](imgs/count_the_paths_dp_final.jpg)
### DP Summary
![Image of dp_summary](imgs/dp_summary.jpg)
