package leetCode.binarySearch;
//在排序数组中查找元素的第一个和最后一个位置
public class findFirstAndLastPositionOfElementInSortedArray34 {
    //时间O(log n)-O(n)，空间O(1)
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        //1.通过二分查找定位
        int pl = 0;
        int pr = nums.length-1;
        int pTarget = -1;
        while (pl <= pr){
//            int pm = (pl+pr)/2;//可能有溢出的问题
            int pm = pl + (pr-pl)/2 ;//可能有溢出的问题
            if(target == nums[pm]){
                pTarget = pm;
                break;
            } else if(target < nums[pm]){
                pr = pm - 1;
            } else {
                pl = pm + 1;
            }
        }
        if(pTarget == -1){
            return new int[]{-1,-1};
        }
        //2.左右滑动找位置
        int ptl = pTarget;
        while (ptl > 0 && nums[ptl-1] == target) ptl--;
        int ptr = pTarget;
        while (ptr < nums.length-1 &&nums[ptr+1] == target) ptr++;
        return new int[]{ptl,ptr};
    }

    //二分查俩次，分别得到两个边界
    //时间O(log n)，空间O(1)
    public static int[] searchRange2(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int ptl = binarySearchFirstIndex(nums, target);
        if(ptl == nums.length || nums[ptl] != target){//说明没找到，直接返回-1
            return new int[]{-1,-1};
        }
        int ptr = binarySearchFirstIndex(nums, target + 1) - 1;
        return new int[]{ptl,ptr};
    }

    //返回第一个 ≥ target 的下标，红蓝染色法
    // ≥ target 则为true，用蓝色表示，pr的右侧
    // ＜ target 则为false，用红色表示,pl的左侧
    public static int binarySearchFirstIndex(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        //1.通过二分查找定位
        int pl = 0;
        int pr = nums.length-1;
        while (pl <= pr){
//            int pm = (pl+pr)/2;//可能有溢出的问题
            int pm = pl + (pr-pl)/2 ;//可能有溢出的问题
            if(nums[pm] < target){//＜ target为false，pm为红，pl更新到pm右边。pl左侧都是红
                pl = pm + 1;
            } else {// ≥ target为true，pm为蓝，pr更新到pm左边。pr右侧都是蓝
                pr = pm - 1;
            }
        }
        return pl;
    }

    public static void main(String[] args) {
        searchRange2(new int[]{5,7,7,8,8,10}, 8);
    }
}
