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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        while(head != null && set.contains(head.val)){
            head = head.next;
        }
        ListNode th = head;
        while(th != null){
            ListNode temp = th;
            while(temp != null && temp.next != null && set.contains(temp.next.val)){
                temp = temp.next;
            }
            th.next = temp.next;
            th = th.next;
        }
        return head;
    }
}