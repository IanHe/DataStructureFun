##Sorting Algorithm - Reading
####https://www.cnblogs.com/onepixel/p/7674659.html - 十大经典排序算法（动图演示）
####https://www.bilibili.com/video/av25136272       - 简单明了】9种经典排序算法可视化动画
####https://www.bilibili.com/video/av63851336       - 6分钟看完15种排序算法动画展示
<br></br>
###Sorting Algorithm - Classfication
![Image of /sorting_classification](imgs//sorting_classification.jpg)
![Image of /sorting_classification_1](imgs//sorting_classification_1.jpg)
###Sorting Complexity (Very familiar with O(nlogn)-Sorting: Quick Sorting, Merge Sorting, Heap Sorting)
![Image of /sorting_complexity](imgs//sorting_complexity.jpg)
<br></br>
## Elementary Sorting Algorithms - Time Complexity:O(n^2)
![Image of /elementary_sorting](imgs//elementary_sorting.jpg)
<br></br>
## Advanced Sorting
###Quick Sort
![Image of /quick_sort](imgs//quick_sort.jpg)
![Image of /quick_sort_1](imgs//quick_sort_1.jpg)
###Merge Sort
![Image of /quick_sort](imgs//merge_sort.jpg)
![Image of /quick_sort_1](imgs//merge_sort_1.jpg)
####Note: Three While Loops to merge 2 sorted arrays
####First while loop => when the first while loop is finished: i or j index will be finished
####The rest two while loops => if i is not finished put the rest of i arrays into temp or if j is not finished...
![Image of /quick_sort_2](imgs//merge_sort_2.jpg)
###Quick Sort vs Merge Sort
![Image of /quick_vs_merge_sort](imgs//quick_vs_merge_sort.jpg)
<br></br>
##Heap Sort - We can use priority queue instead of self-defined heap
```
    public void sort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int length, int i) {
        int largest = i;  // Initialize largest as root
        int left = 2 * i + 1, right = 2 * i + 2;  

        // If left child is larger than root
        if (left < length && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < length && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, length, largest);
        }
    }
```
<br></br>
##Special Sorting
![Image of /special_sorting](imgs//special_sorting.jpg)
<br></br>
###Leetcode:
####1122. Relative Sort Array - easy - https://leetcode.com/problems/relative-sort-array/
####242. Valid Anagram - easy - https://leetcode.com/problems/valid-anagram/
####https://leetcode-cn.com/problems/design-a-leaderboard/
####56. Merge Intervals - medium - https://leetcode.com/problems/merge-intervals/
####剑指 Offer 51. 数组中的逆序对 - hard - https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
####493. Reverse Pairs - hard - https://leetcode.com/problems/reverse-pairs/
