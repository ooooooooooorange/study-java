package leetCode.binaryTree;

import leetCode.TreeNode;

import java.util.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/4 17:33
 */
//二叉树的层序遍历
public class BinaryTreeLevelOrderTraversal102_BFS {
    //BFS：通过队列实现
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.remove();
                level.add(node.val);
                if(node.left != null) deque.add(node.left);
                if(node.right != null) deque.add(node.right);
            }
            result.add(level);
        }
        return result;
    }
}
