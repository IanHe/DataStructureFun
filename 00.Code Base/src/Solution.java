import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (set.size() == 0 || !set.contains(endWord)) return 0;

        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int len = beginWord.length();
        int step = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }

            Set<String> tmpVisited = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < len; i++) {
                    char origin = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (origin == c) continue;
                        chs[i] = c;
                        String tmpWord = String.valueOf(chs);
                        if (set.contains(tmpWord)) {
                            if (endSet.contains(tmpWord)) return step + 1;
                            if (!visited.contains(tmpWord)) {
                                tmpVisited.add(tmpWord);
                                visited.add(tmpWord);
                            }
                        }
                    }
                    chs[i] = origin;
                }
            }
            beginSet = tmpVisited;
            step++;
        }
    }

}
