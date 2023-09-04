package leetCode.binaryTree;

import leetCode.TreeNode;

//相同的树
public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //结束递归的条件
        if (p == null || q == null){
//            if(p == null && q == null){
//                return true;
//            } else {
//                return false;
//            }
            //这一段可以简写成
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
