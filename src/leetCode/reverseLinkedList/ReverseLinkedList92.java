package leetCode.reverseLinkedList;
//反转链表Ⅱ
public class ReverseLinkedList92 {
    //通过在head前加一个哑节点，来规避特殊情况的处理
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right){
            return head;
        }

        //通过在head前加一个哑节点，来规避特殊情况的处理
        ListNode myHead = new ListNode(-1, head);
        ListNode leftPre = myHead;
        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
        }

        ListNode cur = leftPre.next;
        ListNode pre = null;
        ListNode next = null;
        for (int i = 0; i < right - left + 1; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        leftPre.next.next = cur;
        leftPre.next = pre;

        return myHead.next;
    }
}
