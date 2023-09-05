package leetCode.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/4 22:05
 */
//括号生成
public class GenerateParenthes22 {

    List<String> result = new ArrayList<>();

//    //递归实现深度遍历(N叉树，转换成n以内的数相加=n的组合)——错的，因为漏掉了（（）（）)的情况
//    public List<String> generateParenthesis(int n) {
//        result = new ArrayList<>();
//        dfs(n, 0, "");
//        return result;
//    }
//
//    public void dfs(int n, int sum, String path){
//        if(sum > n ){//如果加多了，就不用继续了
//            return;
//        }
//        //结束条件
//        if (sum == n) {
//            result.add(path);//克隆保存，防止被修改
//            return;
//        }
//
//        for (int i = 1; i <= 3; i++) {
//            //加入子串
//            String s = path + printParenthesis(i);
//            dfs(n, sum + i, s);
//        }
//    }
//
//    public String printParenthesis(int n){
//        String result = "";
//        for (int i = 0; i < n; i++) {
//            result = "(" + result + ")";
//        }
//        return result;
//    }

    //递归实现深度遍历(2叉树，转换成加不加左括号,即：加左括号还是右括号)
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        dfs(n, 0, 0,  "");
        return result;
    }

    public void dfs(int n, int leftNum, int rightNum, String path){
        //结束条件
        if(leftNum + rightNum == 2 * n ){//
            result.add(path);//克隆保存，防止被修改
            return;
        }

        if(leftNum < n){//加左括号
            dfs(n, leftNum + 1, rightNum, path + "(");
        }
        if(rightNum < leftNum){//加右括号
            dfs(n, leftNum, rightNum + 1, path + ")");
        }
    }

    public String printParenthesis(int n){
        String result = "";
        for (int i = 0; i < n; i++) {
            result = "(" + result + ")";
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateParenthes22 description22 = new GenerateParenthes22();
        List<String> strings = description22.generateParenthesis(3);
        System.out.println(Arrays.toString(strings.toArray()));
    }
}
