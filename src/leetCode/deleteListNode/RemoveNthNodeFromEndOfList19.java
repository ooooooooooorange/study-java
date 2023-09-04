package leetCode.deleteListNode;

import leetCode.ListNode;

//删除链表的倒数第 N 个结点

public class RemoveNthNodeFromEndOfList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //通过在head前加一个哑节点，来规避特殊情况的处理(删除头节点)
        ListNode myHead = new ListNode(-1, head);

        //1.快慢指针找到倒数第 N 个结点 的pre节点
        ListNode slow = myHead;
        ListNode fast = myHead;
        //让fast比slow领先n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while(fast.next != null){//提早一步停下，所以slowPre指向倒数第 N 个结点 的pre
            slow = slow.next;
            fast = fast.next;
        }

        ListNode pre = slow;
        //2.删节点
        pre.next = pre.next.next;
        return myHead.next;
    }
}
