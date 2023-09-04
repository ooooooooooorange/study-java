package leetCode.reverseLinkedList;
//反转链表
public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pCur = head;
        ListNode pNext;
        ListNode pPre = null;
        while (pCur != null){
            pNext = pCur.next;
            pCur.next = pPre;
            pPre = pCur;
            pCur = pNext;
        }
        return pPre;
    }
}
