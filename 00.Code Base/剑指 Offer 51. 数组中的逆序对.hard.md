##剑指 Offer 51. 数组中的逆序对 - hard - https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
```
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

 

示例 1:

输入: [7,5,6,4]
输出: 5

 

限制：

0 <= 数组长度 <= 50000
```
##Solution - Merge Sort - TC: O(N logN)
##Refer: https://blog.csdn.net/afei__/article/details/82951905 and https://www.nowcoder.com/questionTerminal/96bd6684e04a44eb80e6a68efc0ec6c5
```
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length);
    }

    private int mergeSort(int[] arr, int start, int end) {
        int inversionCount = 0;
        int len = end - start;
        if (len > 1) {
            int mid = (start + end) >> 1;
            inversionCount += mergeSort(arr, start, mid); // sort left
            inversionCount += mergeSort(arr, mid, end); // sort right
            inversionCount += merge(arr, start, mid, end);
        }
        return inversionCount;
    }

    private int merge(int[] arr, int start, int mid, int end) {
        int[] tmp = new int[end - start];
        int inversionCount = 0;
        int i = start; // 左半部分索引
        int j = mid; // 右半部分索引
        int k = 0; // temp数组索引
        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                // find inversion
                tmp[k++] = arr[j++];
                // once a[i] > arr[j], then a[i+1], a[i+2],...a[mid] > a[j], so inversionCount += (mid-i)
                inversionCount += mid - i;
            }
        }

        // if left half has rest items, copy into tmp
        if (i != mid) System.arraycopy(arr, i, tmp, k, mid - i);
        if (j != end) System.arraycopy(arr, j, tmp, k, end - j);

        // copy tmp to arr
        System.arraycopy(tmp, 0, arr, start, tmp.length);
        return inversionCount;
    }
```