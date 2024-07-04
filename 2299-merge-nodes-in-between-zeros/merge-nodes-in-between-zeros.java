/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode prev = head ;
        ListNode curr = head.next ;
        while (curr != null) {
            if (curr.val != 0) {
                sum += curr.val;
            } else {
                prev.val = sum ;
                if(curr.next == null){
                    prev.next = null ;
                }
                prev = prev.next ;
                sum = 0;
            }
            curr = curr.next;
        }
        return head;
    }///
}