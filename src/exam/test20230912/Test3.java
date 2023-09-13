package exam.test20230912;

import java.util.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/12 20:27
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> array = new ArrayList<>();
        Set<Integer> set;
        while(in.hasNextInt()){
            array.add(in.nextInt());
        }
        int max = 0;
        for (int i = 0; i < array.size(); i++) {
            set = new HashSet<>();
            int j = i;
            while (j < array.size() && !set.contains(array.get(j))){
                set.add(array.get(j));
                j++;
            }
            max = Math.max(max, set.size());
        }
        System.out.println(max);
    }
}
