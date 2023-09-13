package exam.test20230912;

import java.util.Scanner;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/12 20:42
 */
public class Test4 {
    //一个游戏玩家有k点体力，在一个m*n的表格中，其中(m，n都为正整数)，
    // 玩家位于 (0,0)，需要达到终点 (m,m)。
    //玩家只能上下左右移动，目每次只能移动1的长度并消耗1的体力，当体力耗尽的时候玩家无法移动
    //给定k、m、n，问玩家能否移动到终点，
    // 如能，则给出能到达终点的最短路径的走法数目
    //其中:
    //0<m<=30
    //0<n<=30

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        if(k < m + n){
            System.out.println(0);
        }
        result = 0;
        dft(n, m);
        System.out.println(result);
    }

    static int result = 0;
static public void dft(int i, int j){
        if(i == 0 && j == 0) {
            result++;
        }
        if(i>0) dft(i - 1, j);
        if(j>0) dft(i, j - 1);
    }
}
