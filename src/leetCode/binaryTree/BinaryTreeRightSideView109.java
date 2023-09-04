package leetCode.binaryTree;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/4 11:54
 */
//二叉树的右视图
public class BinaryTreeRightSideView109 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return new ArrayList<>();
        }
        getDepth(root, 0, result);
        return result;
    }

    public void getDepth(TreeNode root, int depth, List<Integer> result) {
        if (root == null){
            return ;
        }
        if(depth == result.size()){
            result.add(root.val);
        }
        getDepth(root.right, depth + 1, result);
        getDepth(root.left, depth + 1, result);
    }
}
