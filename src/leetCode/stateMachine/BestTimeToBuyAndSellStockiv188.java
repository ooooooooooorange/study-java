package leetCode.stateMachine;

import java.util.Arrays;

/**
 * @Description: 买卖股票的最佳时机4
 * @Author: xuzixin9
 * @Date: 2023/9/19 21:48
 */
public class BestTimeToBuyAndSellStockiv188 {
    int price[];
    int cache[][][];
    public int maxProfit(int k, int[] prices) {
        this.price = prices;
        int n = prices.length;
        cache = new int[n][k+1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++){
                Arrays.fill(cache[i][j], -1); // -1 表示还没有计算过
            }
        }
        return dfs(n - 1, k, 0);
    }

    public int dfs(int i, int j, int hold){
        if(j < 0){
            return Integer.MIN_VALUE/2;
        }
        if(i < 0){
            return hold == 1 ? Integer.MIN_VALUE/2 : 0;
        }
        if(cache[i][j][hold] != -1){
            return cache[i][j][hold];
        }

        if(hold == 1) {
            cache[i][j][hold] = Math.max(dfs(i - 1,j, 1), dfs(i - 1,j, 0) - price[i]);
        } else {
            cache[i][j][hold] = Math.max(dfs(i - 1,j, 0), dfs(i - 1,j-1, 1) + price[i]);
        }
        return cache[i][j][hold];
    }


    public int maxProfit_dp(int k, int[] prices) {
        int n = prices.length;
        int[][][] f = new int[n+1][k+2][2];
        //因为负无穷的情况很多，所以索性都初始化为负无穷，然后再吧需要置零的地方置零
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k + 1; j++){
                Arrays.fill(f[i][j], Integer.MIN_VALUE / 2);
            }
        }
        for (int j = 1; j <= k + 1; j++) {
            f[0][j][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k + 1; j++) {
                f[i + 1][j][0] = Math.max(f[i][j][0], f[i][j][1] + prices[i]);
                f[i + 1][j][1] = Math.max(f[i][j][1], f[i][j-1][0] - prices[i]);
            }
        }
        return f[n][k+1][0];
    }

    public int maxProfit_dp2(int k, int[] prices) {
        int n = prices.length;
        int[][] f = new int[k+2][2];

        for (int j = 1; j <= k+1; j++){
            f[j][1] = Integer.MIN_VALUE / 2;
        }
        f[0][0] = Integer.MIN_VALUE / 2;
        for (int p : prices) {
            for (int j = k+1; j >= 1; j--) {
                f[j][0] = Math.max(f[j][0], f[j][1] + p);
                f[j][1] = Math.max(f[j][1], f[j-1][0] - p);
            }
        }
        return f[k+1][0];
    }
}
