package leetCode.linearDP.dynamicPlanning;

import java.util.Arrays;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/5 17:14
 */
//打家劫舍
public class HouseRobber198 {
    int maxMoney;//存储打劫最大的总金额
    int path;
    int[] nums;
    int n;

    //超时了：二叉树的深度遍历：自顶向下要不要打劫这家
//    public int rob(int[] nums) {
//        this.nums = nums;
//        n = nums.length;
//        maxMoney = 0;
//        path = 0;
//        dfs(0);
//        return maxMoney;
//    }
//
//    public void dfs(int i){//path表示这条路径上打劫的总收入
//        //结束条件
//        if(i >= n){
//            maxMoney = Math.max(path, maxMoney);
//            return;
//        }
//
//        //选择不打劫
//        dfs(i + 1);
//        //选择打劫
//        path += nums[i];
//        dfs(i + 2);
//        path -= nums[i];
//    }

//    //超时了：二叉树的深度遍历：要不要打劫这家，自底向上返回最大值
//        public int rob(int[] nums) {
//        this.nums = nums;
//        n = nums.length;
//        return dfs(n);
//    }
//
//    //二叉树的深度遍历：要不要打劫这家
//    public int dfs(int i){//path表示这条路径上打劫的总收入
//        //结束条件
//        if(i < 0){
//            return 0;
//        }
//        return Math.max(dfs(i - 1), dfs(i - 2) + nums[i]);//前者不打劫i，后者打劫，只选max继续
//    }

    //用一个数组来保留结果
    int[] money;
    //优化二叉树的深度遍历：要不要打劫这家，自底向上返回最大值
    public int rob(int[] nums) {
        this.nums = nums;
        n = nums.length;
        money = new int[n];
        Arrays.fill(money, -1);
        return dfs(n-1);
    }

    //二叉树的深度遍历：要不要打劫这家
    public int dfs(int i){//path表示这条路径上打劫的总收入
        //结束条件
        if(i < 0){
            return 0;
        }
        if(money[i] != -1){
            return money[i];
        }
        money[i] = Math.max(dfs(i - 1), dfs(i - 2) + nums[i]);//前者不打劫i，后者打劫，只选max继续
        return money[i];
    }

    //动态规划
    public int rob2(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }
        int n1 = nums[0];
        int n2 = Math.max(nums[0], nums[1]);
        int n3;
        for (int i = 2; i < nums.length; i++) {
            n3 = Math.max(n2, n1 + nums[i]);
            n1 = n2;
            n2 = n3;
        }
        return n2;
    }

    //动态规划：在上一个的基础上，初始f1和f2是0，这样不用特殊处理前两个
    public int rob3(int[] nums) {
        int n1 = 0;
        int n2 = 0;
        int n3;
        for (int num : nums) {
//            n3 = Math.max(n2, n1 + num);
//            n1 = n2;
//            n2 = n3;
            n1 = n2 = Math.max(n2, n1 + num);
        }
        return n2;
    }

    public static void main(String[] args) {
        HouseRobber198 houseRobber = new HouseRobber198();
        houseRobber.rob(new int[]{2,7,9,3,1});
    }
}
