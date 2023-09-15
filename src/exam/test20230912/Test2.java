package exam.test20230912;

import java.util.Scanner;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/12 20:25
 */
public class Test2 {
    //小明是一名间谍，他需要将情报数据中多组数字组成、每一行有多个小于10的正整数，编码后传回总部。编码算法是这样的
    //针对一组数字，做谢序倒排，然后顺序打乱分成多行，每一行放
    //一个数。再给每个数增加一个数字，说明下一个数的在第几行
    //请写出解码算法，将编码后的多行数据解码成原始的数字
    //举例:
    //比如一组原始数据12345，承序成54321。再拆成多行
    //加上下一个数的行数信息，如果是最后一个数，行数信息为0
    //得到:
    //解码算法就是将上面的5行数据解码成12345

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}
