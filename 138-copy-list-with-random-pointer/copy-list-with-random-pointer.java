/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head ;

        // map initialization
        Map<Node , Node> map = new HashMap<>() ;
        map.put(null , null) ;
        Node dummy = new Node(0) ;
        Node copyList = dummy ;
        Node ptr = head ;
        while(ptr != null){
            Node original = ptr ;
            Node copy = new Node(ptr.val) ;
            dummy.next = copy ;
            map.put(original , copy) ;
            ptr = ptr.next ;
            dummy = dummy.next ;
        }

        // one more loop to get random pointers populated
        ptr = head ;
        Node dummyPtr = copyList.next ; 
        while(ptr != null){
            Node random = ptr.random ;
            dummyPtr.random = map.get(random) ;

            ptr = ptr.next ;
            dummyPtr = dummyPtr.next ;
        }

        return copyList.next ;
    }
}