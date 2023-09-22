package leetCode.interzoneDP;

/**
 * @Description: 让字符串成为回文串的最少插入次数
 * @Author: xuzixin9
 * @Date: 2023/9/20 19:38
 */
public class MinimumInsertionStepsToMakeAStringPalindrome1312 {
    char[] s;
    int[][] cache;
    public int minInsertions(String s) {
        this.s = s.toCharArray();
        int n = s.length();
        cache = new int[n][n];
        return dfs(0, n - 1);
    }

    public int dfs(int i, int j){
        if(i >= j){
            return 0;
        }
        if(cache[i][j] != 0){
            return cache[i][j];
        }
        if(s[i] == s[j]){
            return cache[i][j] = dfs(i + 1, j - 1);
        } else {
            return cache[i][j] = Math.min(dfs(i + 1, j), dfs(i, j - 1)) + 1;
        }
    }

    public int minInsertions_df(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = chars[i] == chars[j] ? f[i + 1][j - 1] : Math.min(f[i + 1][j], f[i][j - 1]) + 1;
            }
        }
        return f[0][n - 1];
    }
}
