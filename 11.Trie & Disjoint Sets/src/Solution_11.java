import java.util.ArrayList;
import java.util.List;

public class Solution_11 {

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        List<String> result = new ArrayList<>();
        // save all words into trie
        for (String word : words) {
            trie.insert(word);
        }
        if (board.length == 0) return result;
        //traverse from each cell, suppose the number of cells in each row is the same
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs_backtrack(board, i, j, trie.root, result);
            }
        }
        return result;
    }

    private void dfs_backtrack(char[][] board, int row, int col, TrieNode node, List<String> result) {
        // terminator
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        char cur = board[row][col]; // current char
        //if cur has been traversed or cannot find it in the Trie, return
        if (cur == '$' || node.children[cur - 'a'] == null) return;

        node = node.children[cur - 'a'];
        // if node is the end of a word
        if (node.word != null) {
            result.add(node.word);
            //remove the word
            node.word = null;
        }
        // set current cell as traversed
        board[row][col] = '$';
        // traverse to four ways
        dfs_backtrack(board, row - 1, col, node, result);
        dfs_backtrack(board, row + 1, col, node, result);
        dfs_backtrack(board, row, col - 1, node, result);
        dfs_backtrack(board, row, col + 1, node, result);

        //set back state
        board[row][col] = cur;
    }

    class TrieNode {
        public TrieNode[] children;
        public String word; // store current word has been found

        public TrieNode() {
            children = new TrieNode[26];
            word = null;
            for (int i = 0; i < 26; i++) {
                //initialize with null
                children[i] = null;
            }
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /* insert a word into the trie */
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            // save word in to leaf node
            node.word = word;
        }
    }
}