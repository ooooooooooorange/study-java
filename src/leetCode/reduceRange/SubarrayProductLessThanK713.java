package leetCode.reduceRange;

//乘积小于 K 的子数组
//217长度最小子串的变种（因为是正整数，所以相乘满足单调性）
public class SubarrayProductLessThanK713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) {
            return 0;
        }
        int len = nums.length;
        int result = 0;
        int sum = 1;
        int lp = 0, rp = 0;
        while( true ){//与while( lp <= rp)等价，因为
            if(sum < k && rp < len){
                sum *= nums[rp++];
            } else {
                result += rp - lp;
                if(lp == len){
                    break;
                }
                sum /= nums[lp++];
            }
        }
        return result;
    }

    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        if(k <= 1) {
            return 0;
        }
        int len = nums.length;
        int result = 0;
        int sum = 1;
        int lp = 0;
        for (int rp = 0; rp < len; rp++) {
            sum *= nums[rp];
            while (sum >= k){
                sum /= nums[lp++];
            }
            result += rp - lp + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK2(new int[]{1,1,1}, 1));
    }
}
