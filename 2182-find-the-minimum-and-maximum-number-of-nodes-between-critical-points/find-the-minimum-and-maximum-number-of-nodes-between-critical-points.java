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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = {-1 , -1} ;
        int prev = head.val ;
        int firstCritical = -1 ;
        int prevCritical = -1 ; 
        head = head.next ;
        int i = 1 ;
        int minDistance = Integer.MAX_VALUE ;
        while(head.next != null){
            int curr = head.val ;
            int next = head.next.val ;
            if( (curr > prev && curr > next) || (curr < prev && curr < next) ){
                if(firstCritical == -1){
                    firstCritical = i ;
                }else{
                    minDistance = Math.min(minDistance ,i -  prevCritical);
                }
                prevCritical = i ;
            }
            prev = curr ;
            i++ ;
            head = head.next ;
        }

        if(prevCritical == firstCritical ){
            return new int[]{-1 , -1} ;
        }

        return new int[]{minDistance , prevCritical - firstCritical } ;
    }///
}