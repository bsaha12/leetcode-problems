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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = curr.next;

        while (curr != null && next != null) {
            if (curr.val == next.val) {

                prev.next = next;
            } else {
                prev = prev.next;
            }

            curr = curr.next;
            next = next.next;
        }

        return dummy.next;
    }
}