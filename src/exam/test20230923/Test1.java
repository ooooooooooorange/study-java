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
//    public void myFunc(int n, int[] arr) {
//        // 使用自测数据按钮时调试用，正式提交时要删掉。
//        for (int i=0; i<n; i++) {
//            int index = i;
//            int num = 0;
//            while(arr[index] != -1) {
//                index = arr[index];
//                num++;
//                if(num > n) {
//                    System.out.println("0");
//                    return;
//                }
//            }
//        }
//        System.out.println("1");
//    }
//}
//public class Test1
//{
//    public static void main(String args[])
//    {
//        Scanner cin = new Scanner(System.in);
//        String line1 = cin.nextLine();
//        int n = Integer.parseInt(line1);
//        int[] arr = new int[n];
//        Arrays.fill(arr, -1);
//
//        String line = cin.nextLine();
//        if (line.length() > 0) {
//            String[] arrLine = line.split(",");
//            for (int i=0; i<arrLine.length; i++) {
//                String[] pair = arrLine[i].split(":");
//                arr[Integer.parseInt(pair[0])] = Integer.parseInt(pair[1]);
//            }
//        }
//
//        new Solution().myFunc(n, arr);
//    }
//}