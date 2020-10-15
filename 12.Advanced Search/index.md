##Primitive Search(Simple Search)
![Image of primitive_search](imgs/primitive_search.jpg)
##Think Search as a State Tree - E.g: Coins Change, coins($1, $2, $5) to form $11
![Image of search_state_tree](imgs/search_state_tree.jpg)
##Tree Pruning - E.g: Fibanacci, memorization is a way of pruning
![Image of tree_pruning](imgs/tree_pruning.jpg)
###Think about tree state of Tic_Tac_Toe game
![Image of tic_tac_toe](imgs/tic_tac_toe.jpg)
![Image of tic_tac_toe_state](imgs/tic_tac_toe_state.jpg)
###Why Tree Pruning? - the depth and width of the tree can be extremely huge 
####The difficulty is the depth of the tree and hwo to prune. The depth of chess is 37, and every level there are 10 ways
![Image of chess](imgs/chess.jpg)
####the complexity is: 10^37, because pruning has been overcome, the chess is defeated by Deep Blue in 1996 
![Image of chess_state](imgs/chess_state.jpg)
###Backtrack is used a lot when playing chess game, but human brain is unable to backtrack deep depth.
![Image of back_track](imgs/back_track.jpg)
###Leetcode
####70. Climbing Stairs - easy - https://leetcode.com/problems/climbing-stairs/
####22. Generate Parentheses - Medium -- https://leetcode.com/problems/generate-parentheses/
####51. N-Queens - hard - https://leetcode.com/problems/n-queens/
####36. Valid Sudoku - medium - https://leetcode.com/problems/valid-sudoku/
####37. Sudoku Solver - hard - https://leetcode.com/problems/sudoku-solver/
<br></br>
<br></br>
###BFS
![Image of bfs](imgs/bfs.jpg)
###Two-Ended BFS
![Image of two_end_bfs](imgs/two_end_bfs.jpg)
###Leetcode
####127. Word Ladder - medium - https://leetcode.com/problems/word-ladder/
####126. Word Ladder II - hard - https://leetcode.com/problems/word-ladder-ii/
<br></br>
<br></br>
###Heuristic Search(A*) - 启发式搜索
####BFS can be improved 
![Image of bfs_improve](imgs/bfs_improve.jpg)
####Improve BFS by using something more intelligent - Priority Queue(with priority function)
![Image of bfs_priority_queue](imgs/bfs_priority_queue.jpg)
![Image of priority_function](imgs/priority_function.jpg)
####Example: Shorted Path - (Evaluation Function: e.g: Manhattan Distance)
![Image of shortest_path](imgs/shortest_path.jpg)
<br></br>
###Leetcode
####36. Valid Sudoku - medium - https://leetcode.com/problems/valid-sudoku/
####37. Sudoku Solver - hard - https://leetcode.com/problems/sudoku-solver/
####127. Word Ladder - medium - https://leetcode-cn.com/problems/word-ladder/
####773. Sliding Puzzle - hard - https://leetcode.com/problems/sliding-puzzle/
####1091. Shortest Path in Binary Matrix - medium -  https://leetcode.com/problems/shortest-path-in-binary-matrix/