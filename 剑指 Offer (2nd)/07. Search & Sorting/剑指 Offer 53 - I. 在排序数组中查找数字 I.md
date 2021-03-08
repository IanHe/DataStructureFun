##剑指 Offer 53 - I. 在排序数组中查找数字 I - Medium - https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
###same as: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
![img of offer 53](imgs/offer%2053_I.png)
###Solution 1 - Binary Search & Find Boundary - TC: O(log N), SC: O(1)
###https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solution/mian-shi-ti-53-i-zai-pai-xu-shu-zu-zhong-cha-zha-5/
```
    public int search(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if (j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }
```
###Solution 2 - Binary Search & Count - TC: O(log N), SC: O(1)
###https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solution/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-idi-gui-er/
```
    int count = 0;

    public int search(int[] nums, int target) {
        if(nums.length == 0) return 0;
        binarySearch(nums, 0, nums.length - 1, target);
        return count;
    }

    private void binarySearch(int[] nums, int start, int end, int target) {
        if (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == target) {
                count++;
                binarySearch(nums, start, mid - 1, target);
                binarySearch(nums, mid + 1, end, target);
            } else if (nums[mid] > target) {
                binarySearch(nums, start, mid - 1, target);
            } else {
                binarySearch(nums, mid + 1, end, target);
            }
        }
    }
```