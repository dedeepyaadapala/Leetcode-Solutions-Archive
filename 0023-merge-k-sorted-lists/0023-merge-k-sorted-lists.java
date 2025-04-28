/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        if(n == 1) return lists[0];
        PriorityQueue<ListNode> lst = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a,ListNode b){
                return Integer.compare(a.val,b.val);
            }
        });
        for(int i = 0;i < n;i++){
            ListNode prev = null;
            while(lists[i] != null){
                lst.add(lists[i]);
                prev = lists[i];
                lists[i] = lists[i].next;
                prev.next = null;
            }
        }
        ListNode head = lst.peek();
        ListNode th = null;
        while(!lst.isEmpty()){
            th = lst.poll();
            if(!lst.isEmpty()) th.next = lst.peek();
            th = th.next;
        }
        return head;
    }
}