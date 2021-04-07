import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        MedianFinder mf = new MedianFinder();
        mf.addNum(6);
        System.out.println(mf.findMedian()); // 6
        mf.addNum(10);
        System.out.println(mf.findMedian()); // 8
        mf.addNum(2);
        System.out.println(mf.findMedian()); // 6
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(5);
        System.out.println(mf.findMedian());
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());

    }
}

class Solution {

}

class MedianFinder {
    List<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        this.list = new ArrayList<>();
    }

    public void addNum(int num) {
        this.list.add(num);
    }

    public double findMedian() {
        this.list.sort((a, b) -> a - b);
        int len = list.size();
        if (len % 2 == 1) {
            return list.get(len / 2);
        } else {
            return ((double) (list.get(len / 2 - 1) + list.get(len / 2))) / 2;
        }
    }
}