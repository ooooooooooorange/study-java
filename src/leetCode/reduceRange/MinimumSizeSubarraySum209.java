package leetCode.reduceRange;

//长度最小子串（因为是正整数，所以求和满足单调性）
public class MinimumSizeSubarraySum209 {
    //暴力：时间O(n^2)，空间O(1)
    public static int minSubArrayLen1(int target, int[] nums) {
        int len = nums.length;
        int minLen = len;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int j = i;
            sum = 0;
            while(j < len && sum < target){
                sum += nums[j++];
            }
            if(sum >= target){
                minLen = Math.min(minLen, j-i);
                continue;
            }
            if(j == len){
                if(i == 0){
                    return 0;
                }
                break;
            }
        }
        return minLen;
    }

    //缩减搜素空间的思想：时间O(n)，空间O(1)
    public static int minSubArrayLen2(int target, int[] nums) {
        int len = nums.length;
        int minLen = len+1;
        int sum = 0;
        int lp = 0, rp = 0;
        while( true ){//与while( lp <= rp)等价，因为
            if(sum < target){
                if(rp == len){
                    break;
                }
                sum += nums[rp++];
            } else {
                minLen = Math.min(minLen, rp - lp);
//                if(lp == len){
//                    break;
//                }
                sum -= nums[lp++];
            }
        }
        return minLen == len + 1 ? 0 : minLen;
    }

    //滑动窗口
    public static int minSubArrayLen3(int target, int[] nums) {
        int len = nums.length;
        int minLen = len+1;
        int sum = 0;
        int lp = 0;
        for (int rp = 0; rp < len; rp++) {
            sum += nums[rp];
            while (sum - nums[lp] >= target){
                sum -= nums[lp++];
            }
            if(sum >= target){
                minLen = Math.min(minLen, rp - lp + 1);
            }
        }
        return minLen == len + 1 ? 0 : minLen;
    }

    public static void main(String[] args) {
        minSubArrayLen3(7, new int[]{2,3,1,2,4,3});
    }
}
