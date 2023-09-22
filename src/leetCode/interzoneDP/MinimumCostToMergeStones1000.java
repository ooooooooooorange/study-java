package leetCode.interzoneDP;

import java.util.Arrays;

/**
 * @Description: 合并石头的最低成本
 * @Author: xuzixin9
 * @Date: 2023/9/20 22:07
 */
public class MinimumCostToMergeStones1000 {
    private int[][] memo;
    private int[] s;
    private int k;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }

        s = new int[n + 1];
        for (int i = 0; i < n; i++)
            s[i + 1] = s[i] + stones[i]; // 前缀和
        this.k = k;

        memo = new int[n][n];
        for (int i = 0; i < n; ++i)
            Arrays.fill(memo[i],-1); // -1 表示还没有计算过
        return dfs(0, n - 1);
    }
    int dfs(int i, int j) {
        if(i == j){
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int m = i; m < j; m += k - 1) {// 枚举哪些石头堆合并成第一堆
            res = Math.min(res, dfs(i, m) + dfs(m + 1, j));
        }
        if ((j - i) % (k - 1) == 0) {// 可以合并成一堆
            res += s[j + 1] - s[i];
        }
        return memo[i][j] = res;
    }
}
