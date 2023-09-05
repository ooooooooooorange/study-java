package leetCode.recall;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/4 20:32
 */
//子集
public class Subsets78 {
    //借助队列实现
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Deque<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {//遍历nums
            int num = nums[i];
            int size = result.size();
            for (int j = 0; j < size; j++) {//给每一个结果加上新的字母
                List<Integer> array = result.remove();
                List<Integer> addArray = new ArrayList<>(array);
                array.add(num);
                result.add(array);
                result.add(addArray);
            }
        }
        return new ArrayList<>(result);
    }

    List<List<Integer>> result = new ArrayList<>();
    //递归实现深度遍历(二叉树，选择和不选择，结果为叶子节点集合)
    public List<List<Integer>> subsets2(int[] nums) {
        result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return result;
    }

    public void dfs(int[] nums, int i, List<Integer> path){
        if(i == nums.length){
            result.add(path);
            return;
        }
        dfs(nums, i + 1, path);
        List<Integer> path2 = new ArrayList<>(path);
        path2.add(nums[i]);
        dfs(nums, i + 1, path2);
    }

    //递归实现深度遍历(N叉树，选择谁，结果为所以的节点集合)
    public List<List<Integer>> subsets3(int[] nums) {
        result = new ArrayList<>();
        dfs3(nums, 0, new ArrayList<>());
        return result;
    }

    public void dfs3(int[] nums, int i, List<Integer> path){
        //可以省略，因为到不了
//        if(i == nums.length){
//            return;
//        }
        //存的是所有节点，所以进来就先存
        result.add(new ArrayList<>(path));//克隆保存，防止被修改

        while (i < nums.length){
            path.add(nums[i]);
            dfs3(nums, i + 1, path);
            path.remove(path.size() - 1);
            i++;
        }

    }

    public static void main(String[] args) {
        Subsets78 subsets78 = new Subsets78();
        subsets78.subsets2(new int[]{0});
    }

}
