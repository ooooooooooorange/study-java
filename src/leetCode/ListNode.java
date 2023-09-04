package leetCode;

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

    public static ListNode addHead(ListNode head, int val){
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        return newNode;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        ListNode p = this;
        while (p != null){
            sb.append(p.val);
            sb.append("->");
            p = p.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
