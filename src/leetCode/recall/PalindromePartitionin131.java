package leetCode.recall;

import java.util.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/4 22:05
 */
//分割回文串
public class PalindromePartitionin131 {

    List<List<String>> result = new ArrayList<>();

    //递归实现深度遍历(N叉树，选择n-1个位置分割，结果为所以的节点集合)
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(Arrays.asList(s)));
        return result;
    }

    public void dfs(String s, int i, List<String> path){
        //结束条件可以省略，因为到不了
//        if(i == s.length()){
//            return;
//        }

        //存的是所有节点，所以进来就先存
        String part = path.get(i);
        if(isHuiwen(part)){
            result.add(new ArrayList<>(path));//克隆保存，防止被修改
        }

        for (int j = 1; j < part.length(); j++) {
            String part1 = part.substring(0, j);
            if(!isHuiwen(part1)){
                continue;
            }
            String part2 = part.substring(j);
            //切割
            path.remove(i);
            path.add(part1);
            path.add(part2);

            dfs(s, i + 1, path);

            //恢复
            path.remove(path.size() - 1);
            path.remove(path.size() - 1);
            path.add(part);
        }
    }

    public boolean isHuiwen(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    //递归实现深度遍历(N叉树，在哪加逗号)
    public List<List<String>> partition2(String s) {
        result = new ArrayList<>();
        dfs2(s, 0, new ArrayList<>());
        return result;
    }

    public void dfs2(String s, int i, List<String> path) {
        //结束条件
        if (i == s.length()) {
            result.add(new ArrayList<>(path));//克隆保存，防止被修改
            return;
        }

        for (int j = i + 1; j <= s.length(); j++) {
            String part = s.substring(i, j);
            if (!isHuiwen(part)) {
                continue;
            }
            //加入回文子串
            path.add(part);

            dfs2(s, j, path);

            //恢复
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        PalindromePartitionin131 palindromePartitionin131 = new PalindromePartitionin131();
        List<List<String>> aab = palindromePartitionin131.partition2("aab");
        System.out.println(aab);
    }
}
