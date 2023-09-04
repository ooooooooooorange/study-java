package leetCode.reverseLinkedList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public int getListSize(){
        int size = 0;
        ListNode p = this;
        while (p != null){
            size++;
            p = p.next;
        }
        return size;
    }
}
