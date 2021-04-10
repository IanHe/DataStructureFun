import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        FreqStack freqStack = new FreqStack();
        freqStack.push(4); // The stack is [5]
        freqStack.push(0); // The stack is [5,7]
        freqStack.push(9); // The stack is [5,7,5]
        freqStack.push(3); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(2); // The stack is [5,7,5,7,4,5]
        System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        freqStack.push(6);
        System.out.println(freqStack.pop());   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        freqStack.push(1);
        System.out.println(freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        freqStack.push(1);
        System.out.println(freqStack.pop());   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
        freqStack.push(4);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}

class Solution {
}

class FreqStack {
    Map<Integer, Integer> freqs; // number and count map
    Map<Integer, Stack<Integer>> group; // req and numbers map
    int maxFreq; // maxFreq will only increase by 1

    public FreqStack() {
        freqs = new HashMap<>();
        group = new HashMap<>();
    }

    public void push(int val) {
        int newFreq = freqs.getOrDefault(val, 0) + 1;
        freqs.put(val, newFreq);
        if (newFreq > maxFreq) maxFreq = newFreq;
        group.computeIfAbsent(newFreq, z -> new Stack<>()).push(val);
    }

    public int pop() {
        Stack<Integer> nums = group.get(maxFreq);
        int num = nums.pop();
        if (nums.isEmpty()) maxFreq--;
        freqs.put(num, freqs.get(num) - 1);
        return num;
    }
}


//class FreqStack {
//    Map<Integer, Integer> freq;
//    Map<Integer, Stack<Integer>> group;
//    int maxfreq;
//
//    public FreqStack() {
//        freq = new HashMap<>();
//        group = new HashMap<>();
//        maxfreq = 0;
//    }
//
//    public void push(int x) {
//        int f = freq.getOrDefault(x, 0) + 1;
//        freq.put(x, f);
//        if (f > maxfreq)
//            maxfreq = f;
//
//        group.computeIfAbsent(f, z -> new Stack<>()).push(x);
//    }
//
//    public int pop() {
//        int x = group.get(maxfreq).pop();
//        freq.put(x, freq.get(x) - 1);
//        if (group.get(maxfreq).size() == 0)
//            maxfreq--;
//        return x;
//    }
//}



