package exam.test20231011;

import java.util.Scanner;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/10/11 19:09
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = 0, n = 0, x = 0;
        //请求数组
        int[] arr = null;
        while (in.hasNextInt()) {
            m = in.nextInt();
            n = in.nextInt();
            x = in.nextInt();
            arr = new int[x];
            for (int i = 0; i < x; i++) {
                arr[i] = in.nextInt();
            }
        }
//        System.out.println("m" + m + ",n" + n + ",x" + x);
//        for (int i = 0; i < x; i++) {
//            System.out.println(arr[i]);
//        }
        int sum = 0;
        int result = 0;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
            if(i - m >= 0){
                sum -= arr[i - m];
            }
            if(sum > n){
                result += sum - n;
                sum -= sum - n;
            }
//            System.out.println("sum" + sum + ",result" + result);
        }
        System.out.println(result);
    }
}
