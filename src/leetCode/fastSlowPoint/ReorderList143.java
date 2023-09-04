package leetCode.fastSlowPoint;

import leetCode.reverseLinkedList.ListNode;

//重排链表
public class ReorderList143 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        //找到中间点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //中间截断形成两个链表，表1<=表2
        ListNode head2 = slow;//这里有个骚操作是没有截断，容易出问题，看后面


        //表2翻转
        ListNode pCur = head2;
        ListNode pNext;
        ListNode pPre = null;
        while (pCur != null){
            pNext = pCur.next;
            pCur.next = pPre;
            pPre = pCur;
            pCur = pNext;
        }
        head2 = pPre;

        //两个子链表交替合并
        ListNode next1;
        ListNode next2;
        while (head2.next != null){//结束时间很关键
            next1 = head.next;
            next2 = head2.next;

            head.next = head2;
            head2.next = next1;

            head = next1;
            head2 = next2;
        }
        //一个隐雷是表1的尾部还和表2尾部相连的，没有截断，分别验证（还是太巧合了，不便于理解其实）
        //如果偶数，表1表2一样长，那最后表1剩1节点，表2剩1节点时就停止循环了，此时恰好让head1和head2是接上的。
        //如果奇数，表1比表2短1，那最后head1为空，表2剩1节点时就停止循环了：最后一轮循环时，head2尾借着连接接回了自己，之后head1恰好重置了，因此不会有问题

    }
}
