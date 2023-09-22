package leetCode.linearDP.dynamicPlanning;

import java.util.Arrays;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/11 22:44
 */
//零钱兑换
public class CoinChange322 {
    int[] coins;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        int result = dfs(coins.length - 1, amount);
        return result == Integer.MAX_VALUE / 2? -1 : result;
    }

    public int dfs(int i, int c){
        if(i < 0){
            return c == 0 ? 0 : Integer.MAX_VALUE / 2;// 除 2 是防止下面 + 1 溢出
        }
        if(c < coins[i]){
            return dfs(i - 1, c);
        }
        return Math.min(dfs(i - 1, c), dfs(i, c - coins[i]) + 1);
    }

    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        Arrays.fill(f[0], Integer.MAX_VALUE / 2);
        f[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= amount; c++) {
                if(c < coins[i]){
                    f[i + 1][c] = f[i][c];
                } else {
                    f[i + 1][c] = Math.min(f[i][c], f[i + 1][c - coins[i]] + 1);
                }
            }
        }
        return f[n][amount] == Integer.MAX_VALUE / 2? -1 : f[n][amount];
    }

    public int coinChange3(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2); // 除 2 是防止下面 + 1 溢出
        f[0] = 0;
        for (int coin : coins) {
            for (int c = coin; c <=amount; c++) {
                f[c] = Math.min(f[c], f[c - coin]+1);
            }
        }
        return f[amount] == Integer.MAX_VALUE / 2? -1 : f[amount];
    }
}
