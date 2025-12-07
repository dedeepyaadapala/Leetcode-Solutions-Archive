/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node th = head;
        Node temp = null;
        while(head != null){
            if(!map.containsKey(head)){
                map.put(head,new Node(head.val));
            }
            temp = map.get(head);
            if(head.next != null){
                map.putIfAbsent(head.next,new Node(head.next.val));
                temp.next = map.get(head.next);
            }

            if(head.random != null){
                map.putIfAbsent(head.random,new Node(head.random.val));
                temp.random = map.get(head.random);
            }
            head = head.next;
            temp = temp.next;
        }
        return map.get(th);
    }
}