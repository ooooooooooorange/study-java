package leetCode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/4 23:32
 */
//组合Ⅲ
public class CombinationsSum216 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        dfs(k, 0, n, new ArrayList<>());
        return result;
    }

    public void dfs(int k, int i,  int undoSum, List<Integer> path) {
        int undoNum = k - path.size();// 还要选 undoNum 个数
        if(undoSum < 0 || undoSum > (2 * i + undoNum) * undoNum/2){//如果加多了，或者剩下的数不够了，就不用继续了
            return;
        }
        //结束条件
        if (undoNum == 0) {
            result.add(new ArrayList<>(path));//克隆保存，防止被修改
            return;
        }
        
        for (int j = i + 1; 9 - j + 1 >= undoNum; j++) {//剪枝：剩下最多n - j + 1个树能选，如果<undoNum，就肯定不满足了
            //加入子串
            path.add(j);

            dfs(k, j, undoSum-j, path);

            //恢复
            path.remove(path.size() - 1);
        }
    }
}
