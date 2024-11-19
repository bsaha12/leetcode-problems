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
        if(head == null || head.next == null){
            return head ;
        }
        ListNode prevPointer = new ListNode() ;
        prevPointer.next = head ;
        ListNode prev = prevPointer ;
        ListNode curr = head ;
        ListNode next = curr.next ;

        while(curr != null && next != null ){
            prev.next = next ;
            curr.next = next.next ;
            next.next = curr ;

            prev = curr ;
            curr = curr.next ;
            if(curr != null){
                next = curr.next ;
            }
        }
        return prevPointer.next ;
    }////
}