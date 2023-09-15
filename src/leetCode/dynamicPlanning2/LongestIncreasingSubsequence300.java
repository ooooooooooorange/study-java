package leetCode.dynamicPlanning2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 最长递增子序列
 * @Author: xuzixin9
 * @Date: 2023/9/12 15:07
 */
public class LongestIncreasingSubsequence300 {
    int[] nums;
    int max;

    //选或不选，自顶向下遍历
    public int lengthOfLIS_2(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        max = 0;
        dfs_2(n-1, Integer.MAX_VALUE, 0);
        return max;
    }

    public void dfs_2(int i, int pre, int sum){
        if (i < 0) {
            max = Math.max(sum, max);
            return;
        }
        if(nums[i] < pre){
            dfs_2(i-1, nums[i], sum+1);
        }
        dfs_2(i-1, pre, sum);
    }


    int[] cache;
    //选哪一个，自顶向下遍历，记忆化搜索
    public int lengthOfLIS_n(int[] nums) {
        int n = nums.length;
        this.nums = new int[n+1];
        System.arraycopy(nums, 0, this.nums, 0, n);
        this.nums[n] = Integer.MAX_VALUE;//加上一个最大值，防止越界
        cache = new int[n+1];
        dfs_n(n);
        return cache[n];
    }

    public int dfs_n(int i){
        if (cache[i] > 0) {
            return cache[i];
        }
        for (int j = i; j >= 0; j--) {
            if (nums[i] > nums[j]) {
                cache[i] = Math.max(cache[i], dfs_n(j));
            }
        }
        return ++cache[i];
    }

    //递推
    public int lengthOfLIS_dp(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j]);
                }
            }
            f[i]++;
        }
        return f[n-1];
    }

    //贪心算法+二分查找，维护一个递增的子序列，每次要么+1到末尾，要么替换一个更小的值
    public int lengthOfLIS_greed(int[] nums) {
        List<Integer> g = new ArrayList<>();
        int n = nums.length;
        g.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > g.get(g.size() - 1)) {
                g.add(nums[i]);
            } else {
                int position = findPosition(g, nums[i]);
                g.set(position, nums[i]);
            }
        }
        return g.size();
    }
    public int findPosition(List<Integer> g, int target){
        int left = 0;
        int right = g.size() - 1;
        int mid;
        while (left <= right){
            mid = left + (right - left) / 2;
            if (g.get(mid) < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        LongestIncreasingSubsequence300 l = new LongestIncreasingSubsequence300();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(l.lengthOfLIS_dp(nums));
    }
}
