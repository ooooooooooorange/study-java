package leetCode.linearDP.stateMachine;

import java.util.Arrays;

/**
 * @Description: 买卖股票的最佳时机2
 * @Author: xuzixin9
 * @Date: 2023/9/19 16:07
 */
public class BestTimeToBuyAndSellStockII122 {
    int price[];
    int cache[][];
    public int maxProfit(int[] prices) {
        this.price = prices;
        int n = prices.length;
        cache = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1); // -1 表示还没有计算过
        }
        return dfs(n - 1, 0);
    }

    public int dfs(int i, int hold){
        if(i < 0){
            return hold == 1 ? Integer.MIN_VALUE : 0;
        }
        if(cache[i][hold] != -1){
            return cache[i][hold];
        }

        if(hold == 1) {
            cache[i][hold] = Math.max(dfs(i - 1, 1), dfs(i - 1, 0) - price[i]);
        } else {
            cache[i][hold] = Math.max(dfs(i - 1, 0), dfs(i - 1, 1) + price[i]);
        }
        return cache[i][hold];
    }


    public int maxProfit_dp(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n+1][2];
//        f[0][0] = 0;
        f[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            f[i][0] = Math.max(f[i-1][0], f[i-1][1] + prices[i-1]);
            f[i][1] = Math.max(f[i-1][1], f[i-1][0] - prices[i-1]);
        }
        return f[n][0];
    }

    public int maxProfit_dp2(int[] prices) {
        int n = prices.length;
        int f0 = 0;
        int f1 = Integer.MIN_VALUE;
        int tmp0,tmp1;
        for (int p : prices) {
            tmp0 = f0;
            tmp1 = f1;
            f0 = Math.max(tmp0, tmp1 + p);
            f1 = Math.max(tmp1, tmp0 - p);
        }
        return f0;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII122 bestTimeToBuyAndSellStock2 = new BestTimeToBuyAndSellStockII122();
        System.out.println(bestTimeToBuyAndSellStock2.maxProfit(new int[]{7,6,4,3,1}));
    }
}
