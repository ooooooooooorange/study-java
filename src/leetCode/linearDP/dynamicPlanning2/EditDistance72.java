package leetCode.linearDP.dynamicPlanning2;

import java.util.Arrays;

/**
 * @Description: 编辑距离
 * @Author: xuzixin9
 * @Date: 2023/9/12 12:57
 */
public class EditDistance72 {
    private char[] s, t;
    private int[][] cache;
    public int minDistance(String word1, String word2) {
        s = word1.toCharArray();
        t = word2.toCharArray();
        int n = s.length, m = t.length;
        cache = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1); // -1 表示没有访问过
        }
        return dfs(n - 1, m - 1);
    }

    public int dfs(int i, int j){
        if(i < 0){//说明s已经遍历完了，那么只能插入t[j]，插入的次数就是j + 1
            return j + 1;
        }
        if(j < 0){//说明t已经遍历完了，那么只能删除s[i]，删除的次数就是i + 1
            return i + 1;
        }
        if(cache[i][j] != -1){
            return cache[i][j];
        }
        if(s[i] == t[j]){
            return cache[i][j] = dfs(i - 1, j - 1);
        } else {//三种操作：删除、插入、替换
            return cache[i][j] = Math.min(Math.min(dfs(i - 1, j), dfs(i, j - 1)), dfs(i - 1, j - 1)) + 1;
        }
    }

    public int minDistance2(String word1, String word2) {
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int n = s.length, m = t.length;
//        int[][]f = new int[n + 1][m + 1];
//        for (int i = 0; i < n; i++) {
//            f[i + 1][0] = i + 1;
//        }
//        for (int j = 1; j <= m; j++) {
//            f[0][j] = j;
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m ; j++) {
//                if(s[i] == t[j]){
//                    f[i + 1][j + 1] = f[i][j];
//                } else {
//                    f[i + 1][j + 1] = Math.min(Math.min(f[i][j + 1], f[i + 1][j]), f[i][j]) + 1;
//                }
//            }
//        }
//        return f[n][m];

//        int[][]f = new int[2][m + 1];
//        for (int j = 1; j <= m; j++) {
//            f[0][j] = j;
//        }
//        for (int i = 0; i < n; i++) {
//            f[(i + 1) % 2][0] = i + 1;
//            for (int j = 0; j < m ; j++) {
//                if(s[i] == t[j]){
//                    f[(i + 1) % 2][j + 1] = f[i % 2][j];
//                } else {
//                    f[(i + 1) % 2][j + 1] = Math.min(Math.min(f[i % 2][j + 1], f[(i + 1) % 2][j]), f[i % 2][j]) + 1;
//                }
//            }
//        }
//        return f[n % 2][m];


        int[]f = new int[m + 1];
        for (int j = 1; j <= m; j++) {
            f[j] = j;
        }
        int tmp, pre;
        for (int i = 0; i < n; i++) {
            pre = f[0];
            f[0]++;
            for (int j = 0; j < m ; j++) {
                tmp = f[j + 1];
                f[j + 1] = s[i] == t[j]? pre : Math.min(Math.min(f[j + 1], f[j]), pre) + 1;
                pre = tmp;
            }
        }
        return f[m];
    }
}
