package leetCode.reduceRange;

import java.util.Stack;

//接雨水
public class TrappingRainWater42 {
    //双指针的方法，时间O(n)，空间O(1)
    public int trap1(int[] height) {
        int pl = 0;
        int pr = height.length - 1;
        int lmax = height[pl];
        int rmax = height[pr];
        int sum = 0;
        while(pl < pr){
            if(lmax < rmax){
                sum += lmax - height[pl];
                pl++;
                lmax = Math.max(lmax, height[pl]);
            } else{
                sum += rmax - height[pr];
                pr--;
                rmax = Math.max(rmax, height[pr]);
            }
        }
        return sum;
    }

    //双数组的方法，时间O(n)，空间O(n)
    public int trap2(int[] height) {
        int len = height.length;
        int[] lMax = new int[len];
        int[] rMax = new int[len];
        int sum = 0;
        lMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            lMax[i] = Math.max(lMax[i-1], height[i]);
        }
        rMax[len-1] = height[len-1];
        for (int i = len-2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i+1], height[i]);
        }
        for (int i = 0; i < len; i++) {
            sum += Math.min(lMax[i], rMax[i])-height[i];
        }
        return sum;
    }

    //单向栈方法，时间O(n)，空间O(n)
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int p = 0;
        //找v
        while(p < height.length){
            //1.找到了/
            while(!stack.isEmpty() && height[stack.peek()] < height[p]){
                int curIndex = stack.pop();
                //2.找\
                while(!stack.isEmpty() && height[stack.peek()] == height[curIndex]){
                    stack.pop();
                }
                //2.找到了\
                if(!stack.isEmpty()){
                    int pl = stack.peek();
                    sum += (p - pl - 1) * (Math.min(height[pl], height[p]) - height[curIndex]);
                }
            }
            stack.push(p++);
        }
        return sum;
    }
}
