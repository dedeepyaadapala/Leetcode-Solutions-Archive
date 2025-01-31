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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = head.next,temp= null;
        while(head != null && head.next != null){
            ListNode t = head.next;
            if(temp != null){
                temp.next = t;
            }
            head.next = head.next.next;
            t.next = head;
            temp = head;
            head = head.next;
        }
        return res;
    }
}