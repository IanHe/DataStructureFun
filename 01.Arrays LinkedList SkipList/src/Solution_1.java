import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1 {
    public static void main(String[] args) {
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        int len = nums.length;
//        if (len < 3) return list;
//        Arrays.sort(nums);
//        for (int i = 0; i < len; i++) {
//            if (nums[i] > 0) break;
//            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate
//            int left = i + 1, right = len - 1;
//            while (left < right) {
//                int sum = nums[i] + nums[left] + nums[right];
//                if (sum == 0) {
//                    list.add(List.of(nums[i], nums[left], nums[right]));
//                    while (left < right && nums[left] == nums[left + 1]) left++; // skip left pointer duplicate
//                    while (left < right && nums[right] == nums[right - 1]) right--; // slip right pointer duplicate
//                    left++;
//                    right--;
//                } else if (sum < 0) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
//        return list;
//    }

    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}




