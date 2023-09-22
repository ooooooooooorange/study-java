package leetCode.linearDP.stateMachine;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 买卖股票的最佳时机含冷冻期
 * @Author: xuzixin9
 * @Date: 2023/9/19 20:52
 */
public class BestTimeToBuyAndSellStockWithCooldown309 {
    int codeDay = 1;
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
            cache[i][hold] = Math.max(dfs(i - 1, 1), dfs(i - 1 - codeDay, 0) - price[i]);
        } else {
            cache[i][hold] = Math.max(dfs(i - 1, 0), dfs(i - 1, 1) + price[i]);
        }
        return cache[i][hold];
    }

    public int maxProfit_dp(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n + 1 + codeDay][2];
        for (int i = 0; i <= codeDay; i++) {
            f[i][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            f[i + 1 + codeDay][0] = Math.max(f[i + codeDay][0], f[i + codeDay][1] + prices[i]);
            f[i + 1 + codeDay][1] = Math.max(f[i + codeDay][1], f[i][0] - prices[i]);
        }
        return f[n + codeDay][0];
    }

    public int maxProfit_dp2(int[] prices) {
        int n = prices.length;
        int f1 = Integer.MIN_VALUE;
        Deque<Integer> f0Stack = new LinkedList<>();
        for (int i = 0; i <= codeDay; i++) {
            f0Stack.addLast(0);
        }
        int tmp0;
        for (int p : prices) {
            tmp0 = Math.max(f0Stack.getLast(), f1 + p);
            f1 = Math.max(f1, f0Stack.getFirst() - p);
            f0Stack.addLast(tmp0);
            f0Stack.removeFirst();
        }
        return f0Stack.getLast();
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown309 bestTimeToBuyAndSellStockWithCooldown309 = new BestTimeToBuyAndSellStockWithCooldown309();
        System.out.println(bestTimeToBuyAndSellStockWithCooldown309.maxProfit_dp2(new int[]{1,2,3,0,2}));
    }
}
