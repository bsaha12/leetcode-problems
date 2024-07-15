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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> childSet = new HashSet<>() ;
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int[] arr : descriptions) {
            int parent = arr[0];
            int child = arr[1];
            childSet.add(child) ;

            TreeNode parentNode = map.containsKey(parent) ? map.get(parent) : new TreeNode(parent);
            TreeNode childNode = map.containsKey(child) ? map.get(child) : new TreeNode(child);

            if (arr[2] == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            map.put(parent, parentNode);
            map.put(child, childNode);

        }
        TreeNode root = null ;
        for(Integer nodeVal : map.keySet()){
            if(!childSet.contains(nodeVal) ){
                root = map.get(nodeVal) ;
                break ;
            }
        }
        return root ;

    }
}