package leetCode.reverseLinkedList;

//K 个一组翻转链表
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        //获取链表长度，计算出要反转几轮
        int size = 0;
        ListNode p = head;
        while (p != null){
            size++;
            p = p.next;
        }
        int times = size/k;

        //通过在head前加一个哑节点，来规避特殊情况的处理
        ListNode myHead = new ListNode(-1, head);
        ListNode p0 = myHead;

        ListNode cur = p0.next;
        ListNode pre = null;
        ListNode next = null;
        for (int i = 0; i < times; i++) {
            ListNode tail = cur;
            for (int j = 0; j < k; j++) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            p0.next = pre;
            p0 = tail;
            tail.next = cur;
        }
        return myHead.next;
    }

}
