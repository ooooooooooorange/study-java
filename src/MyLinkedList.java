public class MyLinkedList {
    int val;
    int size;
    MyLinkedList next;
    MyLinkedList head;

    public MyLinkedList() {
        this.size = 0;
        this.val = -1;
        this.next = null;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        MyLinkedList p = head;
        for(int i = 0; i <= index; i++, p = p.next);
        return p.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        this.size++;
        if(size == 1)
        {
            this.head = new MyLinkedList();
            head.val = val;
            this.next = null;
            return;
        }

        MyLinkedList p = this;
        while(p.next != null)
        {
            p = p.next;
        }
        MyLinkedList node = new MyLinkedList();
        p.next = node;
        node.val = val;
    }

    public void addAtIndex(int index, int val) {
        if (index > size)
        {
            return;
        }
        if(size == 0)
        {
            this.size++;
            this.head = new MyLinkedList();
            head.val = val;
            this.next = null;
            return;
        }

        index = Math.max(0, index);
        MyLinkedList p = this;
        for(int i = 0;i < index; i++, p = p.next);
        if(index < size)
        {
            this.size++;
            MyLinkedList node = new MyLinkedList();
            node.next = p;
            node.val = val;
            head.next = node;
            this.next = node;
        }
        else
        {
            addAtTail(val);
        }

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        this.size--;

        MyLinkedList dummy = new MyLinkedList();
        dummy.next = this;

        int n = 0;
        MyLinkedList p = dummy;
        while(p != null)
        {
            if(n == index)
            {
                p.next = p.next != null? p.next.next : null;
            }
            n++;
        }
        this.val = dummy.next.val;
        this.next = dummy.next.next;
    }

    public class Point {
        private int x;
        private int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public double distance(Point point){
            return Math.sqrt(Math.pow(this.x-point.getX(),2)
                    +Math.pow(this.y-point.getY(), 2));
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        public String toString() {
            return "("+x+","+y+")";
        }
    }
}
