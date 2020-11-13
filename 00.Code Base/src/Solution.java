import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) return 0;
        Set<String> wordBank = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Set<String> left = new HashSet<>(), right = new HashSet<>();
        left.add(beginWord);
        right.add(endWord);
        int step = 1;
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.size() > right.size()) {
                Set<String> tmp = left;
                left = right;
                right = tmp;
            }

            Set<String> tmpLeft = new HashSet<>();
            for (String word : left) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char tmp = chs[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if(ch == tmp) continue;
                        chs[i] = ch;
                        String str = String.valueOf(chs);
                        if (wordBank.contains(str)) {
                            if (right.contains(str)) return step + 1;
                            if (visited.contains(str)) continue;
                            visited.add(str);
                            tmpLeft.add(str);
                        }
                    }
                    chs[i] = tmp;
                }
            }
            left = tmpLeft;
            step++;
        }
        return 0;
    }


    static class TreeNode {
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
}