package leetCode.reduceRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//三数之和
public class ThreeSum15 {
    //167双数之和延申
    //缩减搜素空间的思想：时间O(n^2)，空间O(1)
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        int lp, rp, target;
        for (int i = 0; i < len - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            lp = i+1;
            rp = len-1;
            target = nums[i]*-1;
            //优化：提前结束
            if(((nums[rp] + nums[rp-1]) < target) || ((nums[lp] + nums[lp+1]) > target)){
                continue;
            }

            while (lp < rp){
                int sum = nums[lp] + nums[rp];
                if(sum < target){
                    lp++;
                }
                else if (sum > target){
                    rp--;
                }
                else {
                    result.add(Arrays.asList( nums[i], nums[lp], nums[rp]));
                    while(lp < rp && nums[lp] == nums[lp+1]) lp++;
                    while(lp < rp && nums[rp] == nums[rp-1]) rp--;
                    lp++;
                    rp--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
