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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null) return head ;
        ListNode ptr1 = head ;
        ListNode ptr2 = head ;

        ListNode first = null ;
        ListNode second = null ;

        int distance = k ;
        //find first pointer
        while(distance > 1){
            ptr1 = ptr1.next ;
            distance-- ;
        }

        first = ptr1 ;

        //find second pointer
        while(ptr1.next != null){
            ptr1 = ptr1.next ;
            ptr2 = ptr2.next ;
        }

        second = ptr2 ;

        // System.out.println(first.val) ;
        // System.out.println(second.val) ;

        // swap between first and second
        int temp = first.val ;
        first.val = second.val ;
        second.val = temp ;


        return head ;

    }
}