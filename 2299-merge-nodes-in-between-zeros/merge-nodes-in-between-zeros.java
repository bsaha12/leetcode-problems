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
    public ListNode mergeNodes(ListNode head) {
        List<Integer> list = new ArrayList<>() ;
        int sum = 0 ;
        head = head.next ;
        while(head != null){
            if(head.val != 0){
                sum += head.val ;
            }else{
                list.add(sum) ;
                sum = 0;
            }
            head = head.next ;
        }

        ListNode result = new ListNode() ;
        ListNode curr = result ;
        for(Integer num : list){
            ListNode temp = new ListNode(num) ;
            curr.next = temp ;
            curr = temp ;
        }
        return result.next ;
    }///
}