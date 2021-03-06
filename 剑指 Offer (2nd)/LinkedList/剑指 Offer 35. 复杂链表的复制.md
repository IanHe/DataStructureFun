##剑指 Offer 35. 复杂链表的复制 - Medium - https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
###https://leetcode-cn.com/problems/copy-list-with-random-pointer/
![image of offer 35](imgs/offer%2035.png)
###Solution 1 - DFS - TC: O(N), SC: O(N)
###https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/lian-biao-de-shen-kao-bei-by-z1m/
```
    public Node copyRandomList(Node head) {
        return dfs(head, new HashMap<>());
    }

    private Node dfs(Node node, Map<Node, Node> visited) {
        if (node == null) return null;
        if (visited.containsKey(node)) return visited.get(node);
        Node cp = new Node(node.val);
        visited.put(node, cp);
        cp.next = dfs(node.next, visited);
        cp.random = dfs(node.random, visited);
        return cp;
    }
```
###Solution 2 - BFS - TC: O(N), SC: O(N)
###https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/lian-biao-de-shen-kao-bei-by-z1m/
```
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cp = new Node(head.val);
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(head);
        Map<Node, Node> visited = new HashMap<>();
        visited.put(head, cp);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            if (tmp.next != null) {
                if (!visited.containsKey(tmp.next)) {
                    visited.put(tmp.next, new Node(tmp.next.val));
                    queue.add(tmp.next);
                }
                visited.get(tmp).next = visited.get(tmp.next);
            }
            if (tmp.random != null) {
                if (!visited.containsKey(tmp.random)) {
                    visited.put(tmp.random, new Node(tmp.random.val));
                    queue.add(tmp.random);
                }
                visited.get(tmp).random = visited.get(tmp.random);
            }
        }
        return cp;
    }
```
###Solution 3 - HashMap - TC: O(N), SC: O(N)
###https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/jian-zhi-offer-35-fu-za-lian-biao-de-fu-zhi-ha-xi-/
```
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }
```
![image of offer 35_I](imgs/offer%2035_I.png)