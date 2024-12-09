/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Map<Integer , Node> map = new HashMap<>() ;
        return helper(node , map) ;
    }//
    public Node helper(Node node , Map<Integer , Node> map){
        Node currCopy = map.get(node.val) ; 
        if(currCopy != null) return currCopy ;

        
        List<Node> neighbors = node.neighbors ;
        int val = node.val ;
        ArrayList<Node> copyNeighbors = new ArrayList<>() ;
        Node copyNode = new Node(val , copyNeighbors) ;
        map.put(val , copyNode) ;
        for(Node nextNeighbor : neighbors){
            copyNeighbors.add(helper(nextNeighbor , map)) ;
        }
        return copyNode ;
    }
}