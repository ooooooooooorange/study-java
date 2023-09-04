package leetCode.binaryTree;

import leetCode.ListNode;
import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/9/4 15:19
 */
//二叉树的最近公共祖先
public class LowestCommonAncestorOfABinaryTree236 {
    //用List存储fullPath，再取两条fullPath的最后相同节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = getFullPath(root, p.val);
        List<TreeNode> qList = getFullPath(root, q.val);
        Iterator pIterator = pList.iterator();
        Iterator qIterator = qList.iterator();
        TreeNode sameNode = null;
        while (pIterator.hasNext() && qIterator.hasNext()) {
            TreeNode pNode = (TreeNode)pIterator.next();
            TreeNode qNode = (TreeNode)qIterator.next();
            if (pNode != qNode) {
                break;
            }
            sameNode = pNode;
        }
        return sameNode;
    }

    //后序遍历获取路径
    public List<TreeNode> getFullPath(TreeNode root, int target) {
        //结束条件
        if (root == null) {
            return null;
        }
        //左
        List<TreeNode> fullPath = getFullPath(root.left, target);
        if (fullPath != null) {
            fullPath.add(0, root);
            return fullPath;
        }
        //右
        fullPath = getFullPath(root.right, target);
        if (fullPath != null) {
            fullPath.add(0, root);
            return fullPath;
        }
        //后
        if (root.val == target) {
            return new LinkedList<TreeNode>() {{
                add(root);
            }};
        } else {
            return null;
        }
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        ListNode pList = getFullPath1(root, p.val);
        ListNode qList = getFullPath1(root, q.val);
        System.out.println(pList);
        System.out.println(qList);
        TreeNode cur = root;
        while (pList != null && pList.val != 0 && qList != null && qList.val != 0) {
            if (pList.val == qList.val) {
                if (pList.val == -1) {
                    cur = root.left;
                } else if (pList.val == 1) {
                    cur = cur.right;
                }
                pList = pList.next;
                qList = qList.next;
            } else {
                break;
            }
        }
        return cur;
    }

    //后序遍历获取路径
    public ListNode getFullPath1(TreeNode root, int target) {
        //结束条件
        if (root == null) {
            return null;
        }
        //左
        ListNode fullPath = getFullPath1(root.left, target);
        if (fullPath != null) {
            return ListNode.addHead(fullPath, -1);
        }
        //右
        fullPath = getFullPath1(root.right, target);
        if (fullPath != null) {
            return ListNode.addHead(fullPath, 1);
        }
        //后
        if (root.val == target) {
            return new ListNode(0);
        } else {
            return null;
        }
    }



    //后序遍历：查找结果向上汇聚：
    //叶子节点：没找到，返回null，找到了p，返回p
    //向上汇聚：如果找到了q，返回q（如果找到p了，q就是pq的最近祖先），如果不是q：分四种情况
    //1.左右子树都没找到，返回null
    //2.左右子树都找到了，返回root
    //3.只有一边找到了，继续向上传递
    //证明：如果pq的fullPath是重叠的（情况3），在树的一边，必然会先找到p，再往上找到q，此时高的q会覆盖掉低的p，最近祖先就是q；
    //     如果pq的fullPath不是重叠的（情况2），在树的两边，那随着传递，必然会有汇合，汇合点就是最近祖先
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //结束条件
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        //左
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        //右
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        //后
        if(left != null && right != null){
            return root;
        } else if (left != null){
            return left;
        } else{
            return right;
        }
    }
}
