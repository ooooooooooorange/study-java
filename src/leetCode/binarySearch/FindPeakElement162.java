package leetCode.binarySearch;
//寻找峰值
public class FindPeakElement162 {
    //返回山峰的下标，红蓝染色
    // ≥ 山峰或锋右侧 则为true，用蓝色表示，pr的右侧
    // ＜ 山峰左侧 则为false，用红色表示,pl的左侧
    //闭区间[pl,pr]
    public int findPeakElement(int[] nums) {
        //1.通过二分查找定位
        int pl = 0;
        int pr = nums.length-2;//因为nums.length-1一定是蓝色，所以从nums.length-2开始
        while (pl <= pr){
            int pm = pl + (pr-pl)/2;
            if(nums[pm] < nums[pm+1]){//＜ 山峰左侧为false，pm为红，pl更新到pm右边。pl左侧都是红
                pl = pm + 1;
            } else {// ≥ 山峰或锋右侧为true，pm为蓝，pr更新到pm左边。pr右侧都是蓝
                pr = pm - 1;
            }
        }
        return pl;//返回pl或pr+1
    }

    //左闭右开[pl,pr)
    public int findPeakElement2(int[] nums) {
        //1.通过二分查找定位
        int pl = 0;
        int pr = nums.length-1;//[0,nums.length-1)
        while (pl < pr){
            int pm = pl + (pr-pl)/2;
            if(nums[pm] < nums[pm+1]){//＜ 山峰左侧为false，pm为红，pl更新到pm右边。pl左侧都是红
                pl = pm + 1;
            } else {// ≥ 山峰或锋右侧为true，pm为蓝，pr更新到pm左边。pr右侧都是蓝
                pr = pm;
            }
        }
        return pl;//pl==pr,返回哪个都行
    }

    //开区间(pl,pr)
    public int findPeakElement3(int[] nums) {
        //1.通过二分查找定位
        int pl = -1;
        int pr = nums.length-1;//(-1,nums.length-1)
        while (pl + 1 < pr){
            int pm = pl + (pr-pl)/2;
            if(nums[pm] < nums[pm+1]){//＜ 山峰左侧为false，pm为红，pl更新到pm右边。pl左侧都是红
                pl = pm;
            } else {// ≥ 山峰或锋右侧为true，pm为蓝，pr更新到pm左边。pr右侧都是蓝
                pr = pm;
            }
        }
        return pr;//返回pr或pl-1
    }
}
