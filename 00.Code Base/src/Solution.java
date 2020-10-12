import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] charArr = new char[1][2];
        charArr[0][0] ='a';
        charArr[0][1] ='a';
        solution.findWords(charArr, new String[]{"aaa"}).forEach(System.out::println);
    }


    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0) return result;

        //store words in Trie
        for (String word : words) trie.insert(word);

        //traverse each cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs_backtrack(board, i, j, trie.root, result);
            }
        }
        return result;
    }

    private void dfs_backtrack(char[][] board, int x, int y, TrieNode node, List<String> result) {
        //terminator
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        char ch = board[x][y];
        // ch == '$' means ch has been visited before
        if (ch == '$' || node.children[ch - 'a'] == null) return;

        node = node.children[ch - 'a'];
        //if found a word
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        //traverse four directions, set current to be '$', otherwise child node will traverse back
        board[x][y] = '$';
        dfs_backtrack(board, x - 1, y, node, result);
        dfs_backtrack(board, x + 1, y, node, result);
        dfs_backtrack(board, x, y - 1, node, result);
        dfs_backtrack(board, x, y + 1, node, result);

        //set state back
        board[x][y] = ch;
    }

    static class TrieNode {
        public TrieNode[] children;
        public String word; // store word for leaf node

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            //store word on leaf node
            node.word = word;
        }
    }
}
