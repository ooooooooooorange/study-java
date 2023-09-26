//package exam.test20230923;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
///**
// * @Description:
// * @Author: xuzixin9
// * @Date: 2023/9/23 16:46
// */
//class Solution {
//    public void myFunc(int n, int r, int[][] arr) {
//        System.out.println(arr[0][0]+ "," + arr[0][1]);
//    }
//}
//public class Test2
//{
//    public static void main(String args[])
//    {
//        Scanner cin = new Scanner(System.in);
//        String line1 = cin.nextLine();
//        String[] firstLine = line1.split(",");
//        int n = Integer.parseInt(firstLine[0]);
//        int r = Integer.parseInt(firstLine[1]);
//        int[][] arr = new int[n][3];
//        for (int i = 0; i < n; i++) {
//            String line = cin.nextLine();
//            if (line.length() > 0) {
//                String[] arrLine = line.split(",");
//                for (int j = 0; j < 3; j++) {
//                    arr[i][j] = Integer.parseInt(arrLine[j]);
//                }
//            }
//        }
//        new Solution().myFunc(n, r, arr);
//    }
//}