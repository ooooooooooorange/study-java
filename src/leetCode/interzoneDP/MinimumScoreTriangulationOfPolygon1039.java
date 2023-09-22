package leetCode.interzoneDP;

/**
 * @Description: 多边形三角剖分的最低得分
 * @Author: xuzixin9
 * @Date: 2023/9/20 17:15
 */
public class MinimumScoreTriangulationOfPolygon1039 {
    int[] values;
    int[][] cache;
    public int minScoreTriangulation(int[] values) {
        this.values = values;
        int n = values.length;
        cache = new int[n][n];
        return dfs(0, n - 1);
    }

    public int dfs(int i, int j){
        if ( j - i < 2){
            return 0;
        }
        if (cache[i][j] != 0){
            return cache[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            min = Math.min(min, dfs(i, k) + dfs(k, j) + values[i] * values[k] * values[j]);
        }
        return cache[i][j] = min;
    }

    public int minScoreTriangulation_dp(int[] values) {
        int n = values.length;
        int[][] f = new int[n][n];
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    min = Math.min(min, f[i][k] + f[k][j] + values[i] * values[k] * values[j]);
                }
                f[i][j] = min;
            }
        }
        return f[0][n - 1];
    }
}
