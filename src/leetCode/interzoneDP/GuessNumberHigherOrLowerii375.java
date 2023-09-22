package leetCode.interzoneDP;

/**
 * @Description: 猜数字大小 II
 * @Author: xuzixin9
 * @Date: 2023/9/20 18:06
 */
public class GuessNumberHigherOrLowerii375 {
    int[][] cache;
    public int getMoneyAmount(int n) {
        cache = new int[n + 1][n + 1];
        return dfs(1, n);
    }
    public int dfs(int i, int j){
        if(i >= j){
            return 0;
        }
        if(cache[i][j] != 0){
            return cache[i][j];
        }
        int max = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            max = Math.min(max, k + Math.max(dfs(i, k - 1), dfs(k + 1, j)));
        }
        return cache[i][j] = max;
    }


    public int getMoneyAmount_dp(int n) {
        int[][] f = new int[n + 2][n + 2];
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    min = Math.min(min, k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
                f[i][j] = min;
            }
        }
        return f[1][n];
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLowerii375 guessNumberHigherOrLowerii375 = new GuessNumberHigherOrLowerii375();
        System.out.println(guessNumberHigherOrLowerii375.getMoneyAmount_dp(2));
    }
}
