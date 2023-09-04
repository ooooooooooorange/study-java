package leetCode.binarySearch;
//搜索旋转排序数组
public class SearchInRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int pl = 0;
        int pr = nums.length -1;
        int lastNum = nums[nums.length-1];
        while(pl <= pr){
            int pm = pl+(pr-pl)/2;
            if((nums[pm] <= lastNum && (target <= nums[pm] || target > lastNum)) ||
            (nums[pm] > lastNum && target <= nums[pm] && target > lastNum)){
                pr = pm - 1;
            } else {
                pl = pm + 1;
            }
        }
        return pl == nums.length || nums[pl] != target ? -1 : pl;
    }
}
