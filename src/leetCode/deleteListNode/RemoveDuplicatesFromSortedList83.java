package leetCode.deleteListNode;

import leetCode.ListNode;

//删除排序链表中的重复元素
public class RemoveDuplicatesFromSortedList83 {
    //要删删一串
    public ListNode deleteDuplicates(ListNode head) {
        //因为但凡头节点就重复了，可以选择删后面的；所以可以规避删头节点的情况，不用哑节点
        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null){
            if(cur.val == pre.val){
                cur = cur.next;
            } else {//要删删一串
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        pre.next = null;//对于尾部重复的情况，丢弃pre之后的重复项目
        return head;
    }

    //重复一个删一个
    public ListNode deleteDuplicates2(ListNode head) {
        //因为但凡头节点就重复了，可以选择删后面的；所以可以规避删头节点的情况，不用哑节点
        if(head == null || head.next == null){
            return head;
        }

        ListNode cur = head;
        while (cur.next != null){
            //重复一个删一个
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }


}
