package leetCode.reduceRange;

//盛最多水的容器
public class ContainerWithMostWater11 {
    //缩减搜素空间的思想：时间O(n)，空间O(1)
    public int maxArea(int[] height) {
        int lp = 0, rp = height.length-1;
        int max = 0;
        while (lp < rp){
            max = Math.max(max, Math.min(height[lp], height[rp]) * (rp-lp));
            if(height[lp] < height[rp]){
                lp++;
            }
            else {
                rp--;
            }
        }
        return max;
    }
}
