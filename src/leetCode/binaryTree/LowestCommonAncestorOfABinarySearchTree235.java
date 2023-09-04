package leetCode.binaryTree;

import leetCode.ListNode;
import leetCode.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/4 15:19
 */
//二叉搜索树的最近公共祖先
public class LowestCommonAncestorOfABinarySearchTree235 {
    //前序遍历（退化成循环，因为左和右只会有一条路能走）：如果当前节点就是p或q，那它就是最近祖先了，直接返回
    //1.pq在树的一边，继续遍历这一边
    //2.pq在树的两边，返回当前节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //结束条件
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        while(true){
            int val = root.val;
            if(p.val < val && q.val < val){
                root = root.left;
            } else if (p.val > val && q.val > val){
                root = root.right;
            } else{
                return root;
            }
        }
    }
}
