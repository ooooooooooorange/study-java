package exam.test20230912;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/14 19:25
 */
public class Test6 {
    /**
     *
     * @param envelopes int整型二维数组
     * @return int整型
     */
    public int maxEnvelopes (int[][] envelopes) {
        // write code here
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1]-o1[1] : o1[0] - o2[0];
            }
        });
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        int[] dp = new int[height.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                if(height[i] > height[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int len = 0;
        for (int i : dp) {
            len = Math.max(len, i);
        }
        return len;
    }


}
