package exam.test20230923;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/23 17:40
 */
class Solution {
    static int seed;
    public void myFunc(int time, int seed) {
        this.seed = seed;
        int[] query = new int[3];
        int op, m, x;
        Map<Integer,Integer> map = new HashMap<>();
        int min, max, ans = 0;
        int n = time;
        for (int i = 0; i < n; i++) {
            query = generateQuery(time);
            op = query[0];
            m = query[1];
            x = query[2];
            switch (op) {
                case 1://插入x
                    if(map.containsKey(x)) {
                        map.put(x, map.get(x) + 1);
                    } else {
                        map.put(x, 1);
                    }
                    break;
                case 2://删除m次数字x
                    if(map.containsKey(x)) {
                        int count = map.get(x);
                        if(count > m) {
                            map.put(x, count - m);
                        } else {
                            map.remove(x);
                        }
                    }
                    break;
                case 3://求极差
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        min = Math.min(min, entry.getKey());
                        max = Math.max(max, entry.getKey());
                    }
                    //ans=ans异或(（i+1）*（max-min）)
                    ans = ans ^ ((i + 1) * (max - min));
                    break;
                default:
                    break;
            }
            System.out.println(query[0] + "," + query[1] + "," + query[2]);
        }
        System.out.println(ans);

    }
    public int[] generateQuery(int time) {
        seed = seed ^ (seed << 15);
        seed = seed ^ (seed >> 5);
        seed = seed ^ (seed << 1);
        seed = seed % ( 1 << 15);

        int op = (seed ^ (seed << 7) ^ (seed >> 5)) % 3 + 1;
        int m = (seed ^ (seed << 6) ^ (seed >> 10)) % time + 1;
        int x = (seed ^ (seed << 5) ^ (seed << 9) ^ (seed >> 6)) % 10 + 1;
        return new int[]{op, m, x};
    }
}
public class Test3
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int time = cin.nextInt();
        int seed = cin.nextInt();
        new Solution().myFunc(time, seed);
    }
}
