package leetCode.interzoneDP;

import java.util.Arrays;

/**
 * @Description: 最长回文子序列
 * @Author: xuzixin9
 * @Date: 2023/9/19 23:53
 */
public class LongestPalindromicSubsequence516 {
    private char[] s;
    private int[][] cache;

    public int longestPalindromeSubseq(String S) {
        s = S.toCharArray();
        int n = s.length;
        cache = new int[n][n];
        for (int i = 0; i < n; ++i)
            Arrays.fill(cache[i], -1); // -1 表示还没有计算过
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i > j) {
            return 0; // 空串
        }
        if (i == j) {
            return 1; // 只有一个字母
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        if (s[i] == s[j]) {
            return cache[i][j] = dfs(i + 1, j - 1) + 2; // 都选
        }
        return cache[i][j] = Math.max(dfs(i + 1, j), dfs(i, j - 1)); // 枚举哪个不选
    }

    public int longestPalindromeSubseq_dp(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i){
            f[i][i] = 1; // 只有一个字母的情况
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j){
                if (s[i] == s[j]) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n-1];
    }

    public int longestPalindromeSubseq_dp2(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[] f = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            f[i] = 1;
            int pre = 0;
            for (int j = i + 1; j < n; ++j){
                int tmp = f[j];
                if (s[i] == s[j]) {
                    f[j] = pre + 2;
                } else {
                    f[j] = Math.max(f[j], f[j - 1]);
                }
                pre = tmp;
            }
        }
        return f[n-1];
    }

    public int longestPalindrome(String word1, String word2) {
        char[] s = (word1 + word2).toCharArray();
        int n = s.length;
        int n1 = word1.length();
        int[] f = new int[n];
        int result = 0;
        boolean flag = false;
        for (int i = n - 1; i >= 0; --i) {
            f[i] = 1;
            int pre = 0;
            for (int j = i + 1; j < n; ++j){
                int tmp = f[j];
                if (s[i] == s[j]) {
                    f[j] = pre + 2;
                    if(i < n1 && j >= n1){
                        result = Math.max(result, f[j]);
                    }
                } else {
                    f[j] = Math.max(f[j], f[j - 1]);
                }
                pre = tmp;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        LongestPalindromicSubsequence516 l = new LongestPalindromicSubsequence516();
        System.out.println(l.longestPalindrome("ceebeddc", "d"));
    }
}
