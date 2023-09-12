package leetCode.dynamicPlanning2;

import java.util.Arrays;

/**
 * @Description: 最长公共子序列
 * @Author: xuzixin9
 * @Date: 2023/9/11 23:50
 */
public class LongestCommonSubsequence1143 {
    private char[] s, t;
    private int[][] cache;
    public int longestCommonSubsequence(String text1, String text2) {
        s = text1.toCharArray();
        t = text2.toCharArray();
        int n = s.length, m = t.length;
        cache = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1); // -1 表示没有访问过
        }
        return dfs(n - 1, m - 1);
    }

    public int dfs(int i, int j){
        if(i < 0 || j < 0){
            return 0;
        }
        if(cache[i][j] != -1){
            return cache[i][j];
        }
        if(s[i] == t[j]){
            return cache[i][j] = dfs(i - 1, j - 1) + 1;
        } else {
            return cache[i][j] = Math.max(dfs(i - 1, j), dfs(i, j - 1));
        }
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();
        int n = s.length, m = t.length;
//        int[][] f = new int[n + 1][m + 1];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if(s[i] == t[j]){
//                    f[i + 1][j + 1] = f[i][j] + 1;
//                } else {
//                    f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
//                }
//            }
//        }
//        return f[n][m];

//        int[][] f = new int[2][m + 1];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if(s[i] == t[j]){
//                    f[(i + 1) % 2][j + 1] = f[i % 2][j] + 1;
//                } else {
//                    f[(i + 1) % 2][j + 1] = Math.max(f[i % 2][j + 1], f[(i + 1) % 2][j]);
//                }
//            }
//        }

        int[] f = new int[m + 1];
        int tmp;
        for (int i = 0; i < n; i++) {
            for (int j = 0, pre = f[0]; j < m; j++) {
                tmp = f[j + 1];
                f[j + 1] = s[i] == t[j] ? pre + 1 : Math.max(f[j + 1], f[j]);
                pre = tmp;
            }
        }
        return f[m];
    }
}
