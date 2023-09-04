package leetCode.binaryTree;

import java.util.Stack;

//二叉树的最大深度
public class MaximumDepthOfBinaryTree104 {
    //递归实现
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //通过栈迭代实现
    public int maxDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }

        Stack<TreeNode> treeNodeStack = new Stack<>();
        root.val = 1;
        treeNodeStack.push(root);
        int height = 1;
        while (!treeNodeStack.isEmpty()){
            TreeNode node = treeNodeStack.pop();
            height = Math.max(height, node.val);
            if(node.left != null){
                node.left.val = node.val + 1;
                treeNodeStack.push(node.left);
            }
            if(node.right != null){
                node.right.val = node.val + 1;
                treeNodeStack.push(node.right);
            }
        }
        return height;
    }
}

