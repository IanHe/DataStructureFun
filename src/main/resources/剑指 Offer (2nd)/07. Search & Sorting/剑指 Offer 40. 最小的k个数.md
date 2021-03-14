##剑指 Offer 40. 最小的k个数 - Easy - https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
![img of offer 40](imgs/offer%2040.png)
###Solution - Quick Sort - TC:O(N), SC: O(N)
###https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/jian-zhi-offer-40-zui-xiao-de-k-ge-shu-j-9yze/
###Solution - (based on)Quick Sort - TC:O(N), SC: O(1)
```
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) return arr;
        return quickSort(arr, k, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int k, int left, int right) {
        int i = left, j = right;
        // set arr[left] as the flag, put all numbers less than arr[left] to the left, put numbers greater than arr[left] to the right
        while (i < j) {
            while (i < j && arr[j] >= arr[left]) j--;
            while (i < j && arr[i] <= arr[left]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, left);
        if (i > k) return quickSort(arr, k, left, i - 1);
        if (i < k) return quickSort(arr, k, i + 1, right);
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
```
![img of offer 40_I](imgs/offer%2040_I.png)