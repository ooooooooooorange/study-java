package leetCode.reduceRange;

import java.util.HashMap;
import java.util.Map;

//1.两数之和(无序)
public class TwoSum1 {
    //哈希表，时间O(n)，空间O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
