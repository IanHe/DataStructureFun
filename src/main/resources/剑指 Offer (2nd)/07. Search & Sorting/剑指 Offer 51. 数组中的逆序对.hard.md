##剑指 Offer 51. 数组中的逆序对 - hard - https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
```
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

 

示例 1:

输入: [7,5,6,4]
输出: 5

 

限制：

0 <= 数组长度 <= 50000
```
###Solution - Merge Sort - TC: O(N logN), SC: O(N)
###https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/jian-zhi-offer-51-shu-zu-zhong-de-ni-xu-pvn2h/
```
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int l, int r) {
        if (l >= r) return 0; //终止条件： 当 l ≥ r 时，代表子数组长度为 1 ，此时终止划分
        int m = (l + r) / 2; // 递归划分
        int res = mergeSort(nums, l, m) + mergeSort(nums, m + 1, r);
        res += merge(nums, l, m, r);
        return res;
    }

    private int merge(int[] arr, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int count = 0;
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else {
                tmp[k++] = arr[j++];
                // count inversion, once arr[i] > arr[j], then a[i+1], a[i+2],...a[mid] > a[j], so inversionCount += (mid-i) + 1
                count += mid - i + 1;
            }
        }
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= end) tmp[k++] = arr[j++];

        System.arraycopy(tmp, 0, arr, start, tmp.length);
        return count;
    }
```
![img of offer 51_1](imgs/offer%2051_1.png)