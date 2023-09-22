package leetCode.interzoneDP;

import java.util.Arrays;

/**
 * @Description: 切棍子的最小成本
 * @Author: xuzixin9
 * @Date: 2023/9/20 21:15
 */
public class MinimumCostToCutAStick {
    int[] newCuts;
    int[][] cache;

    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        newCuts = new int[m + 2];
        newCuts[0] = 0;
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[m + 1] = n;
        cache = new int[m + 2][m + 2];
        return dfs(1, m);
    }

    public int dfs(int cuti, int cutj) {
        if (cuti > cutj) {
            return 0;
        }
        if (cache[cuti][cutj] != 0) {
            return cache[cuti][cutj];
        }
        int min = Integer.MAX_VALUE;
        for (int k = cuti; k <= cutj; k++) {
            min = Math.min(min, dfs(cuti, k-1) + dfs(k+1, cutj) + newCuts[cutj + 1] - newCuts[cuti - 1]);
        }
        return cache[cuti][cutj] = min;
    }

    public int minCost_dp(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] newCuts = new int[m + 2];
        newCuts[0] = 0;
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[m + 1] = n;
        int[][] f = new int[m + 2][m + 2];
        for (int i = m; i >= 1; i--) {
            for (int j = i; j <= m; j++) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i][k - 1] + f[k + 1][j] + (newCuts[j + 1] - newCuts[i - 1]));
                }
            }
        }
        return f[1][m];
    }
}
