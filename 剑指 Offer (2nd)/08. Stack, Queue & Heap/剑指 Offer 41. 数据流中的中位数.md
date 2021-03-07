##剑指 Offer 41. 数据流中的中位数 - Hard - https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
###same as: https://leetcode-cn.com/problems/find-median-from-data-stream/
![img of offer 41](imgs/offer%2041.png)
![img of offer 41_I](imgs/offer%2041_I.png)
![img of offer 41_II](imgs/offer%2041_II.png)
###In a Min-Heap the key present at the root node must be less than or equal to among the keys present at all of its children.
###In a Max-Heap the key present at the root node must be greater than or equal to among the keys present at all of its children.
###Solution - Min-max heap - TC: findMedian-O(1), addNum-O(logN), SC: O(N)
```
class MedianFinder {

    Queue<Integer> minHeap, maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>(); // Min-Heap, keep greater numbers in the order
        maxHeap = new PriorityQueue<>((x, y) -> (y - x)); // Max-Heap, keep smaller number in the reverse order
    }

    public void addNum(int num) {
        // below code will keep size difference of A & B to be less than or equal to 1
        if (minHeap.size() != maxHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        return minHeap.size() != maxHeap.size() ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

}
```
![img of offer 41_3](imgs/offer%2041_3.png)