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
    public ListNode sortList(ListNode head) {
        // base condition 
        if(head == null || head.next == null){
            return head ;
        }

        // divide list into two parts
        ListNode fast = head ;
        ListNode slow = head ;

        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }

        ListNode first = head ;
        ListNode second = null ;
        if(slow != null){
            second = slow.next ;
            slow.next = null ;
        }

        // sort the first list
        first = sortList(first) ;

        // sort the second list
        second = sortList(second) ;

        // merge the list
        return mergeList(first , second) ;
    }///

    public ListNode mergeList(ListNode first , ListNode second){
        // if(first == null){
        //     return second ;
        // }

        // if(second == null){
        //     return first ;
        // }

        ListNode dummy = new ListNode() ;
        ListNode head = dummy ;
        ListNode ptr1 = first ;
        ListNode ptr2 = second ;
        while(ptr1 != null && ptr2 != null){
            if(ptr1.val <= ptr2.val){
                dummy.next = ptr1 ;
                ptr1 = ptr1.next ;
            }else{
               dummy.next = ptr2 ;
                ptr2 = ptr2.next ;
            }

            dummy = dummy.next ;
            dummy.next = null ;
        }

        if(ptr1 != null){
            dummy.next = ptr1 ;
        }

        if(ptr2 != null){
            dummy.next = ptr2 ;
        }

        return head.next ;
    }////
}