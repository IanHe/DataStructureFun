##Primitive Search(Simple Search)
![Image of primitive_search](imgs/primitive_search.jpg)
##Think Search as a State Tree - E.g: Coins Change, coins($1, $2, $5) to form $11
![Image of search_state_tree](imgs/search_state_tree.jpg)
##Pruning
![Image of tree_pruning](imgs/tree_pruning.jpg)
![Image of tic_tac_toe](imgs/tic_tac_toe.jpg)
![Image of tic_tac_toe_state](imgs/tic_tac_toe_state.jpg)
####The difficulty is the depth of the tree and hwo to prune. The depth of chess is 37, and every level there are 10 ways
![Image of chess](imgs/chess.jpg)
####the complexity is: 10^37, because pruning has been overcome, the chess is defeated by Deep Blue in 1996 
![Image of chess_state](imgs/chess_state.jpg)
![Image of back_track](imgs/back_track.jpg)
<br></br>
<br></br>
###BFS
![Image of bfs](imgs/bfs.jpg)
###Two-Ended BFS
![Image of bfs](imgs/bfs.jpg)
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