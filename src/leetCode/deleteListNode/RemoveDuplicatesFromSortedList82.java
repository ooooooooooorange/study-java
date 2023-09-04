package leetCode.deleteListNode;

import leetCode.reverseLinkedList.ListNode;

//删除排序链表中的重复元素Ⅱ
public class RemoveDuplicatesFromSortedList82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //因为要删除所以重复项，头节点是可能被删除的，所以需要哑节点
        ListNode myHead = new ListNode(-1, head);

        ListNode pre = myHead;
        ListNode cur = pre.next;
        while (cur.next != null){
            if(cur.val == cur.next.val){
                cur = cur.next;
            } else {
                if(pre.next != cur){//要删删一串
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            }
        }
        if(pre.next != cur){//对于尾部重复的情况，丢弃pre之后的重复项目
            pre.next = null;
        }
        return myHead.next;
    }
}
