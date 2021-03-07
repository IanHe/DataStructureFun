##剑指 Offer 45. 把数组排成最小的数 - Medium - https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
![img of offer 45](imgs/offer%2045.png)
###Solution 1 - Quick Sort - TC:O(N logN), SC: O(N)
###https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
```
    /*
        Quick Sort, rule:
        x + y > y + x => x is greater than y (y should be left on x)
        x + y < y + x => x is less than y (x should be left on y)
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s);
        return sb.toString();
    }

    private void quickSort(String[] strs, int l, int r) {
        if (l >= r) return;
        int pivot = r, counter = l;
        for (int i = l; i <= r; i++) {
            if ((strs[i] + strs[pivot]).compareTo(strs[pivot] + strs[i]) < 0) {
                swap(strs, i, counter);
                counter++;
            }
        }
        swap(strs, pivot, counter);
        quickSort(strs, l, counter - 1);
        quickSort(strs, counter + 1, r);
    }

    private void swap(String[] strs, int i, int j) {
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }
    
    //Improved version 
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String s : strs) sb.append(s);
        return sb.toString();
    }
```
###Solution 2 - Min-Heap - TC: O(N logN), SC: O(N)
###https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
```
    public String minNumber(int[] nums) {
        Queue<String> queue = new PriorityQueue<>((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        for (int num : nums) {
            queue.add(String.valueOf(num));
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            res.append(queue.poll());
        }
        return res.toString();
    }
```
![img of offer 45_1](imgs/offer%2045_1.png)