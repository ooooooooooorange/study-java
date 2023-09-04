package leetCode.binarySearch;

//寻找旋转排序数组中的最小值
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int pl = -1;
        int pr = nums.length-1;
        while(pl + 2 < pr){
            int pm = pl + (pr-pl)/2;
            if(nums[pm] >= nums[pr]){
                pl = pm;
            }
            else {
                pr = pm+1;
            }
        }
        return nums[pl+1];
    }

    public static int findMin2(int[] nums) {
        int pl = 0;
        int pr = nums.length-2;
        while(pl <= pr){
            int pm = pl + (pr-pl)/2;
            if(nums[pm] > nums[nums.length-1]){//false，染红
                pl = pm + 1;
            }
            else{//true，染蓝
                pr = pm - 1;
            }
        }
        return nums[pl];
    }

    public static void main(String[] args) {
        findMin2(new int[]{4,5,6,7,0,1,2});
    }
}
