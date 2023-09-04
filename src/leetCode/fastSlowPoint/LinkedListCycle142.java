package leetCode.fastSlowPoint;

import leetCode.ListNode;

//环形链表Ⅱ
public class LinkedListCycle142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        boolean hasCircle= false;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){//确认有环
                hasCircle = true;
                break;
            }
        }
        if (!hasCircle){
            return null;
        }

        //找入口
        ListNode slow2 = head;
        while (slow != slow2){
            slow = slow.next;
            slow2 = slow2.next;
        }
        return slow;
    }
}
