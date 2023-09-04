package leetCode.binaryTree;

import javafx.util.Pair;
import leetCode.TreeNode;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/4 12:10
 */
//验证二叉搜索树
//入参传递root，返回值传递boolean结果
//前序遍历：信息由上往下传递，所以通过方法入参传递，最开始调用的时候就传入初始化值
//中序遍历：信息由左往右传递，所以通过外部参数传递，最开始调用的时候就设置初始化值
//后序遍历：信息由下往上汇聚，所以通过方法返回值传递，叶子节点返回初始化值（注意，返回值要同时表示boolean结果）

public class ValidateBinarySearch98 {
    //前序遍历：把节点的范围往下传，从全集开始，不断缩小子节点val的左右边界
    public boolean isValidBST1(TreeNode root) {
        return check1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean check1(TreeNode root, Long left, Long right){
        //结束条件
        if(root == null){
            return true;
        }
        Long val = (long) root.val;
//        //前：检查在不在范围里
//        //如果不在，返回false
//        //如果在，缩小范围，继续递归
//        if(val < left || val > right){
//            return false;
//        }
//        //左
//        if(!check1(root.left, left, val)){
//            return false;
//        }
//        //右
//        if(!check1(root.right, val, right)){
//            return false;
//        }
//        return true;
        //上一段可以简写:
        return val > left && val < right && check1(root.left, left, val) && check1(root.right, val, right);
    }


    //中序遍历：按照遍历顺序严格递增，所以需要和上一个节点比较大小
    Long preVal = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        //结束条件
        if(root == null){
            return true;
        }
        Long val = (long) root.val;
        //左
        if (!isValidBST2(root.left)){//左子树不满足,返回false提前结束
            return false;
        }
        //中
        if (val <= preVal){
            return false;
        }
        preVal = val;
        //右
        return isValidBST2(root.right);
    }


    //后序遍历：把节点的范围往上传，从空集开始，不断扩大父节点val的左右边界
    public boolean isValidBST3(TreeNode root) {
        Pair<Long, Long> result = check3(root);
        return !result.equals(new Pair<>(Long.MIN_VALUE, Long.MAX_VALUE));//返回结果很难把握：用返回Long全集表示false（因为正常情况不可能会出现Long全集，顶多Int全集）
    }
    public Pair<Long, Long> check3(TreeNode root){
        //结束条件
        if(root == null ){
            return new Pair<>(Long.MAX_VALUE, Long.MIN_VALUE);//返回空集
        }
        Long val = (long) root.val;
        //左
        Pair<Long, Long> leftPair = check3(root.left);
        //右
        Pair<Long, Long> rightPair = check3(root.right);
        //中:检查在不在范围外面,如果在，缩小范围，继续递归,如果不在，返回全集代表false：
        // 下面分析三种情况：
        // 1.左右都不空：[leftMin, leftMax] [val] [rightMin, rightMax] ：如果leftMax<val<rightMin，为true，返回[leftMin, rightMax]
        // 2.左空右不空：leftMax=-inf [val] [rightMin, rightMax] leftMin=inf：如果val<rightMin，为true，返回[val, rightMax]
        // 3.左不空右空：rightMax=-inf [leftMin, leftMax] [val] rightMin=inf：如果leftMax<val，为true，返回[leftMin, val]
        // 综上，可以总结成：判断条件是：leftMax<val<rightMin；扩大范围为：[min(leftMin, val), max(val, rightMax)]
        if(val > leftPair.getValue() && val < rightPair.getKey()){//满足，扩大范围
            return new Pair<>(Math.min(leftPair.getKey(), val), Math.max(rightPair.getValue(), val));
        } else {
            return new Pair<>(Long.MIN_VALUE, Long.MAX_VALUE);//不满足，返回全集
        }
    }




    public static void main(String[] args) {
        ValidateBinarySearch98 validateBinarySearch98 = new ValidateBinarySearch98();
        //TreeNode treeNode = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        //TreeNode treeNode = new TreeNode(2147483647);
        TreeNode treeNode = new TreeNode(32, new TreeNode(26, new TreeNode(19, null, new TreeNode(27)), null), new TreeNode(47, null, new TreeNode(56)));
        System.out.println(validateBinarySearch98.isValidBST3(treeNode));
    }
}
