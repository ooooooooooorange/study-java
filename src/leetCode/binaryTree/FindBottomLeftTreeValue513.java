package leetCode.binaryTree;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/4 11:54
 */
//找树左下角的值
public class FindBottomLeftTreeValue513 {
    //层序遍历，最后一层的第一个就是
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> bottomLevel = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            bottomLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.remove();
                bottomLevel.add(node.val);
                if(node.left != null) deque.add(node.left);
                if(node.right != null) deque.add(node.right);
            }
        }
        return bottomLevel.get(0);
    }

    //层序遍历，从右至左，最后一个数就是左下角（时间换空间，不用存最后一层了）
    public int findBottomLeftValue2(TreeNode root) {
        TreeNode node = new TreeNode();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            node = deque.remove();
            if(node.right != null) deque.add(node.right);
            if(node.left != null) deque.add(node.left);
        }
        return node.val;
    }
}
