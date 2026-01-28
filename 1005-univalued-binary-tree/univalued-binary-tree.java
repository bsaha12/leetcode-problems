/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true ;

        int val = root.val ;
        TreeNode left = root.left ;
        TreeNode right = root.right ;

        boolean result = true ;

        // left check
        if(left != null){
            if(left.val != val) return false ;
            result = result && isUnivalTree(left) ;
        }

        // right check
        if(right != null){
            if(right.val != val) return false ;
            result = result && isUnivalTree(right) ;
        }

        return result ;
    }
}