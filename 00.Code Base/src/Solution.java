public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(new int[]{1, 3, 2, 3, 1}));
    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int mid = (start + end) >> 1;
        // total Count = (count of left half) + (count of right half) + merge count
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);

        // calculate merge count
        int[] tmp = new int[end - start + 1];
        int i = start;
        int t = start; // track index of left half: nums[start -> mid]
        int c = 0; //index for tmp array
        for (int j = mid + 1; j <= end; j++, c++) {
            // find i and j where nums[i] > nums[j]*2
            while (i <= mid && nums[i] <= 2 * (long) nums[j]) i++;
            // put nums before j into tmp array
            while (t <= mid && nums[t] < nums[j]) tmp[c++] = nums[t++];
            tmp[c] = nums[j];
            // because left half and right half are sorted already
            // so nums[i+1], nums[i+2]...nums[mid] will meet: nums[k] > 2 * nums[j]
            count += mid - i + 1;
        }
        // put the rest in left half into tmp array
        while (t <= mid) tmp[c++] = nums[t++];
        System.arraycopy(tmp, 0, nums, start, end - start + 1);
        return count;
    }
}
