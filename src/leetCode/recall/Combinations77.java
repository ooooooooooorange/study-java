package leetCode.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/4 23:32
 */
//组合
public class Combinations77 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        dfs(n, k, 0, new ArrayList<>());
        return result;
    }

    public void dfs(int n, int k, int i, List<Integer> path) {
        int undoNum = k - path.size();// 还要选 undoNum 个数
        //结束条件
        if (undoNum == 0) {
            result.add(new ArrayList<>(path));//克隆保存，防止被修改
            return;
        }

        for (int j = i + 1; n - j + 1 >= undoNum; j++) {//剪枝：剩下最多n - j + 1个树能选，如果<undoNum，就肯定不满足了
            //加入子串
            path.add(j);

            dfs(n, k, j, path);

            //恢复
            path.remove(path.size() - 1);
        }
    }
}
