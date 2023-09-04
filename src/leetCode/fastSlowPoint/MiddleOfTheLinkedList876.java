package leetCode.fastSlowPoint;

import leetCode.reverseLinkedList.ListNode;

//链表的中间结点
public class MiddleOfTheLinkedList876 {
    public ListNode middleNode(ListNode head) {
        //if(head.next == null || head.next.next == null){//长度偶数时，少循环一轮，slow为靠前那个
        if(head == null || head.next == null){//长度偶数时，多循环一轮，slow为靠后那个
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
