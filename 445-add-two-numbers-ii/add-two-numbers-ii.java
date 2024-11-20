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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>() ; // l1
        Stack<Integer> st2 = new Stack<>() ; // l2

        while(l1 != null){
            st1.push(l1.val) ;
            l1 = l1.next ;
        }
        while(l2 != null){
            st2.push(l2.val) ;
            l2 = l2.next ;
        }

        ListNode sum = null ;
        int carry = 0 ;
        while(!st1.isEmpty() || !st2.isEmpty()){
            int val1 = 0 ;
            int val2 = 0 ;
            if(!st1.isEmpty()){
                val1 = st1.pop() ;
            }
            if(!st2.isEmpty()){
                val2 = st2.pop() ;
            }

            int total = val1 + val2 + carry ;
            int nodeVal = total % 10 ;
            carry = total / 10 ;
            ListNode curr = new ListNode(nodeVal , sum) ;
            sum = curr ;
        }

        if(carry > 0){
          ListNode curr = new ListNode(carry , sum) ;  
          sum = curr ;
        }

        return sum ;

    }
}