import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        levelOrder(root, 0, list);
        return list;
    }

    private void levelOrder(Node node, int depth, List<List<Integer>> list) {
        if (node == null) return;
        if (depth + 1 > list.size()) {
            list.add(new ArrayList<>());
        }

        list.get(depth).add(node.val);
        for (Node child : node.children) {
            levelOrder(child, depth + 1, list);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
