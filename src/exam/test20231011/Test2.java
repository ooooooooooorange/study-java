package exam.test20231011;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/10/11 19:37
 */
//快乐阅读
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //按逗号分割字符串
        String[] strArr = str.split(",");
        //将字符串数组转换为整型数组
        List<Integer> books = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            books.add(Integer.parseInt(strArr[i]));
        }

        //降序排序
        books.sort((o1, o2) -> o2 - o1);
        int result = 0;
        int sum = 0;
        for (int i = 0; i < books.size(); i++) {
            int addResult = sum + books.get(i);
            if (addResult > 0) {
                result += addResult;
                sum += books.get(i);
            }
        }
        System.out.println(result);
    }
}
