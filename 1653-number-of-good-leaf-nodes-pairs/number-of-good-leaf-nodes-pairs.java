/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    Map<TreeNode , TreeNode> map ;
    public int countPairs(TreeNode root, int distance) {
        if (distance == 1){
            return 0;
        }
        map = new HashMap<>() ;
        List<TreeNode> leaves = new ArrayList<>();
        DFS(root, leaves, null);

        int result = 0;
        for (TreeNode curr : leaves) {
            Set<TreeNode> visited = new HashSet<>();
            result += countPairsByDfs(curr, 0, visited, distance);
        }
        return result / 2;
    }////

    int countPairsByDfs(TreeNode root , int distance , Set<TreeNode> visited , int max ){
        if(root == null) return 0 ;
        if(distance > max) return 0 ;
        if(visited.contains(root) ) return 0 ;

        visited.add(root) ;

        if(distance != 0 && root.left == null && root.right == null){
            return 1 ;
        }

        int result = 0 ;
        result += countPairsByDfs(root.left , distance + 1 , visited , max) ;
        result += countPairsByDfs(root.right , distance + 1 , visited , max) ;
        result += countPairsByDfs(map.get(root) , distance + 1 , visited , max) ;

        return result ;

    }////

    void DFS(TreeNode root, List<TreeNode> leaves, TreeNode parent) {
        if (root == null)
            return;

        map.put(root , parent) ;

        if (root.left == null && root.right == null) {
            leaves.add(root);
            return;
        }

        DFS(root.left, leaves, root);
        DFS(root.right, leaves, root);
    }/////
}