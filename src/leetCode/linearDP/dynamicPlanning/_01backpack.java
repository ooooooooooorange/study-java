package leetCode.linearDP.dynamicPlanning;
import java.util.Arrays;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/5 17:14
 */
//01背包问题
public class _01backpack {
    int[] weights;
    int[] values;

    //递归实现
    public int dfs(int i, int c){
        if (i < 0) {
            return 0;
        }
        if (c < weights[i]) {
            return dfs(i - 1, c);
        }
        return Math.max(dfs(i - 1, c), dfs(i - 1, c - weights[i]) + values[i]);
    }


    //动态规划
    public int backpack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int c = capacity;
        int[][] dfs = new int[n+1][c];//用一个二维数组来保留结果
        //初始化数组：因为初始条件是：dfs[0][c] = 0，所以第一行都是0
        //为了避免额外处理i<0的情况，将i整体+1
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (c < weights[i]) {//放不下了，只能不放
                dfs[i+1][c] = dfs[i][c];
            }else {//比较一下放不放哪个大
                dfs[i+1][c] = Math.max(dfs[i][c], dfs[i][c - weights[i]] + values[i]);
            }
            max = Math.max(max, dfs[i][c]);
        }
        return max;
    }

    //动态规划：在上一个的基础上，优化二维数组为两个数组
    public int backpack1(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int c = capacity;
        int[][] dfs = new int[2][c];//用两行 一维数组来保留结果
        //初始化数组：因为初始条件是：dfs[0][c] = 0，所以第一行都是0
        //为了避免额外处理i<0的情况，将i整体+1
        //因为只使用了两行，所以对第一个维度%2，来交替使用
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (c < weights[i]) {//放不下了，只能不放
                dfs[(i+1)%2][c] = dfs[i%2][c];
            }else {//比较一下放不放哪个大
                dfs[(i+1)%2][c] = Math.max(dfs[i%2][c], dfs[i%2][c - weights[i]] + values[i]);
            }
            max = Math.max(max, dfs[i][c]);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
