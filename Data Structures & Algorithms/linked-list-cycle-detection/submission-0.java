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
    public boolean hasCycle(ListNode head) {
        ListNode slowpointer = head;
        ListNode fastpointer = head;
        while(fastpointer != null && fastpointer.next != null){
            slowpointer = slowpointer.next;
            fastpointer = fastpointer.next.next;    
            if(slowpointer == fastpointer) return true;
        }
        return false;
    }
}
