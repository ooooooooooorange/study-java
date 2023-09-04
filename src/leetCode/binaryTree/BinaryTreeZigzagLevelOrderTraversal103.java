package leetCode.binaryTree;

import leetCode.TreeNode;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/4 17:33
 */
//二叉树的锯齿形层序遍历
public class BinaryTreeZigzagLevelOrderTraversal103 {
    //BFS：通过队列实现
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean isLeft = true;
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            if(isLeft){//从左往右
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.remove();//从头读
                    level.add(node.val);
                    if(node.left != null) deque.add(node.left);
                    if(node.right != null) deque.add(node.right);
                }
            } else {//从右往左
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.removeLast();//从尾取
                    level.add(node.val);
                    if(node.right != null) deque.addFirst(node.right);//加在头：先右后左
                    if(node.left != null) deque.addFirst(node.left);
                }
            }
            //if(!isLeft) Collections.reverse(level);或者直接调用翻转方法
            result.add(level);
            isLeft = !isLeft;
        }
        return result;
    }
}
