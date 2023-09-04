package leetCode.binaryTree;

import leetCode.TreeNode;

//平衡二叉树
public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        if (leftHeight == -1){
            return -1;
        }
        int rightHeight = maxDepth(root.right);
        if (rightHeight == -1){
            return -1;
        }
        //如果左右子树高度差大于1，则不再平衡，用返回-1表示
        return (Math.abs(leftHeight - rightHeight) > 1)? -1 : Math.max(leftHeight, rightHeight) + 1;
    }
}
