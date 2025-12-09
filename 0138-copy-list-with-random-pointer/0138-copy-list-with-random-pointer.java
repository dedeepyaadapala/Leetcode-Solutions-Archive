class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node t1 = head;
        Node h = clone(head);
        Node t2 = h;
        while (t1 != null && t2 != null) {
            // Node nn=t1.next;
            // t1.next=t2;
            // Node nn2=t2.next;
            // t2.next=nn;
            // t1=nn;
            // t2=nn2;
            Node temp = t2.next;
            t2.next = t1.next;
            t1.next = t2;
            t1 = t1.next.next;
            t2 = temp;
        }
        // display(head);

        Node h1 = head;
        Node h2 = h;
        while (h2 != null && h1 != null) {
            if (h1.random != null) {
                h2.random = h1.random.next;
            }
            h1 = h1.next.next;
            if (h2.next != null)
                h2 = h2.next.next;
        }
        Node h3 = head;
        Node h4 = head.next;
        Node h5 = h4;
        while (h3 != null && h4 != null && h4.next != null) {
            h3.next = h4.next;
            h4.next = h3.next.next;
            h3 = h3.next;
            h4 = h4.next;
        }
        h3.next = null;
        if(h4 != null) h4.next = null;
        //display(h5);
        return h5;
    }

    void display(Node h) {
        while (h != null) {
            System.out.print(h.val);
            h = h.next;
        }
    }

    private Node clone(Node h) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (h != null) {
            dummy.next = new Node(h.val);
            dummy = dummy.next;
            h = h.next;
        }
        return temp.next;
    }
}