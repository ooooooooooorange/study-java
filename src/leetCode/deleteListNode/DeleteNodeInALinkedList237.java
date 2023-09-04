package leetCode.deleteListNode;

import leetCode.reverseLinkedList.ListNode;
//删除链表中的节点
public class DeleteNodeInALinkedList237 {

    //因为只知道删除节点，而删除节点需要头节点
    //1.普通删除需要从头节点遍历到删除节点的pre节点，但题目里做不到
    //2.脑筋急转弯：题目对删除的定义只是删除该节点的值，也就是说只要那个值被删掉就行了，而不是只能善那个节点
    //所以问题转换成了：把下一个节点next的值copy过来，然后其实删的是next节点。
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
