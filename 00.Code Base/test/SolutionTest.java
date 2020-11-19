import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();

    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie.root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        char c = board[i][j];
        if (c == '$' || node.links[c - 'a'] == null) return;
        TrieNode nextNode = node.links[c - 'a'];
        if (nextNode.word != null) {
            result.add(nextNode.word);
            return;
        }
        board[i][j] = '$';
        dfs(board, i - 1, j, nextNode, result);
        dfs(board, i + 1, j, nextNode, result);
        dfs(board, i, j - 1, nextNode, result);
        dfs(board, i, j + 1, nextNode, result);
        //set state back
        board[i][j] = c;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.links[c - 'a'] == null) {
                node.links[c - 'a'] = new TrieNode();
            }
            node = node.links[c - 'a'];
        }
        node.word = word;
    }
}

class TrieNode {
    TrieNode[] links = new TrieNode[26];
    String word;
}