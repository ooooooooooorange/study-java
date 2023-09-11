package leetCode.dynamicPlanning;

import java.util.Arrays;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/5 20:09
 */
//目标和
public class TargetSum494 {
    int[] nums;
    int target;
    int result;

    int[] sumArray;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        sumArray = new int[nums.length];
        sumArray[0] = nums[0];//累加和，用于剪枝
        for (int i = 1; i < nums.length; i++) {
            sumArray[i] = nums[i]+sumArray[i-1];
        }
        result = 0;
        dfs(nums.length-1, 0);
        return result;
    }

    public void dfs(int i, int sum){
        //结束条件，也是动态规划的开始条件
        if(i < 0){
            if(sum == target){
                result++;
            }
            return;
        }

        if(sum + sumArray[i] < target || sum - sumArray[i] > target){
            return;
        }

        dfs(i - 1, sum + nums[i]);
        dfs(i - 1, sum - nums[i]);
    }

    public int findTargetSumWays2(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        target += Arrays.stream(nums).sum(); // 求和
        if(target % 2 == 1 || target < 0) return 0; //不可能是奇数和负数
        target /= 2;//p
        return dfs2(nums.length-1, target);
    }

    public int dfs2(int i, int c){
        //结束条件，也是动态规划的开始条件
        if(i < 0){
            return c == 0 ? 1 : 0;
        }

        if(c < nums[i]){
            return dfs2(i-1, c);
        }

        return dfs2(i - 1, c) + dfs2(i - 1, c - nums[i]);//恰好装的方案数
    }



    //动态规划：
    //设正数和为p，总和为s，那么负数和为s-p
    //target = 正数和-负数和 = p - (s - p) = 2p - s
    //p = (target + s) / 2，所以问题变成n个数里选几个数求和正好是p,求方案数
    public int findTargetSumWays3(int[] nums, int target) {
        int n = nums.length;
        target += Arrays.stream(nums).sum(); // 求和
        if(target % 2 == 1 || target < 0) return 0; //不可能是奇数和负数
        target /= 2;//p

//        int[][] f = new int[n + 1][target + 1];//因为dfs入参有两个，所以需要二维数组来保留结果
//        f[0][0] = 1;
//        for (int i = 0; i < n; i++) {
//            for (int c = 0; c <= target; c++) {
//                if (c < nums[i]) {//放不下了，只能不放
//                    f[i + 1][c] = f[i][c];
//                }else {
//                    f[i + 1][c] = f[i][c] + f[i][c - nums[i]];
//                }
//            }
//        }
//        return f[n][target];

//        int[][] f = new int[2][target + 1];//若`f[][]`只是用到了`f[i]`行和`f[i+1]`行，可以通过对行数`%2`的方式交替使用这两行，空间复杂度从`O(n*c)`降到`O(c)`
//        f[0][0] = 1;
//        for (int i = 0; i < n; i++) {
//            for (int c = 0; c <= target; c++) {
//                if (c < nums[i]) {//放不下了，只能不放
//                    f[(i + 1) % 2][c] = f[i % 2][c];
//                }else {
//                    f[(i + 1) % 2][c] = f[i % 2][c] + f[i % 2][c - nums[i]];
//                }
//            }
//        }
//        return f[n % 2][target];

        int[] f = new int[target + 1];//若`f[][]`只是用到了`f[i]`行和`f[i+1]`行，可以通过对行数`%2`的方式交替使用这两行，空间复杂度从`O(n*c)`降到`O(c)`
        f[0] = 1;
        for (int num : nums) {
            for (int c = target; c >= 0; c--) {
                f[c] = f[c] + f[c - num];
            }
        }
        return f[target];
    }

    public static void main(String[] args) {
        TargetSum494 targetSum494 = new TargetSum494();
        int[] nums = {0,0,0,0,0,0,0,0,1};
        int target = 1;
        System.out.println(targetSum494.findTargetSumWays3(nums, target));
    }

}
