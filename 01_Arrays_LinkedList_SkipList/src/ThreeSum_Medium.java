import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Difficulty: Medium
 * Name: 3Sum
 * Link: https://leetcode-cn.com/problems/3sum/or https://leetcode.com/problems/3sum/
 */
public class ThreeSum_Medium {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0, 0, 0, 0, 0, 0}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    /**
     * 1. Approach: Sort Array + Two Pointers
     * 2. Brute Force(Triple Loop) will bring Time Complexity O(N^3), Space Complexity O(1) which is completely unacceptable
     * 3. Sort Array: Time Complexity O(NlogN)
     * 4. Two Pointers: Time Complexity O(N^2), Space Complexity: O(1)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return list;
        Arrays.sort(nums);
        // i is the left boundary
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate
            int L = i + 1; // left pointer
            int R = len - 1; // right pointer
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // skip left pointer duplicate
                    while (L < R && nums[R] == nums[R - 1]) R--; // slip right pointer duplicate
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else R--;
            }
        }
        return list;
    }

    /**
     * The fastest coding
     */
    public static List<List<Integer>> threeSum_quickest(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {
            return ans;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // int negCount = 0, posCount = 0, zeroCount = 0;
        int[] count = new int[2];
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);

            if (n != 0) {
                count[n >>> 31]++;
            }
            // if (n > 0) {
            //     posCount++;
            // } else if (n < 0) {
            //     negCount++;
            // } else {
            //     zeroCount++;
            // }
        }
        int negCount = count[1], posCount = count[0], zeroCount = nums.length - negCount - posCount;
        if (zeroCount >= 3) {
            ans.add(Arrays.asList(0, 0, 0));
        }
        // 如果没有负数或没有正数
        if (negCount == 0 || posCount == 0) {
            return ans;
        }

        // 如果max/min的绝对值超过了另一边的两倍，将其设置为另一边的两倍，省掉了超界的部分
        if ((min << 1) + max > 0) {
            max = -min << 1;
        } else if ((max << 1) + min < 0) {
            min = -max << 1;
        }

        // 类似游标数组，n对应下标为n-min
        int[] map = new int[max - min + 1];
        int[] negs = new int[negCount];
        int[] poses = new int[posCount];
        negCount = 0;
        posCount = 0;
        for (int n : nums) {
            if (n < min || n > max) {
                continue;
            }
            if (map[n - min]++ != 0) {
                continue;
            }
            // 每个位置存放数组中对应数字的个数,poses和negs存放正、负数
            if (n > 0) {
                poses[posCount++] = n;
            } else if (n < 0) {
                negs[negCount++] = n;
            }
        }
        Arrays.sort(poses, 0, posCount);
        Arrays.sort(negs, 0, negCount);
        int basej = 0;
        int nv;
        //遍历负数数组
        for (int i = negCount - 1; i >= 0; i--) {
            nv = negs[i];
            //minp最大为当前负数绝对值的一半(正数向左取整)
            int minp = -nv >>> 1;
            //在poses中basej及其左边的，有2pv+nv<0，因为向左取整右边不一定有2pv+nv>=0
            while (basej < posCount && poses[basej] < minp) {
                basej++;
            }
            //直接从右边开始，省掉了左边的时间
            for (int j = basej; j < posCount; j++) {
                int pv = poses[j];
                //cv的值为
                int cv = -nv - pv;
                //pv+2nv<=0,且2pv+nv>=0,因为右面不一定有2pv+nv>=0，所以还是要有后面的条件
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - min] > 1) {
                            ans.add(Arrays.asList(nv, nv, pv));
                        }
                    } else if (cv == pv) {
                        if (map[pv - min] > 1) {
                            ans.add(Arrays.asList(nv, pv, pv));
                        }
                    } else if (map[cv - min] > 0) {
                        ans.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv) {
                    // cv<nv即pv+2nv>0,退出循环，找下一个nv,省掉了过大的时间
                    break;
                }
            }
        }
        return ans;
    }

}
