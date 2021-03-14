##Amazon | OA (SDE experienced) Canada | Cloud Front Caching
###https://leetcode.com/discuss/interview-question/1061306/Amazon-or-OA-(SDE-experienced)-Canada-or-Cloud-Front-Caching
```
AWS CloudFront wants to build an algo to measure the efficiency of its caching network. The network is represented as a number of nodes and a list of connected pairs. The efficiency of this network can be estimated by first summing the cost of each isolated set of nodes where each individual node has a cost of 1. To account for the increase in efficiency as more nodes are connected, update the cost of each isolated set to be the ceiling of the square root of the original cost and return the final sum of all costs.

Example:
n = 10 nodes
edges = [[1 2] , [1 3] , [2 4] , [3 5] , [7 8]]

There are 2 isloated sets with more than one node {1,2,3,4,5} and {7,8}. The ceilings of their square roots are:
5^1/2 = 2.236 and ceil(2.236) = 3
2^1/2 = 1.414 and ceil(1.414) = 2

The other three isolated nodes are separate and the square root of their weights is 1^1/2 = 1 respectively.
The sum is 3+2+(3*1) = 8

Function Description
Complete the function connectedSum in the editor below

connectedSum has the following parameter(s):
int n: the number of nodes
str edges[m]: an array of strings that consist of a space-separated integer pain that denotes two connected nodes, p and q

Returns:
int: an integer that denotes the sum of the values calculated

Constraints:

2 <= n <= 10^5
1 <= m <=10^5
1 <= p,q <= n
p != n
Sample Input 0
n = 4 nodes
edges[] size m = 2
edges[] = [[1 2], [1 4]]

Sample Output 0
3

Explanation 0
The values to sum are:

Set {1,2,4}: c =ceil(sqrt(3)) = 2
Set {3}: c = ceil(sqrt(1)) = 1
2+1=3

Sample Input 1
n = 8 nodes
edges[] size m = 4
edges[] = [[8 1], [5 8], [7 3], [8 6]]

Sample Output 1
6

Explanation 1
The values to sum for each group are:

Set {2}: c =ceil(sqrt(1)) = 1
Set {4}: c = ceil(sqrt(1)) = 1
Set {1,5,6,8}: c = ceil(sqrt(4)) = 2
Set {3,7}: c = ceil(sqrt(2)) = 2
1+1+2+2 = 6
```
###Solution - BFS - 
```
class Sol {

    public int connectedSum(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        for (int[] edge : edges) {
            int node0 = edge[0] - 1, node1 = edge[1] - 1;
            if (!map.containsKey(node0)) map.put(node0, new ArrayList<>());
            if (!map.containsKey(node1)) map.put(node1, new ArrayList<>());
            map.get(node0).add(node1);
            map.get(node1).add(node0);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) res += bfs(i, map, visited);
        }
        return res;
    }

    private int bfs(int num, Map<Integer, List<Integer>> map, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(num);
        visited[num] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;
            List<Integer> list = map.get(cur);
            if (list != null && !list.isEmpty()) {
                for (int tmp : list) {
                    if (!visited[tmp]) {
                        queue.add(tmp);
                        visited[tmp] = true;
                    }
                }
            }
        }
        return (int) (Math.ceil(Math.sqrt(cnt)));
    }

//896
}

public class SolutionSpec {
    @Test
    public void testSolution() {
        Sol sol = new Sol();
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {7, 8}};
        int[][] edges2 = {{1, 2}, {1, 4}};
        int[][] edges3 = {{8, 1}, {5, 8}, {7, 3}, {8, 6}};
        Assert.assertEquals(sol.connectedSum(10, edges1), 8);
        Assert.assertEquals(sol.connectedSum(4, edges2), 3);
        Assert.assertEquals(sol.connectedSum(8, edges3), 6);
    }
}
```