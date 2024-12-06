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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head ;
        Map<Integer , Integer> map = new HashMap<>() ;
        ListNode ptr = head ;
        while(ptr != null){
            Integer val = ptr.val ;
            map.put(val , map.getOrDefault(val , 0) + 1 ) ;
            ptr = ptr.next ;
        }

        ListNode dummy = new ListNode(0 , head) ;
        ListNode prev = dummy ;
        ListNode curr = head ;

        while(curr != null){
            if(map.get(curr.val) > 1){
                prev.next = curr.next ;
            }else{
                prev = prev.next ;
            }
            curr = curr.next ;
        }

        return dummy.next ;

    }
}