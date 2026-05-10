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
        Map<Integer,Node> map = new HashMap<>() ;
        return helper(node, map) ;
    }

    public Node helper(Node node, Map<Integer,Node> map){
        if(node == null) return null ;

        int currVal = node.val ;

        if(map.containsKey(currVal)) return map.get(currVal) ;

        Node root = new Node(currVal) ;
        map.put(currVal, root);

        List<Node> neighbors = new ArrayList<Node>();
        for(Node curr : node.neighbors){
            neighbors.add(helper(curr, map)) ;
        }

        root.neighbors = neighbors ;
        return root ;
    }
}