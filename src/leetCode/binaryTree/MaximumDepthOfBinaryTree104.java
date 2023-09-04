package leetCode.binaryTree;

import leetCode.TreeNode;

import java.util.*;

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

    //通过队列实现：层序遍历BFS
    public int maxDepth3(TreeNode root) {
        if (root == null){
            return 0;
        }

        int height = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.remove();
                if(node.left != null) deque.add(node.left);
                if(node.right != null) deque.add(node.right);
            }
            height++;
        }
        return height;
    }
}

