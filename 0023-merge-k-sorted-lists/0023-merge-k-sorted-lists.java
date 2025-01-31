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
        if(lists.length == 0){
            return null; 
        }
        if(lists.length == 1){
            return lists[0];
        }
        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode head = res;
        int cnt = 0;
        for(int i = 0;i < lists.length;i++){
            if(lists[i] == null){
                cnt += 1;
            }
        }
        while(cnt != lists.length){
            int mini = Integer.MAX_VALUE;
            int ind = -1;
            for(int i = 0;i < lists.length;i++){
                if(lists[i] != null && lists[i].val <= mini){
                    mini = lists[i].val;
                    ind = i;
                }
            }
            if(ind != -1){
                head.next = lists[ind];
                lists[ind] = lists[ind].next;
                head = head.next;
                if(lists[ind] == null){
                    cnt += 1;
                }
            }
        }
        return res.next;
    }
}