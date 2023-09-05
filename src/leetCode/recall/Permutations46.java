package leetCode.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/5 13:15
 */
//全排列
public class Permutations46 {
    private int[] nums;
    private List<Integer> path;
    private boolean[] isUsed;
    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        path = Arrays.asList(new Integer[nums.length]);
        isUsed = new boolean[nums.length];
        dfs(0);
        return result;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!isUsed[j]) {//如果这个数字还没被使用
                path.set(i, nums[j]);//位置i放上数字nums[j]
                isUsed[j] = true;
                dfs(i + 1);
                isUsed[j] = false; // 恢复现场：因为path是不断替换的，所以不用恢复
            }
        }
    }
}
