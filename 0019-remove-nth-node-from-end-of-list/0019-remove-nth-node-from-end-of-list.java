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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode th = head;
        while(th != null){
            len++;
            th = th.next;
        }
        th = head;
        if(len == n) return head.next;
        for(int i = 0;i < len - n - 1;i++){
            th = th.next;
        }
        th.next = th.next.next;
        return head;
    }
}