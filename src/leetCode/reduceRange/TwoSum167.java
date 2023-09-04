package leetCode.reduceRange;

//两数之和（升序）
public class TwoSum167 {
    //缩减搜素空间的思想：时间O(n)，空间O(1)
    public int[] twoSum(int[] numbers, int target) {
        int lp = 0, rp = numbers.length-1;
        while (lp < rp){
            int sum = numbers[lp] + numbers[rp];
            if(sum < target){
                lp++;
            }
            else if ( sum > target){
                rp--;
            }
            else {
                return new int[]{lp+1, rp+1};
            }
        }
        return null;
    }
}
